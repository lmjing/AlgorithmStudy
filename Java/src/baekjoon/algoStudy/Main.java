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
            int now = i - 1;
            if (input.charAt(now) > '0')
                dp[i] = dp[i - 1];
            int su = (input.charAt(now - 1) - '0') * 10 + (input.charAt(now) - '0');
            if (su >= 10 && su <= 26)
                dp[i] = (dp[i] + dp[i - 2]) % mod;
        }
        System.out.println(input.equals("0") ? 0 : dp[input.length()]);
    }
}