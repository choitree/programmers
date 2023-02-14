package com.codingTest.programmers.level1;

//내적
public class InnerProduct {
    public int solution(int[] a, int[] b) {
        int temp = 0;
        int answer = 0;
        for(int i = 0 ; i < a.length; i++) {
            temp = a[i] * b[i];
            answer += temp;
        }
        return answer;
    }
}
