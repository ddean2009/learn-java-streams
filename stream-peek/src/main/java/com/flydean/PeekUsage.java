package com.flydean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version PeekUsage,  2020/4/12 8:39 下午
 */
public class PeekUsage {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three","four");
        stream.peek(System.out::println);

        Stream.of("one", "two", "three","four").forEach(System.out::println);

        Stream.of("one", "two", "three","four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        Stream.of("one", "two", "three","four").peek(u -> u.toUpperCase())
                .forEach(System.out::println);
        Stream.of("one", "two", "three","four").map(u -> u.toUpperCase())
                .forEach(System.out::println);
    }
}
