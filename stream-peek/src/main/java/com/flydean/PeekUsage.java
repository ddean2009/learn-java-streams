package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version PeekUsage,  2020/4/12 8:39 下午
 */
@Slf4j
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

        List<String > stringList=Stream.of("one", "two", "three","four").peek(u -> u.toUpperCase()).collect(Collectors.toList());
        log.info("{}",stringList);

        List<User> userList=Stream.of(new User("a"),new User("b"),new User("c")).peek(u->u.setName("kkk")).collect(Collectors.toList());
        log.info("{}",userList);

    }

    @Data
    @AllArgsConstructor
    static class User{
        private String name;
    }
}
