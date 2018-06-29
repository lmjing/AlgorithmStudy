package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[][] array;
    static long max;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();

            array = new long[2][n];
            max = 0;

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) array[j][k] = sc.nextInt();
            }
            goTo(0, 0, 0);
            goTo(0, 1, 0);
            System.out.println(max);
        }
    }

    static void goTo (int x, int y, long sum) {
        if (x >= n) {
            max = max < sum ? sum : max;
            return;
        }
        goTo(x + 1, Math.abs(1 - y), sum + array[y][x]);
        goTo(x + 2, Math.abs(1 - y), sum + array[y][x]);

        goTo(x + 1, y, sum);
    }
}