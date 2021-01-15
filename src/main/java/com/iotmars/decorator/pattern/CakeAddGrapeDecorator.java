package com.iotmars.decorator.pattern;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/4 13:17
 */
public class CakeAddGrapeDecorator extends CakeDecorator {

    public CakeAddGrapeDecorator(Cake cake) {
        super(cake);
    }


    @Override
    public String getCakeMsg() {
        return super.getCakeMsg() + "+1个葡萄";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("5"));
    }
}
