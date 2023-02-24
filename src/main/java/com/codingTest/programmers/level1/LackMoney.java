package com.codingTest.programmers.level1;

//부족한 금액 계산하기
public class LackMoney {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for(int i = 1; i <= count; i++) {
            totalPrice += price * i;
        }
        System.out.println(totalPrice);
        if(money >= totalPrice) {
            return 0L;
        }

        return totalPrice - money;
    }
}
