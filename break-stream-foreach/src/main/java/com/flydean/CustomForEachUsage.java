package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version CustomForEachUsage,  2020/4/12 12:13 下午
 */
@Slf4j
public class CustomForEachUsage {

    public static void main(String[] args) {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = new ArrayList<>();
        CustomForEach.forEach(ints, (elem, breaker) -> {
            if (elem.intValue() % 2 == 0) {
                breaker.stop();
            } else {
                result.add(elem);
            }
        });
        log.info(result.toString());
    }
}
