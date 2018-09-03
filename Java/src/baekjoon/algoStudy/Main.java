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

        int b = last[i][v];
        while (b > 0) {
            int length = i - b;
            boolean flag = length <= b ? true : false;
            for (int j = i; flag && j > b; j--) {
                if (j - length < 1 || answer[j] != answer[j - length]) {
                    flag = false;
                }
            }

            if (flag) {
                answer[i] = 0;
                return false;
            }
            b = last[b][v];
        }

        if (answer.length - 1 == i) {
            for (int k = 1; k < answer.length; k++)
                System.out.print(answer[k]);
            return true;
        }

        for (int j = 1; j <= 3; j++) {
            if (j != v) {
                answer[i] = v;
                if (go(last, answer, i + 1, j)) return true;
                answer[i] = 0;
            }
        }
        return false;
    }
}