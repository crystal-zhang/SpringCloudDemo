package org.crystal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.crystal.dao.VouchersDao;
import org.crystal.dao.VouinfoDao;
import org.crystal.domain.Vouinfo;
import org.crystal.service.VouinfoService;
import org.springframework.stereotype.Service;

@Service
public class VouinfoServiceImpl extends ServiceImpl<VouinfoDao, Vouinfo> implements VouinfoService {
}
