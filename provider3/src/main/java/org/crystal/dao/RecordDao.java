package org.crystal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.crystal.domain.Record;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordDao extends BaseMapper<Record> {
}
