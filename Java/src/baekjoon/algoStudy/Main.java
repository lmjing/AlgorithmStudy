package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n / 2 + 1];
        System.out.println(n % 2 == 0 ? goTo(n) : 0);
    }

    static int goTo (int n) {
        if (n == 0) return 1;
        if (n == 2) return 3;
        else if (dp[n / 2] == 0) {
            for (int i = 2; i <= n; i += 2) {
                int standard = i == 2 ? 3 : 2;
                dp[n / 2] += standard * goTo(n - i);
            }
        }
        return dp[n / 2];
    }
}