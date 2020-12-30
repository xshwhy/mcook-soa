package com.iotmars.observer;

/**
 * @author: xsh
 * @date: 2020/12/25 10:16
 */
public class HandChopper extends Buyer {

    public HandChopper(String name, Shop shop) {
        super(name, shop);
    }

    @Override
    public void inform() {
        System.out.print(name);
        String product = shop.getProduct();
        System.out.println("购买：" + product);
    }
}
