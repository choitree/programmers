package com.codingTest.programmers.level1;

import java.util.*;
import java.util.stream.*;
//없는 숫자 더하기
public class AddNumberDoesntExist {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> list = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        // ;.contains(value);
        for(int i = 0; i <= 9; i++) {
            if(!list.contains(i)) {
                answer += i;
            }

        }
        return answer;
    }
}
