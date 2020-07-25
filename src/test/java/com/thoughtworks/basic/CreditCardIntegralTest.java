package com.thoughtworks.basic;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCardIntegralTest {

    @Test
    public void should_return_0_when_given_normal_user_pos_amont_8(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(8));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：0\n" +
                "2020-07-02 18:50 POS机消费 8元，积分 +0";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_108(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(108));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：10\n" +
                "2020-07-02 18:40 POS机消费 108元，积分 +10";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_10_when_given_normal_user_pos_amont_208(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(208));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：20\n" +
                "2020-07-02 18:40 POS机消费 208元，积分 +20";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_30_when_given_normal_user_pos_amont_8_108_208(){
        //given
        com.thoughtworks.basic.Consume consumeA = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(8));
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(108));
        com.thoughtworks.basic.Consume consumeB = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:40","POS机消费",new BigDecimal(208));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consumeA);
        consumes.add(consume);
        consumes.add(consumeB);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：30\n" +
                "2020-07-02 18:50 POS机消费 8元，积分 +0\n"+
                "2020-07-02 18:40 POS机消费 108元，积分 +10\n"+
                "2020-07-02 18:40 POS机消费 208元，积分 +20";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_1_when_given_normal_user_pos_amont_25(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(25));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：1\n" +
                "2020-07-02 08:20 微信支付消费 25元，积分 +1";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_1_when_given_normal_user_pos_amont_25_10(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(25));
        com.thoughtworks.basic.Consume consumeA = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:35","微信支付消费",new BigDecimal(10));

        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        consumes.add(consumeA);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：1\n" +
                "2020-07-02 08:20 微信支付消费 25元，积分 +1\n"+
                "2020-07-02 08:35 微信支付消费 10元，积分 +0";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_32_when_given_normal_user_pos_amont_25_18_108_10_22_208(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-01 12:20","微信支付消费",new BigDecimal(25));
        com.thoughtworks.basic.Consume consumeA = new com.thoughtworks.basic.Consume("normal","2020-07-01 12:50","微信支付消费",new BigDecimal(18));
        com.thoughtworks.basic.Consume consumeB = new com.thoughtworks.basic.Consume("normal","2020-07-01 18:50","POS机消费",new BigDecimal(108));
        com.thoughtworks.basic.Consume consumeC = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(10));
        com.thoughtworks.basic.Consume consumeD = new com.thoughtworks.basic.Consume("normal","2020-07-02 12:20","微信支付消费",new BigDecimal(22));
        com.thoughtworks.basic.Consume consumeE = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(208));

        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        consumes.add(consumeA);
        consumes.add(consumeB);
        consumes.add(consumeC);
        consumes.add(consumeD);
        consumes.add(consumeE);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：32\n" +
                "2020-07-01 12:20 微信支付消费 25元，积分 +1\n"+
                "2020-07-01 12:50 微信支付消费 18元，积分 +0\n"+
                "2020-07-01 18:50 POS机消费 108元，积分 +10\n"+
                "2020-07-02 08:20 微信支付消费 10元，积分 +0\n"+
                "2020-07-02 12:20 微信支付消费 22元，积分 +1\n"+
                "2020-07-02 18:50 POS机消费 208元，积分 +20"  ;
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_30_when_given_normal_user_pos_amont_208(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 20:30","快捷支付消费",new BigDecimal(208));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：30\n" +
                "2020-07-02 20:30 快捷支付消费 208元，积分 +30";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_30_when_given_normal_user_pos_amont_208_wechat_25(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 20:30","快捷支付消费",new BigDecimal(208));
        com.thoughtworks.basic.Consume consumeA = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(25));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        consumes.add(consumeA);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：31\n" +
                "2020-07-02 20:30 快捷支付消费 208元，积分 +30\n"+
                "2020-07-02 08:20 微信支付消费 25元，积分 +1";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_320_when_given_normal_user_pos_amont_2208(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 22:30","快捷支付消费",new BigDecimal(2208));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：320\n" +
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_382_when_given_normal_user_pos_amont_208__25(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 22:30","快捷支付消费",new BigDecimal(2208));
        com.thoughtworks.basic.Consume consumeA = new com.thoughtworks.basic.Consume("normal","2020-07-02 20:30","快捷支付消费",new BigDecimal(208));
        com.thoughtworks.basic.Consume consumeB = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(208));
        com.thoughtworks.basic.Consume consumeC = new com.thoughtworks.basic.Consume("normal","2020-07-02 12:20","微信支付消费",new BigDecimal(22));
        com.thoughtworks.basic.Consume consumeD = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(10));
        com.thoughtworks.basic.Consume consumeE = new com.thoughtworks.basic.Consume("normal","2020-07-01 18:50","POS机消费",new BigDecimal(108));
        com.thoughtworks.basic.Consume consumeF = new com.thoughtworks.basic.Consume("normal","2020-07-01 12:50","微信支付消费",new BigDecimal(18));
        com.thoughtworks.basic.Consume consumeG = new com.thoughtworks.basic.Consume("normal","2020-07-01 12:20","微信支付消费",new BigDecimal(25));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        consumes.add(consumeA);
        consumes.add(consumeB);
        consumes.add(consumeC);
        consumes.add(consumeD);
        consumes.add(consumeE);
        consumes.add(consumeF);
        consumes.add(consumeG);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：382\n" +
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320\n" +
                "2020-07-02 20:30 快捷支付消费 208元，积分 +30\n" +
                "2020-07-02 18:50 POS机消费 208元，积分 +20\n" +
                "2020-07-02 12:20 微信支付消费 22元，积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元，积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元，积分 +10\n" +
                "2020-07-01 12:50 微信支付消费 18元，积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元，积分 +1";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }


    @Test
    public void should_return_740_when_given_normal_user_pos_amont_6400(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 23:00","信用卡分期购物消费",new BigDecimal(6400));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：740\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元，积分 +740";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_440_when_given_normal_user_pos_amont_4400(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 23:00","信用卡分期购物消费",new BigDecimal(4400));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：440\n" +
                "2020-07-02 23:00 信用卡分期购物消费 4400元，积分 +440";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_1122_when_given_normal_user_pos_amont_6400_208__25(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("normal","2020-07-02 23:00","信用卡分期购物消费",new BigDecimal(6400));
        com.thoughtworks.basic.Consume consumeH = new com.thoughtworks.basic.Consume("normal","2020-07-02 22:30","快捷支付消费",new BigDecimal(2208));
        com.thoughtworks.basic.Consume consumeA = new com.thoughtworks.basic.Consume("normal","2020-07-02 20:30","快捷支付消费",new BigDecimal(208));
        com.thoughtworks.basic.Consume consumeB = new com.thoughtworks.basic.Consume("normal","2020-07-02 18:50","POS机消费",new BigDecimal(208));
        com.thoughtworks.basic.Consume consumeC = new com.thoughtworks.basic.Consume("normal","2020-07-02 12:20","微信支付消费",new BigDecimal(22));
        com.thoughtworks.basic.Consume consumeD = new com.thoughtworks.basic.Consume("normal","2020-07-02 08:20","微信支付消费",new BigDecimal(10));
        com.thoughtworks.basic.Consume consumeE = new com.thoughtworks.basic.Consume("normal","2020-07-01 18:50","POS机消费",new BigDecimal(108));
        com.thoughtworks.basic.Consume consumeF = new com.thoughtworks.basic.Consume("normal","2020-07-01 12:50","微信支付消费",new BigDecimal(18));
        com.thoughtworks.basic.Consume consumeG = new com.thoughtworks.basic.Consume("normal","2020-07-01 12:20","微信支付消费",new BigDecimal(25));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        consumes.add(consumeH);
        consumes.add(consumeA);
        consumes.add(consumeB);
        consumes.add(consumeC);
        consumes.add(consumeD);
        consumes.add(consumeE);
        consumes.add(consumeF);
        consumes.add(consumeG);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：1122\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元，积分 +740\n"+
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320\n" +
                "2020-07-02 20:30 快捷支付消费 208元，积分 +30\n" +
                "2020-07-02 18:50 POS机消费 208元，积分 +20\n" +
                "2020-07-02 12:20 微信支付消费 22元，积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元，积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元，积分 +10\n" +
                "2020-07-01 12:50 微信支付消费 18元，积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元，积分 +1";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }

    @Test
    public void should_return_440_when_given_normal_goldCardUser_pos_amont_4400(){
        //given
        com.thoughtworks.basic.Consume consume = new com.thoughtworks.basic.Consume("goldcardUser","2020-07-02 23:00","信用卡分期购物消费",new BigDecimal(4400));
        List<com.thoughtworks.basic.Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardIntegral creditCardIntegral = new CreditCardIntegral(consumes);
        String expectresult = "总积分：660\n" +
                "2020-07-02 23:00 信用卡分期购物消费 4400元，积分 +660";
        //when
        String  result=creditCardIntegral.countIntegral();
        //then
        Assert.assertEquals(expectresult,result);
    }
}
