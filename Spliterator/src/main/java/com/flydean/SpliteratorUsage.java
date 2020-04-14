package com.flydean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wayne
 * @version SpliteratorUsage,  2020/4/12 4:01 下午
 */
@Slf4j
public class SpliteratorUsage {

    public String call(Spliterator<CustBook> spliterator) {
        int current = 0;
        while (spliterator.tryAdvance(a -> a.setName("test name"
                .concat("- add new name")))) {
            current++;
        }

        return Thread.currentThread().getName() + ":" + current;
    }

    public static List<CustBook> generateElements() {
        return Stream.generate(() -> new CustBook("cust book"))
                .limit(1000)
                .collect(Collectors.toList());
    }

    @Test
    public void useTrySplit(){
        Spliterator<CustBook> split1 = SpliteratorUsage.generateElements().spliterator();
        Spliterator<CustBook> split2 = split1.trySplit();

        log.info("before tryAdvance: {}",split1.estimateSize());
        log.info("Characteristics {}",split1.characteristics());
        log.info(call(split1));
        log.info(call(split2));
        log.info("after tryAdvance {}",split1.estimateSize());
    }
}
