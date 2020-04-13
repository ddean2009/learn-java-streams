package com.flydean;

/**
 * @author wayne
 * @version RethrowException,  2020/4/13 12:06 下午
 */
public class RethrowException {

    public static <T extends Exception, R> R throwException(Exception t) throws T {
        throw (T) t; // just throw it, convert checked exception to unchecked exception
    }

}
