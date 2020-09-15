package org.crystal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.crystal.dao.RecordDao;
import org.crystal.domain.Record;
import org.crystal.service.RecordService;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordDao, Record> implements RecordService {
}
