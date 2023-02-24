package com.codingTest.programmers.level1;

import java.util.*;
//로또의 최고 순위와 최저 순위
public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;

        Set<Integer> lottoSet = new HashSet<>();

        int zeroCount = 0;
        for(int i = 0; i < lottos.length; i++) {
            lottoSet.add(lottos[i]);
            if(lottos[i] == 0) {
                zeroCount++;
            }
        }
        for(int i = 0; i < win_nums.length; i++) {
            if(lottoSet.contains(win_nums[i])) {
                min++;
            }
        }
        max = min + zeroCount;
        int[]answer = new int[2];
        if(max >= 2) {
            answer[0] = 7 - max;
        }
        else {
            answer[0] = 6;
        }
        if(min >= 2) {
            answer[1] = 7 - min;
        }
        else {
            answer[1] = 6;
        }
        return answer;
    }
}
