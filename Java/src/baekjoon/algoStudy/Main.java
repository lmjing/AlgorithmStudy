package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            if (i == 0) dp[0][1] = input[i];
            else if (i == 1) {
                dp[1][0] = input[i-1];
                dp[1][1] = input[i-1] + input[i];
            } else {
              dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
              dp[i][1] = input[i] + Math.max(dp[i-2][0] + input[i-1], dp[i-1][0]);
            }
        }
        System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
}