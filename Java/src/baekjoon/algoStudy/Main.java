package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        int answer = 0;
        if (n % 2 == 0) {
            dp[2] = 3;
            dp[0] = 1;
            for (int i = 4; i <= n; i += 2) {
                for (int j = 2; j <= i; j += 2) {
                    int standard = j == 2 ? 3 : 2;
                    dp[i] += standard * dp[i - j];
                }
            }
            answer = dp[n];
        }

        System.out.println(answer);
    }
}