package org.crystal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 商城券基本信息
 */
@Data
public class Vouinfo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String cardCode;

    private String batchCode;

    private String receFlag;
}
