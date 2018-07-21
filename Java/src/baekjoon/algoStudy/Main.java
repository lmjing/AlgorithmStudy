package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] dp = new int[201][201];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getCounts(n, k));
    }

    static int getCounts (int n, int k) {
        if (k == 1) dp[n][k] = 1;
        else if (k == 2) dp[n][k] = n + 1;
        else {
            int half = k / 2;
            long sum = 0;
            for (int i = 0; i <= n; i++) {
                if (dp[i][half] == 0)
                    dp[i][half] = getCounts(i, half) % 1000000000;
                if (dp[n - i][k - half] == 0)
                    dp[n - i][k - half] = getCounts(n - i, k - half) % 1000000000;
                sum += dp[i][half] * dp[n - i][k - half];
            }
            dp[n][k] = (int)(sum % 1000000000);
        }

        return dp[n][k];
    }
}