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

//    public CustBookCounter accumulate(CustBook custBook) {
//        if (author.getRelatedArticleId() == 0) {
//            return isRelated ? this : new RelatedAuthorCounter( counter, true);
//        } else {
//            return isRelated ? new RelatedAuthorCounter(counter + 1, false) : this;
//        }
//    }

    public CustBookCounter combine(CustBookCounter custBookCounter) {
        return new CustBookCounter(
                counter + custBookCounter.getCounter());
    }
}