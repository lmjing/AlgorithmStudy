package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.Scanner;

public class Chapter3 {
    public void num1476() {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        int[] esm = {15, 28, 19};
        for (int i=0; i<3; i++) {
            input[i] = sc.nextInt();
            if (input[i] == esm[i]) input[i] = 0;
        }

        for (int i=0; i<=15*29; i++) {
            int n = 28 * i + input[1];
            if (n % 15 == input[0] && n % 19 == input[2]) {
                System.out.println(n > 0 ? n : 15*28*19);
                break;
            }
        }
    }
}
