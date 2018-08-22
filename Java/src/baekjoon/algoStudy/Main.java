package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1000000;
        int[] prime = new int[1000001];

        // 소수 체크
        int i = 1;
        int lastPrime = -1;
        boolean end = false;
        while (++i <= n) {
            if (prime[i] == 0) {
                lastPrime = i;
                if (end || i * i > n) {
                    end = true;
                    continue;
                }
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = lastPrime;
                }
            } else
                prime[i] = lastPrime;
        }
        prime[2] = prime[1] = -1;

        int input = sc.nextInt();
        while (input != 0) {
            int b = prime[input];
            int a = input - b;
            while (b > 0 && prime[a] != 0) {
                b = prime[b - 1];
                a = input - b;
            }
            if (b > 0)
                System.out.println(input + " = " + a + " + " + b);
            else
                System.out.println("Goldbach's conjecture is wrong.");

            input = sc.nextInt();
        }

    }
}