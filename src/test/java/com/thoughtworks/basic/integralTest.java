package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class integralTest {
    @Test
    public void should_return_1_integra_when_consumption_10(){
        BigDecimal expense=new BigDecimal(10);

        int actual = IntegralCalculator.calculate(expense);

        Assert.assertEquals(1, actual);
    }


}
