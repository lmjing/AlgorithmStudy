package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] temp = new int[10];
        for (int i = 0; i < 10; i++) temp[i] = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < 10; i++) {
                temp[i] = (temp[i] + temp[i-1]) % 10007;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += temp[i];
        }
        System.out.println(sum % 10007);
    }
}