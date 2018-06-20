package baekjoon.algoStudy;

import java.awt.font.ShapeGraphicAttribute;
import java.sql.SQLType;
import java.util.*;

public class Main {
    static long[] fac;
    public static void main (String[] args) {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();
        fac = new long[n+1];

        fac[1] = 1;
        if (n > 1) fac[2] = 2;
        getFac(n);

        long ans = 1;
        for (int i=1; i<=n/2; i++) {
//            System.out.println(i + " " + fac[n-i] + " " + fac[i] + " " + fac[n-2*i]);
            ans += (n-i == i) ? n-i : fac[n-i] / (fac[i] * fac[n-2*i]);
        }
        System.out.println(ans);
    }

    public static long getFac (int n) {
        if (n == 1) return 1;

        fac[n] = getFac(n-1) * n;
        System.out.println(n + " " + fac[n]);
        return fac[n];
    }
}