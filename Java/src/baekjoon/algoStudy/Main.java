package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String before = sc.next();
        String after = sc.next();

        int[][] temp = new int[2][n + 1];
        int[] count = new int[2];

        temp[0][1] = 1;
        count[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int sum = temp[j][i - 1] + temp[j][i] + temp[j][i + 1];
                temp[j][i + 1] = nextInt(sum, before.charAt(i - 1), after.charAt(i - 1));
                if (temp[j][i + 1] == 1) count[j]++;
            }
        }

        for (int j = 0; j < 2; j++) {
            int sum = temp[j][n - 1] + temp[j][n];
            boolean same = before.charAt(n - 1) == after.charAt(n - 1);
            boolean odd = sum % 2 == 1;
            if (!(same ^ odd)) count[j] = n + 1;
        }
        System.out.println(count[0] + count[1] == 2 * (n + 1) ? -1 : Math.min(count[0], count[1]));
    }

    static int nextInt (int sum, char before, char after) {
        boolean same = before == after;
        boolean odd = sum % 2 == 1;

        if (same ^ odd) return 0;
        return 1;
    }
}