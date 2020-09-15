package org.crystal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.annotation.Generated;
import java.time.LocalDateTime;

/**
 * 商城券购买记录
 */
@Data
public class Record {
@TableId(type = IdType.AUTO)
    private Integer id;

    private String code;

    private String name;

   private LocalDateTime createTime;

}
