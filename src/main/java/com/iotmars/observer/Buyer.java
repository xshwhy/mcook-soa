package com.iotmars.observer;

/**
 * @author: xsh
 * @date: 2020/12/25 10:09
 */
public abstract class Buyer {

    protected String name;
     protected Shop shop;

            public Buyer(String name, Shop shop) {
                this.name = name;
               this.shop = shop;//
                // shop.register(this);
            }

            public abstract void inform();

}
