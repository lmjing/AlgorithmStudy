package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n][3];
        dp[0] = new long[]{1, 0, 1};

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][1] * 2 + dp[i-1][2];
            dp[i][1] = dp[i-1][1] + dp[i-1][2];
            dp[i][2] = dp[i-1][1];
        }

        System.out.println(dp[n-1][0]);
    }
}