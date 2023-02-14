package com.codingTest.programmers.level1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//개인정보 수집 기간
public class Privacy {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        LocalDate todayDate = LocalDate.of(
                Integer.parseInt(today.split("\\.")[0]),
                Integer.parseInt(today.split("\\.")[1]),
                Integer.parseInt(today.split("\\.")[2])
        );
        System.out.println("today : " + todayDate);


        Map<String, Long> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], Long.parseLong(terms[i].split(" ")[1]));
        }

        int [] odd = new int[]{1, 3, 5, 7, 8, 10, 12}; //31
        int [] even = new int[]{4, 6, 9, 11}; //30
        int [] feb = new int[]{2}; //28

        System.out.println(map);
        for(int i = 0; i < privacies.length; i++) {
            long term = map.get(privacies[i].split(" ")[1]);
            String start = privacies[i].split(" ")[0];
            int year = Integer.parseInt(start.split("\\.")[0]);
            int month = Integer.parseInt(start.split("\\.")[1]);
            int day = Integer.parseInt(start.split("\\.")[2]);

            LocalDate date = LocalDate.of(year, month, day);


            date = date.plusMonths(term);
            date = date.minusDays(1);

            if(todayDate.isAfter(date)) {
                list.add(i + 1);
            }


        }
        System.out.println(list);
        int [] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }

}
