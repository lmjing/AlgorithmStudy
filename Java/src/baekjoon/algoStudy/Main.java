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

        for (int i = 3; i <= n; i++) tile[i] = (tile[i-2] + tile[i-1]) % 10007;

        System.out.println(tile[n]);
    }
}