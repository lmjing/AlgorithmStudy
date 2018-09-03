package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        go(new int[n + 1][4], new int[n + 1], 1, 1);
    }

    static boolean go (int[][] last, int[] answer, int i, int v) {
        for (int k = 1; k <= 3; k++)
            last[i][k] = last[i - 1][k];
        last[i][answer[i - 1]] = i - 1;
        answer[i] = v;
        System.out.println(i + " " + v);
        System.out.println("마지막 값 1 : " + last[i][1] + " 2 : " + last[i][2] + " 3 : " + last[i][3]);

        // 지금 넣은 값이 가능한지 확인
        int b = last[i][v];
        while (b > 0) {
            int length = i - b;
            boolean flag = length <= b ? true : false;
            for (int j = i; flag && j > b; j--) {
                if (j - length < 1 || answer[j] != answer[j - length]) {
                    flag = false;// 똑같지 않음
                }
            }

            if (flag) { // 똑같음
                answer[i] = 0;
                return false;
            }
            // 다름
            b = last[b][v];
        }

        // 다 돌았음 정답 출력하고 끝
        if (answer.length - 1 == i) {
            for (int k = 1; k < answer.length; k++)
                System.out.print(answer[k]);
            return true;
        }

        System.out.println("----성공-----");

        for (int j = 1; j <= 3; j++) {
            if (j != v) {
                answer[i] = v;
                if (go(last, answer, i + 1, j)) return true;
                System.out.println("----실패-----");
                answer[i] = 0;
            }
        }
        return false;
    }
}