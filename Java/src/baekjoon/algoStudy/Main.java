package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] input;
    static long max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        input = new int[n + 1];
        for (int i = 1; i <= n; i++) input[i] = sc.nextInt();
        getMaxSum(n);

        System.out.println(max);
    }

    static long getMaxSum (int n) {
        if (n == 1) {
            max = input[n];
            return input[n];
        }
        long sum = Math.max(input[n], getMaxSum(n - 1) + input[n]);
        max = Math.max(max, sum);
        return sum;
    }
}