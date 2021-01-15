package com.iotmars.decorator.pattern;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/4 13:14
 */
public class BaseCake extends Cake {

    @Override
    public String getCakeMsg() {
        return "我是8英寸的普通蛋糕";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(68);
    }
}
