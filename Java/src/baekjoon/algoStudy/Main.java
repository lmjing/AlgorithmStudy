package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new int[N][10];
        getTo(N);

        long sum = 0;
        long answer = 9;
        if (N > 1) {
            for (int i = 0; i < 10; i++) sum += dp[N-1][i];
            answer = (sum * 2 - dp[N-1][0] - dp[N-1][9]) % 1000000000;
        }
        System.out.println(answer);
    }

    static int[] getTo (int n) {
        int[] temp = new int[10];
        if (n == 1) {
            for (int i = 1; i < 10; i++) temp[i] = 1;
        }
        else {
            dp[n-1] = getTo(n-1);
            temp[0] = dp[n-1][1];
            temp[9] = dp[n-1][8];
            for (int i = 1; i < 9; i++)
                temp[i] = (dp[n-1][i-1] + dp[n-1][i+1]) % 1000000000;
        }
        return temp;
    }
}