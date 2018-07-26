package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++)
            System.out.println(goTo(sc.nextInt()));

    }

    static long goTo (int n) {
        if (n == 1 || n == 2 || n == 3) dp[n] = 1;
        else if (n == 4 || n == 5) dp[n] = 2;
        else if (dp[n] == 0 && n > 0) {
            dp[n] = goTo(n - 1) + goTo(n - 5);
        }
        return dp[n];
    }
}