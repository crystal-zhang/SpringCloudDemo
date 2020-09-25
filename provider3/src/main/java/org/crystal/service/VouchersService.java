package org.crystal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.crystal.domain.Vouchers;

public interface VouchersService extends IService<Vouchers> {

    String exchange(String code);

    /**
     * 营销平台领取卡单
     * @param code
     * @return
     */
    String receiveCrad(String code) throws Exception;
}
