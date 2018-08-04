package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] festival1 = {{500, 300, 200, 50, 30, 10}, {1, 2, 3, 4, 5, 6}};
        int[][] festival2 = {{512, 256, 128, 64, 32}, {1, 2, 4, 8, 16}};

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long money = 0;
            int aSum = 0;
            for (int j = 0; j < 6; j++) {
                aSum += festival1[1][j];
                if (a <= aSum) {
                    money += festival1[0][j] * 10000;
                    break;
                }
            }

            int bSum = 0;
            for (int j = 0; j < 5; j++) {
                bSum += festival2[1][j];
                if (b <= bSum) {
                    money += festival2[0][j] * 10000;
                    break;
                }
            }
            System.out.println(money);
        }
    }
}