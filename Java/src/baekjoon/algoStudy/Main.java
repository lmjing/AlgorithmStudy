package baekjoon.algoStudy;

import java.util.*;

public class Main {
    // TIME : 5분 구현
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = gcd(a, b);
            System.out.println(a * (b / gcd));
        }
    }

    static int gcd (int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }
}