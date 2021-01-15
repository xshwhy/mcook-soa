package com.iotmars.decorator.pattern;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/4 13:18
 */
public class CakeAddMangoDecorator extends CakeDecorator {
    public CakeAddMangoDecorator(Cake cake) {
        super(cake);
    }


    @Override
    public String getCakeMsg() {
        return super.getCakeMsg() + "+1个芒果";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("10"));
    }
}
