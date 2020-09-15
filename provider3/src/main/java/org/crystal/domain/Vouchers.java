package org.crystal.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * 商城券
 */
@Data
public class Vouchers {

    private Integer id;

    private String code;

    private String name;

    private int totalNum;

    private int restNum;
@Version

@TableField(fill = FieldFill.INSERT)
private Integer version;


}
