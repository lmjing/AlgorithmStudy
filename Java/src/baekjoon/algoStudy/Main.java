package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long sum = 0;
        for (int su : goTo(n)) sum += su;
        System.out.println(sum % 10007);
    }

    static int[] goTo (int n) {
        int[] current = new int[10];
        if (n == 1) {
            for (int i = 0; i < 10; i++) current[i] = 1;
        }else {
            int[] before = goTo(n - 1);
            current[0] = 1;
            for (int i = 1; i < 10; i++) current[i] = (current[i-1] + before[i]) % 10007;
        }
        return current;
    }
}