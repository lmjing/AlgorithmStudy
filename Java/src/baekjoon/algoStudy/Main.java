package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new long[n + 1][k + 1];
        System.out.println(goTo(n, k));
    }

    static long goTo (int n, int k) {
        if (n == 1)
            dp[n][k] = k;
        else if (k == 1)
            dp[n][k] = 1;
        else
            dp[n][k] = goTo(n - 1, k) + goTo(n, k - 1);
       return dp[n][k] % 1000000000;
    }
}