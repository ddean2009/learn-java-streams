package com.flydean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version ifElseUsage,  2020/4/12 10:19 上午
 */
public class ifElseUsage {

    public void inForEach(){
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ints.stream()
                .forEach(i -> {
                    if (i.intValue() % 2 == 0) {
                        System.out.println("i is even");
                    } else {
                        System.out.println("i is old");
                    }
                });
    }

    public void withFilter(){
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> evenIntegers = ints.stream()
                .filter(i -> i.intValue() % 2 == 0);
        Stream<Integer> oddIntegers = ints.stream()
                .filter(i -> i.intValue() % 2 != 0);

        evenIntegers.forEach(i -> System.out.println("i is even"));
        oddIntegers.forEach(i -> System.out.println("i is old"));


    }
}
