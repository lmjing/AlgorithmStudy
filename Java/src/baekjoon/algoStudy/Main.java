package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        int mod = 1000000;
        int[][] dp = new int[input.length][2];
        dp[0] = new int[]{1, 0};
        for (int i = 1; i < input.length; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            if (input[i - 1] <= '2' && input[i] <= '6')
                dp[i][1] = dp[i - 1][0];
        }
        System.out.println((dp[input.length - 1][0] + dp[input.length - 1][1]) % mod);
    }
}