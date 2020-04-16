package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author wayne
 * @version CustThreadPool,  2020/4/16 8:09 下午
 */
@Slf4j
public class CustThreadPool {

    @Test
    public void runWithCustThreadPool() throws ExecutionException, InterruptedException {
    List<Integer> integerList= IntStream.range(1,1000).boxed().collect(Collectors.toList());
        ForkJoinPool customThreadPool = new ForkJoinPool(4);

        Integer total= integerList.parallelStream().reduce(0, Integer::sum);
        log.info("{}",total);

        Integer actualTotal = customThreadPool.submit(
                () -> integerList.parallelStream().reduce(0, Integer::sum)).get();
        log.info("{}",actualTotal);
    }
}
