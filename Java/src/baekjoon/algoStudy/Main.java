package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] answer = new int[11];
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        answer[1] = 1;
        answer[2] = 1;
        answer[3] = 1;
        for (int i = 2; i <= 10; i++) {
            for (int j = 1; j <= 3 && j < i; j++) {
                answer[i] += answer[i - j];
            }
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(answer[n]);
        }
    }
}