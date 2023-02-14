package com.codingTest.programmers.level1;

import java.util.*;

//성격 유형 검사하기
public class Personality {
    public String solution(String[] survey, int[] choices) {
        // RT
        // CF
        // JM
        // AN
        // 비동의 - 동의
        // 1~7 매우비동의 매우 동의
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        map.put("R" ,0);
        map.put("T", 0);
        map.put("F", 0);
        map.put("C", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        for(int i = 0; i < survey.length; i++) {
            String notAgree = survey[i].substring(0, 1);
            String agree = survey[i].substring(1, 2);
            if(choices[i] >= 5) {
                int point = map.get(agree) + choices[i] - 4;
                map.put(agree, point);
            }
            else {
                int point = map.get(notAgree) + 4 - choices[i];
                map.put(notAgree, point);
            }
        }

        System.out.println("map : " + map);
        if(map.get("R") < map.get("T")) {
            answer += "T";
        }
        else {
            answer += "R";
        }
        if(map.get("C") < map.get("F")) {
            answer += "F";
        }
        else {
            answer += "C";
        }
        if(map.get("J") < map.get("M")) {
            answer += "M";
        }
        else {
            answer += "J";
        }
        if(map.get("A") < map.get("N")) {
            answer += "N";
        }
        else {
            answer += "A";
        }

        return answer;
    }
}
