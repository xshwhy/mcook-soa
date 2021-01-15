package com.iotmars.decorator.pattern;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/4 13:15
 */
public class CakeDecorator extends Cake {

    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String getCakeMsg() {
        return this.cake.getCakeMsg();
    }

    @Override
    public BigDecimal getPrice() {
        return this.cake.getPrice();
    }
}
