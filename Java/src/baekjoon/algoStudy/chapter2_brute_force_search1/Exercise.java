package baekjoon.algoStudy.chapter2_brute_force_search1;

import baekjoon.algoStudy.Main;

import java.util.Scanner;

public class Exercise {
    static class Pill {
        long count = 0;

        void cal(int n, int half) {
            if (n == 0) {
                count++;
                return;
            }
            if (half > 0) cal(n, half-1);
            if (n > 0) cal(n-1, half + 1);
        }
    }
    static void num4811() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) break;
            Pill pill = new Pill();
            pill.cal(n-1, 1);
            System.out.println(pill.count);
        }
    }
}
