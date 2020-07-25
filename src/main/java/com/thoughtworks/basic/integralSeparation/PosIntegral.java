package com.thoughtworks.basic.integralSeparation;

import com.thoughtworks.basic.Consume;

import java.math.BigDecimal;

public class PosIntegral implements CalculateIntegral {
    @Override
    public void countIntegral(Consume consume) {
        if ("POS机消费".equals(consume.getConsumeType())) {
            BigDecimal count = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(10));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
        }
    }
}
