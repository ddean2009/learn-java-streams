package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wayne
 * @version FailFastUsage,  2020/4/17 11:11 上午
 */

@Slf4j
public class FailFastUsage {

    public static void main(String[] args) {
        Map<Integer,String> users = new HashMap<>();

        users.put(1, "jack");
        users.put(2, "alice");
        users.put(3, "jone");

        Iterator iterator1 = users.keySet().iterator();

        //not modify key, so no exception
        while (iterator1.hasNext())
        {
            log.info("{}",users.get(iterator1.next()));
            users.put(2, "mark");
        }

        Iterator iterator2 = users.keySet().iterator();
        //modify key,get exception
        while (iterator2.hasNext())
        {
            log.info("{}",users.get(iterator2.next()));
            users.put(4, "mark");
        }

    }
}
