package com.codingTest.programmers.level1;

/* 바탕화면 정리 */
public class CleanWallpaper {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int [4];
        String[][] arr = new String[wallpaper.length][wallpaper[0].length()];

        String[] columnArr = new String[wallpaper[0].length()];

        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[i].length(); j++) {
                arr[i][j] = wallpaper[i].split("")[j];
            }
        }

        for(int i = 0; i < wallpaper.length; i++) {
            if(wallpaper[i].contains("#")) {
                answer[0] = i;
                break;
            }
        }


        for(int i = wallpaper.length - 1; i >= 0; i--) {
            if(wallpaper[i].contains("#")) {
                answer[2] = i + 1;
                break;
            }
        }


        for(int i = 0; i < arr[0].length; i++) {
            String temp = "";
            for(int j = 0; j < arr.length; j++) {
                temp += arr[j][i];
            }
            columnArr[i] = temp;
        }

        for(int i = 0; i < columnArr.length; i++) {
            if(columnArr[i].contains("#")) {
                answer[1] = i;
                break;
            }
        }


        for(int i = columnArr.length - 1; i >= 0; i--) {
            if(columnArr[i].contains("#")) {
                answer[3] = i + 1;
                break;
            }
        }


        return answer;
    }
}
