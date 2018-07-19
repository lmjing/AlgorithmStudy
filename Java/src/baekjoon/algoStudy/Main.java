package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        int result = 0;

        while (str.length() > 0) {
            int maxLength = 0;
            for (int l : getProcessing(str.toString())) {
                if (maxLength < l) maxLength = l;
            }
            if (result < maxLength) result = maxLength;
            str = str.deleteCharAt(0);
        }
        System.out.println(result);
    }

    static int[] getProcessing (String str) {
        char[] p = str.toCharArray();
        int[] pi = new int[p.length];

        int i = 0;
        int compareIdx = 0;
        while (++i < p.length) {
            while (compareIdx > 0 && p[compareIdx] != p[i])
                compareIdx = pi[compareIdx - 1];

            if (p[compareIdx] == p[i])
                pi[i] = ++compareIdx;
        }
        return pi;
    }
}