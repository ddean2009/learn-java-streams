package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author wayne
 * @version CustomSpliteratorUsage,  2020/4/12 11:26 上午
 */
@Slf4j
public class CustomSpliteratorUsage {

    public static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> predicate) {
        CustomSpliterator<T> customSpliterator = new CustomSpliterator<>(stream.spliterator(), predicate);
        return StreamSupport.stream(customSpliterator, false);
    }

    public static void main(String[] args) {
        Stream<Integer> ints = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result =
          takeWhile(ints, x -> x.intValue() % 2 != 0)
                        .collect(Collectors.toList());
        log.info(result.toString());
    }
}
