package com.iotmars.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: xsh
 * @date: 2021/1/8 11:16
 */
@Data
@TableName(value = "version")
@AllArgsConstructor
@NoArgsConstructor
public class VersionPO implements Serializable {
    private static final long serialVersionUID = 2763268540397916671L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "version")
    private String version;

    @TableField(value = "device_type")
    private String deviceType;


}
