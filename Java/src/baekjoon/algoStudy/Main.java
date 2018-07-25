package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        dp = new int[101];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = dp[4] = 2;
        for (int i = 0; i < T; i++) {
            System.out.println(goTo(sc.nextInt()));
        }
    }

    static int goTo (int n) {
        if (dp[n] > 0) return dp[n];
        dp[n] = goTo(n - 1) + goTo(n - 4);
        return dp[n];
    }
}