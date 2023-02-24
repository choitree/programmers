package com.codingTest.programmers.level1;

import java.util.Arrays;

//예산
public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i < d.length; i++) {
            budget -= d[i];
            answer++;
            if(budget < 0) {
                answer--;
                break;
            }
        }

        return answer;
    }
}
