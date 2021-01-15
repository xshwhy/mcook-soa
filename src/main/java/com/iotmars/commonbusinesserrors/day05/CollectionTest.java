package com.iotmars.commonbusinesserrors.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: xsh
 * @date: 2021/1/8 15:29
 */
public class CollectionTest {


    public static void main(String[] args) {
      oom();
    }


    private static List<List<Integer>> data = new ArrayList<>();

    private static void oom() {
        for (int i = 0; i < 1000; i++) {
            List<Integer> rawList = IntStream.rangeClosed(1, 1000000000).boxed().collect(Collectors.toList());
            data.add(rawList.subList(0, 1));
        }
    }
}
