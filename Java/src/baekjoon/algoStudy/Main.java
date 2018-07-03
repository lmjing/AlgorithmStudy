package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] input;
    static int N;
    static int nonMax;
    static long max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        nonMax = N / 3 + 1;

        for (int i = 0; i < N; i++) input[i] = sc.nextInt();

        goTo(0, 0, 0, 0, 0);
        System.out.println(max);
    }

    static void goTo (int n, int nonCount, int bn, int bo, long sum) {
        if (nonCount > nonMax) return;
        if (n == N) {
            max = sum > max ? sum : max;
            return;
        }

        if (bn < 2) // x
            goTo(n + 1, nonCount + 1, bn + 1, 0, sum);
        if (bo < 2) // o
            goTo(n + 1, nonCount, 0, bo + 1, sum + input[n]);
    }
}