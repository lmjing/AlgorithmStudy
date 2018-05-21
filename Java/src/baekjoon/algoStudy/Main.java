package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] input;
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
        check(0);
        System.out.println(count);
    }

    public static void check(long i) {
        long newI = 0;
        long sum = 0;
        boolean flag = true;
        int position = 1;
        for (int j=0; j<4; j++) {
            long num = i % 10;
            sum += input[(int) num][j];
            if (num < n - 1) {
                newI += position * num;
                if (flag) {
                    flag = false;
                    newI += position;
                }
            }else if (!flag) newI += position * num;
            i /= 10;
            position *= 10;
        }
        if (sum == 0)
            count++;
        if (newI > 0) check(newI);
    }
}