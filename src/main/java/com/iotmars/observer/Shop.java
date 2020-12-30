package com.iotmars.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xsh
 * @date: 2020/12/25 10:07
 */
public class Shop {

    /**
     * 商品
     */
    private String product;
    /**
     * 持有买家的引用
     */
    private List<Buyer> buyers;

    /**
     * 初始商店无货
     */
    public Shop() {
        this.product = "无货";
        this.buyers = new ArrayList<>();
    }

    /**
     * 为了主动通知买家，买家来店里注册
     */
    public void register(Buyer buyer) {
        this.buyers.add(buyer);
    }

    /**
     * 商店出货
     * @return
     */
    public String getProduct() {
        return product;
    }

    /**
     * 商店进货
     * @param product
     */
    public void setProduct(String product) {
        this.product = product;
        notifyBuyers();
    }

    /**
     * 通知所有注册买家
      */
  public void notifyBuyers() {
      buyers.stream().forEach(b -> b.inform());
    }


}
