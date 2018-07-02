package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(goTo(n)[0]);
    }

    static long[] goTo(int n) {
        if (n == 1) return new long[]{1, 0, 1};

        long[] current = new long[3];
        long[] before = goTo(n - 1);
        current[0] = before[1] * 2 + before[2];
        current[1] = before[1] + before[2];
        current[2] = before[1];
        return current;
    }
}