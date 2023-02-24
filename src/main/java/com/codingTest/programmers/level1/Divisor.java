package com.codingTest.programmers.level1;

//약수의 개수와 덧셈
public class Divisor {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            double sqrt = Math.sqrt(i);

            if(isInteger(sqrt)) {
                answer -= i;
            }
            else {
                answer += i;
            }
        }
        return answer;
    }

    public boolean isInteger(double num) {
        return num % 1 == 0.0;
    }
}
