package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] input;
    static int[] index = {0, 0, 0, 0};
    static int count = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<4; j++) {
                input[i][j]= sc.nextInt();
            }
        }
        check();
        System.out.println(count);
    }

    public static void check() {
        StringBuilder str = new StringBuilder();

        long sum = 0;
        boolean flag = true;
        for (int i=3; i>=0; i--) {
            int num = index[i];
            sum += input[num][i];
            if (num == n - 1) {
                index[i] = flag ? 0 : index[i];
            } else if (num < n - 1) {
                if (flag) {
                    flag = false;
                    index[i]++;
                }
            }
            str.append(index[i] + " ");
        }
        if (sum == 0)
            count++;
        if (!flag) {
            System.out.println(str);
            check();
        }
    }
}