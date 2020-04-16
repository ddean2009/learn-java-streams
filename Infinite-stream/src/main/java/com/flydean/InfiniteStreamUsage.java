package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version InfiniteStreamUsage,  2020/4/15 10:01 下午
 */
@Slf4j
public class InfiniteStreamUsage {

    @Test
    public void infiniteStream(){
        Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        List<Integer> collect = infiniteStream
                .limit(10)
                .collect(Collectors.toList());
        log.info("{}",collect);
    }

    public static IntegerWrapper generateCustType(){
        return new IntegerWrapper(new Random().nextInt(100));
    }

    @Test
    public void infiniteCustType(){
        Supplier<IntegerWrapper> randomCustTypeSupplier = InfiniteStreamUsage::generateCustType;
        Stream<IntegerWrapper> infiniteStreamOfCustType = Stream.generate(randomCustTypeSupplier);

        List<IntegerWrapper> collect = infiniteStreamOfCustType
                .skip(10)
                .limit(10)
                .collect(Collectors.toList());
        log.info("{}",collect);
    }
}
