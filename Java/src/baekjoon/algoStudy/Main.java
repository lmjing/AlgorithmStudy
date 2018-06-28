package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] temp = new int[10];
        temp[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = 1;
            for (int j = 1; j < 10; j++) {
                temp[j] += temp[j-1];
                sum += temp[j] % 10007;
            }
        }
        System.out.println(sum);
    }
}