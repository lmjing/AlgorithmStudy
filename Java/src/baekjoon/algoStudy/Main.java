package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[][] count;
    static long max = 0;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] input = new int[N];
        count = new long[N/3 + 1][3];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
            sum += input[i];
            if (i % 3 == 2) {
                count[i/3][0] = sum - input[i - 2];
                count[i/3][1] = sum - input[i - 1];
                count[i/3][2] = sum - input[i];
                sum = 0;
            }
        }
        goTo(0, 3, 0);
        System.out.println(max);
    }

    public static void goTo (int n, int before, long sum) {
        if (n == N) {
            max = max < sum ? sum : max;
            return;
        }
        if (before >= 2) goTo(n + 1, 2, sum + count[n][2]);
        if (before >= 1) goTo(n + 1, 1, sum + count[n][1]);
        if (before >= 0) goTo(n + 1, 0, sum + count[n][0]);
    }
}