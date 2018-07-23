package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            int step = sc.nextInt();
            dp[i][0] = (i > 1 ? Math.max(dp[i - 2][1], dp[i - 2][0]) : 0) + step;
            dp[i][1] = (i > 0 ? dp[i - 1][0] : 0) + step;
        }
        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}