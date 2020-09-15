package org.crystal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.crystal.domain.Vouchers;

public interface VouchersService extends IService<Vouchers> {

    String exchange(String code);
}
