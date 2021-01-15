package com.iotmars.decorator.pattern;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 装饰者模式
 *
 * @author: xsh
 * @date: 2021/1/4 13:19
 */
public class CakeDecoratorTest {


    public static void main(String[] args) {

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        Cake cake = null;

        cake = new BaseCake();
        //普通蛋糕
        cake = new BaseCake();
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
        //加一个芒果
        cake = new CakeAddMangoDecorator(cake);
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
        //加一个葡萄
        cake = new CakeAddGrapeDecorator(cake);
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
        //再加一个芒果
        cake = new CakeAddMangoDecorator(cake);
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());


    }
}
