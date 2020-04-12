package com.flydean;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author wayne
 * @version HandleCheckedException,  2020/4/12 10:46 下午
 */
public class HandleCheckedException {

    static void throwIOException(Integer integer) throws IOException {
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//        integers.forEach(i -> throwIOException(i));

        integers.forEach(i -> {
            try {
                throwIOException(i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        integers.forEach(consumerWrapper(i -> throwIOException(i)));
        integers.forEach(consumerWrapperWithExceptionClass(
                i -> throwIOException(i), IOException.class));

    }

    static <T> Consumer<T> consumerWrapper(
            ThrowingConsumer<T, Exception> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T, E extends Exception> Consumer<T> consumerWrapperWithExceptionClass(
            ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }
}
