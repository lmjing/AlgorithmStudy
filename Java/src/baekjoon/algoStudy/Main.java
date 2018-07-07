package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n][2];
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][0] = sc.nextInt();
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j][0] > dp[i][0])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }
            maxLength = Math.max(maxLength, dp[i][1]);
        }

        System.out.println(maxLength);
    }
}