package baekjoon.algoStudy.Su1;

import java.util.*;

public class GCD {
    static int gcd (int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }

    // TIME : 원리 알고있는 상태에선 5분만에 구현
    public static void num1934 () {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = gcd(a, b);
            System.out.println(a * (b / gcd));
        }
    }
}
