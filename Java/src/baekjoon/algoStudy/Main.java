package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        int[] sorted = new int[n];
        int[][] dp = new int[1000][2]; // 0 : count, 1 : idx

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            sorted[i] = input[i];
        }
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) dp[sorted[i]][1] = i;

        dp[0][0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            int v = input[i];
            if (input[i-1] < v) {
                dp[v][0] = Math.max(dp[v][0], dp[input[i-1]][0] + 1);
                int maxSmallIdx = dp[v][1] - 1;
                if (maxSmallIdx > -1) {
                    dp[v][0] = Math.max(dp[v][0], dp[sorted[maxSmallIdx]][0] + 1);
                }
            } else if (input[i-1] > v && dp[v][0] == 0) {
                int before = dp[v][1] - 1;
                while (before >= 0 && dp[sorted[before]][0] == 0) --before;
                dp[v][0] = before == -1 ? 1 : dp[sorted[before]][0] + 1;
            }
            maxLength = maxLength < dp[v][0] ? dp[v][0] : maxLength;
        }

        System.out.println(maxLength);
    }
}