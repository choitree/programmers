package com.codingTest.programmers.level1;

import java.util.HashMap;
import java.util.Map;

/* 추억 점수 */
public class YearningPoint {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for(int i = 0; i < photo.length; i++) {
            int temp = 0;
            for(int j = 0; j < photo[i].length; j++) {
                if(map.containsKey(photo[i][j])) {
                    temp += map.get(photo[i][j]);
                }
            }
            answer[i] = temp;
        }
        return answer;
    }
}
