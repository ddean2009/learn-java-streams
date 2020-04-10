package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author wayne
 * @version FunctionalInterfaceUsage,  2020/4/10 2:14 下午
 */
@Slf4j
public class FunctionalInterfaceUsage {

    public static void main(String[] args) {

        //ExecutorService using class
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
            log.info("new runnable");
            }
        });
        //ExecutorService using lambda
        executorService.submit(()->log.info("new runnable"));

    //Function
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("name", s -> s.length());
        Integer value1 = nameMap.computeIfAbsent("name", String::length);

        //BiFunction
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("alice", 100);
        salaries.put("jack", 200);
        salaries.put("mark", 300);

        salaries.replaceAll((name, oldValue) ->
                name.equals("alice") ? oldValue : oldValue + 200);

        //Consumer
        nameMap.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

        //Predicate
        List<String> names = Arrays.asList("A", "B", "C", "D", "E");
        List<String> namesWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        //Operator
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        int sum = values.stream()
                .reduce(0, (i1, i2) -> i1 + i2);

    }
}
