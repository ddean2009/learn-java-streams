package com.flydean;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wayne
 * @version HandleUncheckedException,  2020/4/12 10:46 下午
 */
public class HandleUncheckedException {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        integers.forEach(i -> System.out.println(1 / i));

        integers.forEach(i -> {
            try {
                System.out.println(1 / i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        });

        integers.forEach(lambdaWrapper(i -> System.out.println(1 / i)));

        integers.forEach(
                consumerWrapperWithExceptionClass(
                        i -> System.out.println(1 / i),
                        ArithmeticException.class));


    }

    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        };
    }

    static <T, E extends Exception> Consumer<T>
    consumerWrapperWithExceptionClass(Consumer<T> consumer, Class<E> clazz) {

        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }


}
