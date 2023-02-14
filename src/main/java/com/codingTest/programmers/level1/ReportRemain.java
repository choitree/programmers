package com.codingTest.programmers.level1;

import java.util.*;
import java.util.stream.*;

public class ReportRemain {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<String>();
        //report 중복 제거
        for(String rep : report){
            set.add(rep);
        }
        //신고당한 유저의 신고 횟수 카운트를 위한 맵 생성
        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], 0);
        }
        //신고 당한 횟수 중복 제거된 set 순회하며 카운트
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            String id = iter.next().split(" ")[1];
            int count = map.get(id);
            map.put(id, count + 1);
        }

        System.out.println(map);

        for(int i = 0; i < id_list.length; i++) {
            String me = id_list[i];
            int count = 0;
            Iterator<String> it = set.iterator();
            while(it.hasNext()) {
                String content = it.next();
                String reporter = content.split(" ")[0];
                String reportee = content.split(" ")[1];
                if(me.equals(reporter) && map.get(reportee) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
