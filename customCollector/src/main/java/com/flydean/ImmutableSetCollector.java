package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version ImmutableSetCollector,  2020/4/14 5:58 下午
 */
@Slf4j
public class ImmutableSetCollector {

    public static <T> Collector<T, Set<T>, Set<T>> toImmutableSet() {
        return Collector.of(HashSet::new, Set::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                }, Collections::unmodifiableSet);
    }

    public static <T, A extends Set<T>> Collector<T, A, Set<T>> toImmutableSet(
            Supplier<A> supplier) {

        return Collector.of(
                supplier,
                Set::add, (left, right) -> {
                    left.addAll(right);
                    return left;
                }, Collections::unmodifiableSet);
    }

    @Test
    public void toImmutableSetUsage(){
        Set<String> stringSet1=Stream.of("a","b","c","d")
                .collect(ImmutableSetCollector.toImmutableSet());
        log.info("{}",stringSet1);

        Set<String> stringSet2=Stream.of("a","b","c","d")
                .collect(ImmutableSetCollector.toImmutableSet(LinkedHashSet::new));
        log.info("{}",stringSet2);
    }
}
