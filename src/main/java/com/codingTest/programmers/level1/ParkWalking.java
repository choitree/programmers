package com.codingTest.programmers.level1;

/* 공원 산책 */
public class ParkWalking {
    public int[] solution(String[] park, String[] routes) {
        int sx = 0;
        int sy = 0;
        String [][] arr = new String [park.length][park[0].length()];

        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                arr[i][j] = park[i].split("")[j];
                if(arr[i][j].equals("S")) {
                    sy = i;
                    sx = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            String way = routes[i].split(" ")[0];
            int length = Integer.parseInt(routes[i].split(" ")[1]);

            int nx = sx;
            int ny = sy;

            for(int j = 0; j < length; j++) {
                if(way.equals("E")) {
                    nx++;
                }
                if(way.equals("W")) {
                    nx--;
                }
                if(way.equals("S")) {
                    ny++;
                }
                if(way.equals("N")) {
                    ny--;
                }

                if(nx >= 0 && ny >= 0 && nx < arr[0].length && ny < arr.length) {
                    if(arr[ny][nx].equals("X")) {
                        break;
                    }

                    if(j == length - 1) {
                        sx = nx;
                        sy = ny;
                    }
                }
            }
        }


        int [] answer = {sy, sx};
        return answer;
    }
}
