package com.codingTest.programmers.level1;

//나머지가 1이 되는 수 찾기
public class Remainder {
    public int solution(int n) {
        int answer = 2;
        n = n - 1;
        while(n % answer != 0) {
            answer++;
        }
        return answer;
    }
}
