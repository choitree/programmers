package com.codingTest.programmers.level1;

//키패드 누르기
public class KeyPad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        int leftLength = 0;
        int rightLength = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0) {
                numbers[i] = 11;
            }
            if(numbers[i] % 3 == 1) {
                answer += "L";
                left = numbers[i];
            }
            else if(numbers[i] % 3 == 0) {
                answer += "R";
                right = numbers[i];
            }
            else {
                leftLength = Math.abs((left - numbers[i]) / 3) +
                        (Math.abs(left - numbers[i]) % 3);
                rightLength = Math.abs((right - numbers[i]) / 3) +
                        (Math.abs(right - numbers[i]) % 3);

                if(leftLength > rightLength) {
                    answer += "R";
                    right = numbers[i];
                }
                else if(leftLength < rightLength) {
                    answer += "L";
                    left = numbers[i];
                }
                else if(hand.equals("right")) {
                    answer += "R";
                    right = numbers[i];
                }
                else {
                    answer += "L";
                    left = numbers[i];
                }
            }

        }
        return answer;
    }
}
