package com.flydean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wayne
 * @version CustBookCounter,  2020/4/12 6:23 下午
 */
@Data
@AllArgsConstructor
public class CustBookCounter {

    private int counter;

    public CustBookCounter accumulate(CustBook custBook) {
        return new CustBookCounter(counter+1);
    }

    public CustBookCounter combine(CustBookCounter custBookCounter) {
        return new CustBookCounter(
                counter + custBookCounter.getCounter());
    }
}