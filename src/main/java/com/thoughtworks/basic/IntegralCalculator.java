package com.thoughtworks.basic;

import java.math.BigDecimal;


/**
 * @author adminzxl
 */
public class IntegralCalculator {
    /**
     * @param Monetary
     * @return
     */
    public static int calculate(BigDecimal Monetary) {
        BigDecimal monetary = new BigDecimal(10);

        long integral=Monetary.divide(monetary).setScale(0, BigDecimal.ROUND_DOWN ).longValue();

        return (int) integral;

    }


}
