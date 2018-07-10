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

        for (int i = maxAble; i >= 0; i--) {
            answer += k / coin[i];
            k %= coin[i];
        }
        System.out.println(answer);
    }
}