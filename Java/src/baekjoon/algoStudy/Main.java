package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i][1] = sc.nextInt();
        }

        goTo(n);
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }

    static void goTo (int i) {
        if (i <= 1) return;
        goTo(i - 1);
        if (i > 2)
            dp[i][0] += Math.max(dp[i - 2][0], dp[i - 2][1]);
        dp[i][1] += dp[i - 1][0];
    }
}