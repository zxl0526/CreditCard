package com.thoughtworks.basic;

import com.thoughtworks.basic.integralSeparation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCardIntegral {
    private List<com.thoughtworks.basic.Consume> consumes;
    private List<CalculateIntegral> integrals = new ArrayList<>();

    public CreditCardIntegral(List<com.thoughtworks.basic.Consume> consumes) {
        this.consumes = consumes;
        initIntegrals();
    }



    private void initIntegrals(){
        integrals.add(new PosIntegral());
        integrals.add(new WechatIntegral());
        integrals.add(new ExpressPaymentIntegral());
        integrals.add(new InstallmentPurchaseIntegral());
    }

    public String countIntegral() {
        String resultAmount = "总积分：";
        String resultContent = "";
        BigDecimal integral = new BigDecimal(0);
        for (com.thoughtworks.basic.Consume consume :consumes){
            for (CalculateIntegral integral1:integrals){
                integral1.countIntegral(consume);
                consume.goldCardIntegral();
            }
            integral =integral.add(consume.getIntegral());
            resultContent = resultContent+"\n"+consume.getConsumeTime()+" "+consume.getConsumeType()+" "+consume.getConsumeAmout()+"元，"+"积分 +"+consume.getIntegral();
        }
        resultAmount = resultAmount+integral+resultContent;
        return resultAmount;
    }

}
