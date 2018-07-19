package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] p = sc.nextLine().toCharArray();
        int result = 0;

        for (int s = 0; s < p.length; s++) {
            int i = 0;
            int maxLength = 0;
            int size = p.length - s;
            int[] pi = new int[size];
            int compareIdx = 0;
            while (++i < size) {
                while (compareIdx > 0 && p[compareIdx + s] != p[i + s])
                    compareIdx = pi[compareIdx - 1];

                if (p[compareIdx + s] == p[i + s]) {
                    pi[i] = ++compareIdx;
                    if (maxLength < pi[i]) maxLength = pi[i];
                }
            }

            if (result < maxLength) result = maxLength;
        }
        System.out.println(result);
    }
}