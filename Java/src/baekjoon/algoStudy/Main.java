package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int maxAble = 0; // k보다 큰 동전은 필요없으므로 시간 줄이기 위해서

        int[] coin = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
            if (coin[i] <= k) maxAble = i;
        }

        int[][] dp = new int[maxAble + 2][2]; // 0 : count, 1 : restMoney
        dp[maxAble + 1][1] = k;
        for (int i = maxAble; i >= 0; i--) {
            // 뒤에서 부터 전체 탐색
            for (int j = maxAble + 1; j > i; j--) {
                if (dp[j][1] >= coin[i]) {
                    int count = k / coin[i];
                    dp[j][] += count;
                    k -= count * coin[i];
                }
            }


            if (k >= coin[i]) {
                int count = k / coin[i];
                answer += count;
                k -= count * coin[i];
            }
        }
    }
}