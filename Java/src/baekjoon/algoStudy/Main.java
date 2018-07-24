package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n % 2 == 0) {
            int[] dp = new int[n / 2 + 1];
            dp[1] = 3;
            dp[0] = 1;
            for (int i = 4; i <= n; i += 2) {
                for (int j = 2; j <= i; j += 2) {
                    int standard = j == 2 ? 3 : 2;
                    dp[i / 2] += standard * dp[(i - j) / 2];
                }
            }
            System.out.println(dp[n / 2]);
        } else System.out.println(0);
    }
}