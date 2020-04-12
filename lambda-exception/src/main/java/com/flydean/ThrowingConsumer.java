package com.flydean;

/**
 * @author wayne
 * @version ThrowingConsumer,  2020/4/12 10:53 下午
 */
@FunctionalInterface
public interface ThrowingConsumer<T, E extends Exception> {
    void accept(T t) throws E;
}
