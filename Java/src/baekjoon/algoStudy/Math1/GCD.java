package baekjoon.algoStudy.Math1;

import java.util.*;

public class GCD {
    static int gcd (int a, int b) {
        // a < b 일 경우 a % b = a; 이므로 gcd(b, a);를 호출함
        return b == 0 ? a : gcd(b, a % b);
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

    public static void num9613() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            int n = sc.nextInt();
            int[] inputs = new int[n];
            for (int i = 0; i < n; i++) inputs[i] = sc.nextInt();

            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++)
                    sum += gcd(inputs[i], inputs[j]);
            }
            System.out.println(sum);
        }
    }
}
