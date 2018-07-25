package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] dp = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        dp = new int[101];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        for (int i = 0; i < T; i++) {
            System.out.println(dp[sc.nextInt()]);
        }
    }

//    static int goTo (int n) {
//        if (n == 0) dp[n] = 0;
//        else if (n == 1 || n == 2) dp[n] = 1;
//        else if (dp[n] == 0) {
//            dp[n] = goTo(n - 2) + goTo(n - 3);
//        }
//        return dp[n];
//    }
}