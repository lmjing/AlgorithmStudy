package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static long[] ans;
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();
        ans = new long[n+1];

        ans[1] = 1;
        if (n > 1) ans[2] = 2;

        System.out.println(get(n));
    }

    public static long get(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = ans[n-1] > 0 ? ans[n-1] : get(n-1);
        long b = ans[n-2] > 0 ? ans[n-2] : get(n-2);

        ans[n] = a + b;
        return a + b;
    }
}