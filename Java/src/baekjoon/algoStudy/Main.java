package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] coins = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j ++) {
                if (input.charAt(j) == 'T')
                    coins[i][j] = true;
            }
        }

        int min = n*n;
        for (int state = 0; state < (1 << n); state++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    boolean flag = coins[i][j];
                    if ((state & (1 << i)) != 0)
                        flag = !flag;

                    if (flag) count++;
                }
                sum += Math.min(count, n - count);
            }
            if (min > sum) min = sum;
        }
        System.out.println(min);
    }
}