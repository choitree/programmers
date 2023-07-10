package com.codingTest.programmers.level1;

import java.util.*;

/* 달리기 경주 */
public class RunningCompetition {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> hashMap = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            hashMap.put(i, players[i]);

        }

        for(int i = 0; i < callings.length; i++) {
            int myIndex = map.get(callings[i]);
            String myName = callings[i];
            int frontIndex = myIndex - 1;
            String frontName = hashMap.get(myIndex - 1);
            map.replace(myName, frontIndex);
            map.replace(frontName, myIndex);
            hashMap.replace(frontIndex, myName);
            hashMap.replace(myIndex, frontName);
        }

        for (Map.Entry<Integer, String> entrySet : hashMap.entrySet()) {
            // System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
            answer[entrySet.getKey()] = entrySet.getValue();
        }

        return answer;
    }
}
