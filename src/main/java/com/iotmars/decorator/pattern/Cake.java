package com.iotmars.decorator.pattern;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/4 13:13
 */
public abstract class Cake {

    /**
     * 得到蛋糕的信息
     * @return
     */
    public abstract String getCakeMsg();

    /**
     * 得到价格
     * @return
     */
    public abstract BigDecimal getPrice();


}
