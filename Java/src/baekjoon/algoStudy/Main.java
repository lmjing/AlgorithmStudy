package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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

    static int gcd (int a, int b) {
        // a < b 일 경우 a % b = a; 이므로 gcd(b, a);를 호출함
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }
}