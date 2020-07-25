package com.thoughtworks.basic.integralSeparation;

import com.thoughtworks.basic.Consume;

import java.math.BigDecimal;

public class InstallmentPurchaseIntegral implements CalculateIntegral {
    @Override
    public void countIntegral(Consume consume) {
        if ("信用卡分期购物消费".equals(consume.getConsumeType())) {
            BigDecimal count = consume.getConsumeAmout().divideToIntegralValue(new BigDecimal(10));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
            if (consume.getConsumeAmout().compareTo(new BigDecimal(5000))==1){
                consume.addBigDecimal(new BigDecimal(100));
            }
        }
    }
}
