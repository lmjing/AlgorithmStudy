package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] count = new long[10];
        long sum = 9;
        for (int i = 1; i < 10; i++) count[i] = 1;

        for (int i = 2; i < N; i++) {
            long[] temp = new long[10];
            temp[0] = count[1] % 10007;
            temp[9] = count[8] % 10007;
            sum = temp[0] + temp[9];

            for (int j = 1; j < 9; j++) {
                temp[j] = (count[j-1] + count[j+1]) % 1000000000;
                sum += temp[j];
            }
            count = temp;
        }

        System.out.println(N == 1 ? sum : (sum * 2 - count[0] - count[9]) % 1000000000);
    }
}