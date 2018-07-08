package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long max = -1000000001;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int input = sc.nextInt();
            dp[i] = Math.max(input, dp[i - 1] + input);
            max = max < dp[i] ? dp[i] : max;
        }
        System.out.println(max);
    }
}