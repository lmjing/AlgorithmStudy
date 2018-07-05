package baekjoon.algoStudy;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][2]; // 0 : length, 1 : last
        int max = 1;

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = sc.nextInt();
            for (int j = 0; j < i; j++) {
                if (dp[j][1] < dp[i][1])
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
            }
            max = max < dp[i][0] ? dp[i][0] : max;
        }
        System.out.println(max);
    }
}