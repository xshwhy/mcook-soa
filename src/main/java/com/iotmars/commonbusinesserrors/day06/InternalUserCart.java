package com.iotmars.commonbusinesserrors.day06;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: xsh
 * @date: 2021/1/8 16:27
 */
@Service(value = "InternalUserCart")
public class InternalUserCart extends AbstractCart {
    @Override
    protected void processCouponPrice(long userId, Item item) {
        item.setCouponPrice(BigDecimal.ZERO);
    }

    @Override
    protected void processDeliveryPrice(long userId, Item item) {
        item.setDeliveryPrice(BigDecimal.ZERO);
    }
}
