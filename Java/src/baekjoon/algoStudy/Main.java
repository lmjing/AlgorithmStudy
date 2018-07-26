package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[] dp = new long[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i <= 100; i++)
            dp[i] = dp[i - 1] + dp[i - 5];

        for (int i = 0; i < T; i++)
            System.out.println(dp[sc.nextInt()]);

    }

//    static long goTo (int n) {
//        if (n == 1 || n == 2) dp[n] = 1;
//        else if (dp[n] == 0 && n > 0) {
//            dp[n] = goTo(n - 1) + goTo(n - 3);
//        }
//        return dp[n];
//    }
}