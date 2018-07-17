package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] T = sc.nextLine().toCharArray();
        char[] P = sc.nextLine().toCharArray();

        int[] p = new int[P.length];
        for (int i = 1; i < P.length; i++) {
            int compareIdx = p[i - 1];
            while (compareIdx > 0 && P[compareIdx] != P[i])
                compareIdx = p[compareIdx - 1];

            if (P[compareIdx] == P[i])
                p[i] = compareIdx + 1;
        }

        int i = -1;
        int j = 0;
        int count = 0;
        StringBuilder answer = new StringBuilder("");
        while (++i < T.length) {
            while (j > 0 && T[i] != P[j]) {
                j = p[j - 1];
            }

            if (T[i] == P[j]) {
                j++;
                if (j == P.length) {
                    count++;
                    answer.append((i - P.length + 2) + " ");
                    j = p[j - 1];
                }
            }
        }

        System.out.println(count);
        System.out.println(answer);
    }
}