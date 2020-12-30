package com.iotmars.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 菜谱实体类
 *
 * @author Administrator
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 576327269779397918L;

    /**
     * 菜谱主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜谱名称
     */
    @TableField(value = "name")
    @Size(min = 1, max = 20, message = "最小长度为1,最大长度为20")
    @NotBlank(message = "菜谱名称不能为空")
    @NotEmpty(message = "菜谱名称不能为空")
    private String name;

    /**
     * 菜谱中图
     */
    @TableField(value = "middle_img")
    @NotBlank(message = "菜谱中图不能为空")
    @NotEmpty(message = "菜谱中图不能为空")
    private String middleImg;
    /**
     * 菜谱首图
     */
    @TableField(value = "head_img")
    @NotBlank(message = "菜谱首图不能为空")
    @NotEmpty(message = "菜谱首图不能为空")
    private String headImg;

    /**
     * 预计烹饪时间
     */
    @TableField(value = "tm")
    @NotBlank(message = "预计烹饪时间不能为空")
    @NotEmpty(message = "预计烹饪时间不能为空")
    private String tm;

    /**
     * 难度
     */
    @TableField(value = "deg")
    @NotBlank(message = "难度不能为空")
    @NotEmpty(message = "难度不能为空")
    private String deg;

    /**
     * 食材清单
     */
    @TableField(value = "fl")
    @NotBlank(message = "食材清单不能为空")
    @NotEmpty(message = "食材清单不能为空")
    private String fl;

    /**
     * 小贴士
     */
    @TableField(value = "tip")
    private String tip;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 视频模块
     */
    @TableField(value = "vd")
    private String vd;

    /**
     * 菜谱语音url
     */
    @TableField(value = "voice")
    private String voice;

    /**
     * 菜谱描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 绑定设备编号
     */
    @TableField(value = "device_mac")
    private String deviceMac;

    /**
     * 是否官方
     */
    @TableField(value = "is_official")
    private Boolean isOfficial;

    /**
     * 点赞数
     */
    @TableField(value = "support_points")
    private Integer supportPoints;

    /**
     * 收藏数
     */
    @TableField(value = "subscribe_points")
    private Integer subscribePoints;

    /**
     * 浏览数
     */
    @TableField(value = "browse_points")
    private Integer browsePoints;

    /**
     * 发布状态
     */
    @TableField(value = "publish_status")
    private Integer publishStatus;

    /**
     * 作者id
     */
    @TableField(value = "author_id")
    private String authorId;

    /**
     * 作者昵称
     */
    @TableField(value = "author_name")
    private String authorName;

    /**
     * 设备类型
     */
    @TableField(value = "device_type")
    private String deviceType;

    /**
     * 默认规格参数
     */
    @TableField(value = "default_parameter")
    private Integer defaultParameter;

    /**
     * 设备收藏唯一id
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 菜谱类型
     */
    @TableField(value = "menu_type")
    @Min(value = 1, message = "菜谱类型不能为空")
    private Integer menuType;

    /**
     * 烹饪方式
     */
    @TableField(value = "for_kitchen_electric")
    @NotBlank(message = "烹饪方式不能为空")
    @NotEmpty(message = "烹饪方式不能为空")
    private String forKitchenElectric;

    /**
     * 营养成分
     */
    @TableField(value = "nutritional_ingredient")
    private String nutritionalIngredient;

    /**
     * 菜谱小图
     */
    @TableField(value = "menu_url")
    @NotBlank(message = "菜谱小图不能为空")
    @NotEmpty(message = "菜谱小图不能为空")
    private String menuUrl;

    /**
     * 菜谱规格参数类型 1 重量 2口感  3 烘焙
     */
    @TableField(value = "specifications_type")
    private Integer specificationsType;

}
