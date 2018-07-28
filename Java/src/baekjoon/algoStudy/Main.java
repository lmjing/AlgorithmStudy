package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
//        char[] input = sc.nextLine().toCharArray();
        int mod = 1000000;
        int[] dp = new int[input.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= input.length(); i++) {
//            if (input[i - 2] <= '2' && input[i - 1] <= '6')
            if (input.charAt(i - 2) <= '2' && input.charAt(i - 1) <= '6')
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            else dp[i] = dp[i - 1];
        }
        System.out.println(dp[input.length()]);
    }
}