package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author wayne
 * @version ReduceUsage,  2020/4/14 2:29 下午
 */
@Slf4j
public class ReduceUsage {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3);
        Optional<Integer> result1=intList.stream().reduce(Integer::sum);
        log.info("{}",result1);

        Integer result2=intList.stream().reduce(100, Integer::sum);
        log.info("{}",result2);

        Integer result3=intList.parallelStream().reduce(100, Integer::sum);
        log.info("{}",result3);

        Integer result4=intList.stream().reduce(100, Integer::sum, Integer::sum);
        log.info("{}",result4);

        Integer result5=intList.parallelStream().reduce(100, Integer::sum, Integer::sum);
        log.info("{}",result5);






    }
}
