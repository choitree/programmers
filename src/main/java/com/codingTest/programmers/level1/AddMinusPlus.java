package com.codingTest.programmers.level1;

//음양 더하기
public class AddMinusPlus {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0 ; i < absolutes.length ; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            }
            if(signs[i] == false) {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
