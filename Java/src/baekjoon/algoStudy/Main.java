package baekjoon.algoStudy;

import java.io.*;
import java.util.*;

public class Main {
    static String[][] input;
    static long[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            input = new String[2][n];
            dp = new long[n+1][3];

            for (int j = 0; j < 2; j++) input[j] = br.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                dp[j][0] = Math.max(dp[j-1][1], dp[j-1][2]);
                dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2]) + Integer.parseInt(input[0][j-1]);
                dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]) + Integer.parseInt(input[1][j-1]);
            }

            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
    }
}