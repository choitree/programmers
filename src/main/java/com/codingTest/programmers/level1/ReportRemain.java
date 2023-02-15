package com.codingTest.programmers.level1;

import java.util.*;
import java.util.stream.*;

public class ReportRemain {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //내가 신고한 사람(set에 있는 사람이 k보다 높은 신고 횟수라면 내가 report받아야함)
        Map<String, Set<String>> reportedMap = new HashMap<>();
        //나를 신고한 사람 (set의 size가 내가 신고당한 횟수), 모든 아이디가 들어있음
        Map<String, Set<String>> idMap = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], new HashSet<String>());
        }

        for(int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String reportee = report[i].split(" ")[1];
            if(reportedMap.get(reporter) != null) {
                Set<String> set = reportedMap.get(reporter);
                set.add(reportee);
                reportedMap.put(reporter, set);
            }
            else {
                Set<String> set = new HashSet<>();
                set.add(reportee);
                reportedMap.put(reporter, set);
            }

            Set<String> tempSet = idMap.get(reportee);
            tempSet.add(reporter);
            idMap.put(reportee, tempSet);
        }

        for(int i = 0; i < id_list.length; i++) {
            int count = 0;
            if(reportedMap.containsKey(id_list[i])) {
                Set<String> checkSet = reportedMap.get(id_list[i]);
                Iterator<String> iter = checkSet.iterator();
                while(iter.hasNext()) {
                    String id = iter.next();
                    if(idMap.get(id).size() >= k) {
                        count++;
                    }
                }
            }

            answer[i] = count;
        }



        return answer;
    }

    public int[] failSol(String[] id_list, String[] report, int k) {
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
