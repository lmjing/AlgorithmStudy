package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = Integer.parseInt(sc.nextLine());
        char[] screen = sc.nextLine().toCharArray();

        int i = 0;
        int[] pi = new int[L];
        while (++i < L) {
            int compareIdx = pi[i - 1];
            while (compareIdx > 0 && screen[i] != screen[compareIdx])
                compareIdx = pi[compareIdx - 1];

            if (screen[i] == screen[compareIdx])
                pi[i] = compareIdx + 1;
        }
        System.out.println(L - pi[L - 1]);
    }
}