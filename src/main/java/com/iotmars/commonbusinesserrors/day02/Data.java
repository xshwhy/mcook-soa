package com.iotmars.commonbusinesserrors.day02;

import lombok.Getter;

import java.util.stream.IntStream;

/**
 * @author: xsh
 * @date: 2021/1/7 10:47
 */
class Data {
    @Getter
    private static int counter = 0;

    private static Object locker = new Object();

    public void right() {
        synchronized (locker) {
            counter++;
        }
    }


    public static int reset() {
        counter = 0;
        return counter;
    }

    public synchronized void wrong() {
        counter++;
    }


    public static void main(String[] args) {
        Data.reset();
        // 多线程循环一定次数调用Data类不同实例的wrong方法
        IntStream.rangeClosed(1,1000000).parallel().
                forEach(i->new Data().right());
        System.out.println(Data.getCounter());
    }



}