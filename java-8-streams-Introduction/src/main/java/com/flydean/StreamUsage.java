package com.flydean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version StreamUsage,  2020/4/9 9:24 下午
 */
public class StreamUsage {

    public static void main(String[] args) {

        //Stream Creation
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");

        //Multi-threading
        List<String> list =new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("abc");
        list.add("ccc");
        list.add("ddd");
        list.parallelStream().forEach(element -> doPrint(element));

        //Operations
        long count = list.stream().distinct().count();

        //Matching
        boolean isValid = list.stream().anyMatch(element -> element.contains("h"));
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h"));
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h"));

        //Filtering
        Stream<String> filterStream = list.stream().filter(element -> element.contains("d"));

        //Mapping
        Stream<String> mappingStream = list.stream().map(element -> convertElement(element));

        //FlatMap
        List<CustBook> users = new ArrayList<>();
        users.add(new CustBook());
        Stream<Stream<String>> userStreamMap
                = users.stream().map(user -> user.getBookName().stream());
        Stream<String> userStream
                = users.stream().flatMap(user -> user.getBookName().stream());

        //Reduction
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(100, (a, b) -> a + b);

        //Collecting
        List<String> resultList
                = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());

    }

    private static String convertElement(String element) {
        return "element"+"abc";
    }

    private static void doPrint(String element) {
        System.out.println(element);
    }
}
