package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wayne
 * @version com.flydean.CollectorUsage,  2020/4/13 8:55 下午
 */
@Slf4j
public class CollectorUsage {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("jack", "bob", "alice", "mark");
        List<String> duplicateList = Arrays.asList("jack", "jack", "alice", "mark");

        List<String> listResult = list.stream().collect(Collectors.toList());
        log.info("{}",listResult);

        Set<String> setResult = list.stream().collect(Collectors.toSet());
        log.info("{}",setResult);

        Set<String> duplicateSetResult = duplicateList.stream().collect(Collectors.toSet());
        log.info("{}",duplicateSetResult);

        List<String> custListResult = list.stream().collect(Collectors.toCollection(LinkedList::new));
        log.info("{}",custListResult);

        Map<String, Integer> mapResult = list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        log.info("{}",mapResult);

//        Map<String, Integer> duplicateMapResult = duplicateList.stream()
//                .collect(Collectors.toMap(Function.identity(), String::length));

        Map<String, Integer> duplicateMapResult2 = duplicateList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        log.info("{}",duplicateMapResult2);

        List<String> collectAndThenResult = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {return new ArrayList<>(l);}));
        log.info("{}",collectAndThenResult);

        String joinResult = list.stream().collect(Collectors.joining());
        log.info("{}",joinResult);
        String joinResult1 = list.stream().collect(Collectors.joining(" "));
        log.info("{}",joinResult1);
        String joinResult2 = list.stream().collect(Collectors.joining(" ", "prefix","suffix"));
        log.info("{}",joinResult2);

        Long countResult = list.stream().collect(Collectors.counting());
        log.info("{}",countResult);

        IntSummaryStatistics intResult = list.stream()
                .collect(Collectors.summarizingInt(String::length));
        log.info("{}",intResult);

        Double averageResult = list.stream().collect(Collectors.averagingInt(String::length));
        log.info("{}",averageResult);

        Double summingResult = list.stream().collect(Collectors.summingDouble(String::length));
        log.info("{}",summingResult);

        Optional<String> maxByResult = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        log.info("{}",maxByResult);

        Map<Integer, Set<String>> groupByResult = list.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        log.info("{}",groupByResult);

        Map<Boolean, List<String>> partitionResult = list.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 3));
        log.info("{}",partitionResult);
    }
}
