package com.iotmars.observer;

/**
 * @author: xsh
 * @date: 2020/12/25 10:15
 */
public class PhoneFans extends Buyer {

    public PhoneFans(String name, Shop shop) {
        super(name, shop);//调用父类进行构造
    }

    @Override
    public void inform() {
        String product = shop.getProduct();
        if (product.contains("水果手机")) {//此买家只买水果牌手机
            System.out.print(name);
            System.out.println("购买：" + product);
        }
    }
}
