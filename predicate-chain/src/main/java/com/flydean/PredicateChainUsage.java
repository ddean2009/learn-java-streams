package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version PredicateChainUsage,  2020/4/15 9:04 下午
 */
@Slf4j
public class PredicateChainUsage {

    /**
     * basic usage
     */
    @Test
    public void basicUsage(){
        List<String> stringList=Stream.of("a","b","c","d").filter(s -> s.startsWith("a")).collect(Collectors.toList());
        log.info("{}",stringList);
    }

    @Test
    public void multipleFilters(){
        List<String> stringList=Stream.of("a","ab","aac","ad").filter(s -> s.startsWith("a"))
                .filter(s -> s.length()>1)
                .collect(Collectors.toList());
        log.info("{}",stringList);
    }

    @Test
    public void complexPredicate(){
        List<String> stringList=Stream.of("a","ab","aac","ad")
                .filter(s -> s.startsWith("a") &&  s.length()>1)
                .collect(Collectors.toList());
        log.info("{}",stringList);
    }

    @Test
    public void combiningPredicate(){
        Predicate<String> predicate1 = s -> s.startsWith("a");
        Predicate<String> predicate2 =  s -> s.length() > 1;
        List<String> stringList1 = Stream.of("a","ab","aac","ad")
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        log.info("{}",stringList1);

        List<String> stringList2 = Stream.of("a","ab","aac","ad")
                .filter(predicate1.or(predicate2))
                .collect(Collectors.toList());
        log.info("{}",stringList2);

        List<String> stringList3 = Stream.of("a","ab","aac","ad")
                .filter(predicate1.or(predicate2.negate()))
                .collect(Collectors.toList());
        log.info("{}",stringList3);

        List<String> stringList4 = Stream.of("a","ab","aac","ad")
                .filter(((Predicate<String>)a -> a.startsWith("a"))
                        .and(a -> a.length() > 1))
                .collect(Collectors.toList());
        log.info("{}",stringList4);

    }

    @Test
    public void combiningPredicateCollection(){
        List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();
        allPredicates.add(a -> a.startsWith("a"));
        allPredicates.add(a -> a.length() > 1);

        List<String> stringList = Stream.of("a","ab","aac","ad")
                .filter(allPredicates.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());
        log.info("{}",stringList);
    }


}
