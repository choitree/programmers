package com.codingTest.programmers.level1;

//3진법 뒤집기
public class Arithmetic {
    public int solution(int n) {
        int answer = 0;
        String result = conversion(n, 3);
        for(int i = 0; i < result.length(); i++) {
            String temp = String.valueOf(result.charAt(i));
            answer += Math.pow(3, i) * Integer.parseInt(temp);
        }
        return answer;
    }

    public String conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
        int current = number;

        while(current > 0){
            if(current % N < 10){
                sb.append(current % N);
            }
            else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }

        return sb.reverse().toString();
    }
}
