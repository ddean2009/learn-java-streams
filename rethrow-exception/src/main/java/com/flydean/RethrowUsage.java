package com.flydean;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author wayne
 * @version RethrowUsage,  2020/4/13 12:07 下午
 */

@Slf4j
public class RethrowUsage {

    public static void main(String[] args) {
        try {
            throwIOException();
        } catch (IOException e) {
           log.error(e.getMessage(),e);
            RethrowException.throwException(e);
        }
    }

    static void throwIOException() throws IOException{
        throw new IOException("io exception");
    }
}
