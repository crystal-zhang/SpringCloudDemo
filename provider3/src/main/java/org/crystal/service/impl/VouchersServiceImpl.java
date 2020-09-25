package org.crystal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.crystal.aop.TryAgain;
import org.crystal.dao.RecordDao;
import org.crystal.dao.VouchersDao;
import org.crystal.domain.Record;
import org.crystal.domain.Vouchers;
import org.crystal.domain.Vouinfo;
import org.crystal.service.VouchersService;
import org.crystal.service.VouinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class VouchersServiceImpl extends ServiceImpl<VouchersDao,Vouchers> implements VouchersService {
    @Autowired
    private VouchersDao vouchersDao;
    @Autowired
    private RecordDao recordDao;
    @Autowired
    private VouinfoService vouinfoService;
    /**
     * 根据商城券编码兑换商城券，一次兑换一张
     * @param code
     * @return
     */
    @Override
    @Transactional
    public  String exchange(String code) {
        //根据商城券编码查询商城券信息
        QueryWrapper<Vouchers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",code);
        Vouchers vouchers = vouchersDao.selectOne(queryWrapper);
        if(vouchers==null){
            return "未查询到商城券信息";
        }
        int restNum = vouchers.getRestNum();
        //判断余量
        if(restNum<1){
            return "商城券余量不足";
        }

        //减库存
        vouchers.setRestNum(restNum-1);
        log.info("更新的对象,{}",vouchers);
        boolean res = this.updateById(vouchers);
        log.info("更新结果:{}",res);
        //添加记录
        if(res){
            Record record = new Record();
            record.setCode(vouchers.getCode());
            record.setName(vouchers.getName());
            recordDao.insert(record);
        }

        return "兑换成功";
    }

    /**
     * 营销平台领取卡单
     *（卡单是有编号的）
     * @param code
     * @return
     */
    @Override
    @Transactional
    @TryAgain(max_retry = 3)
    public String receiveCrad(String code) throws Exception {
        //根据商城券编码查询商城券信息
        QueryWrapper<Vouchers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",code);
        Vouchers vouchers = vouchersDao.selectOne(queryWrapper);
        if(vouchers==null){
            return "未查询到商城券信息";
        }
        int restNum = vouchers.getRestNum();
        //判断余量
        if(restNum<1){
            return "商城券余量不足";
        }

        //减库存
        vouchers.setRestNum(restNum-1);

        log.info("更新的对象,{}",vouchers);
        boolean res = this.updateById(vouchers);
        log.info("更新结果:{}",res);

        //添加记录
        if(res){
            //分配一个编号
            QueryWrapper<Vouinfo> vouInfoWrapper = new QueryWrapper<>();
            vouInfoWrapper.eq("batch_code",code);
            vouInfoWrapper.eq("rece_flag","0");
            vouInfoWrapper.orderByAsc("card_code");
            List<Vouinfo> list = vouinfoService.list(vouInfoWrapper);
            Vouinfo vouinfo = list.get(0);
            vouinfo.setReceFlag("1");
            vouinfoService.updateById(vouinfo);

            Record record = new Record();
            record.setCode(vouchers.getCode());
            record.setName(vouchers.getName());
            record.setCardCode(vouinfo.getCardCode());
            recordDao.insert(record);
        }else {
            throw new Exception("更新库存失败。。。。。。。。。。。。。。。。。。");
        }

        return "兑换成功";
    }
}
