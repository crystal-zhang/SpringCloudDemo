package org.crystal.controller;

import lombok.extern.slf4j.Slf4j;
import org.crystal.domain.Vouchers;
import org.crystal.service.VouchersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class VouchersController {
    @Autowired
    private VouchersService vouchersService;
    @PostMapping("exchange")
    public String exchange(@RequestBody Vouchers vouchers){
        String code = vouchers.getCode();
        log.info("商城券编码:{}",code);
        return vouchersService.exchange(code);
    }
}
