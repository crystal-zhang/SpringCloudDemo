package org.crystal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.crystal.domain.Vouchers;
import org.springframework.stereotype.Repository;

@Repository
public interface VouchersDao extends BaseMapper<Vouchers> {
}
