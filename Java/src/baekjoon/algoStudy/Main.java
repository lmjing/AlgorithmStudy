package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[] tile;
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();
        tile = new long[n+1];

        tile[1] = 1;
        if (n > 1) tile[2] = 2;

        System.out.println(goTo(n));
    }

    public static long goTo (int n) {
        if (n==1) return 1;
        if (n==2) return 2;

        long a = tile[n-1] > 0 ? tile[n-1] : goTo(n-1);
        long b = tile[n-2] > 0 ? tile[n-2] : goTo(n-2);
        tile[n] = (a + b) % 10007;

        return tile[n];
    }
}