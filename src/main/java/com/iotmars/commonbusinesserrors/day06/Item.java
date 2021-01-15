package com.iotmars.commonbusinesserrors.day06;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/8 16:24
 */
//购物车中的商品
@Data
public class Item {
    //商品ID
    private long id;
    //商品数量
    private int quantity;
    //商品单价
    private BigDecimal price;
    //商品优惠
    private BigDecimal couponPrice;
    //商品运费
    private BigDecimal deliveryPrice;
}
