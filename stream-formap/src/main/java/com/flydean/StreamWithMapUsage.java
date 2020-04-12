package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version StreamWithMapUsage,  2020/4/12 6:58 下午
 */
@Slf4j
public class StreamWithMapUsage {

    public static void main(String[] args) {

        Map<String, String> someMap = new HashMap<>();

        Set<Map.Entry<String, String>> entries = someMap.entrySet();

        Set<String> keySet = someMap.keySet();

        Collection<String> values = someMap.values();

        Stream<Map.Entry<String, String>> entriesStream = entries.stream();
        Stream<String> valuesStream = values.stream();
        Stream<String> keysStream = keySet.stream();

        someMap.put("jack","20");
        someMap.put("bill","35");

        Optional<String> optionalName = someMap.entrySet().stream()
                .filter(e -> "20".equals(e.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        log.info(optionalName.get());

        optionalName = someMap.entrySet().stream()
                .filter(e -> "Non ages".equals(e.getValue()))
                .map(Map.Entry::getKey).findFirst();

        log.info("{}",optionalName.isPresent());

        someMap.put("alice","20");
        List<String> listnames = someMap.entrySet().stream()
                .filter(e -> e.getValue().equals("20"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        log.info("{}",listnames);

        List<String> listAges = someMap.entrySet().stream()
                .filter(e -> e.getKey().equals("alice"))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        log.info("{}",listAges);


    }
}
