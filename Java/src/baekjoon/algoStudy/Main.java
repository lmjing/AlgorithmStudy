package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] T = sc.nextLine().toCharArray();
        char[] P = sc.nextLine().toCharArray();

        ArrayList<Integer> result = kmp(T, P);
        StringBuilder answer = new StringBuilder();
        for (int i : result)
            answer.append(i + " ");

        System.out.println(result.size());
        System.out.println(answer);
    }

    static int[] preprocessing(char[] P) {
        int[] p = new int[P.length];
        for (int i = 1; i < P.length; i++) {
            int compareIdx = p[i - 1];
            while (compareIdx > 0 && P[compareIdx] != P[i])
                compareIdx = p[compareIdx - 1];

            if (P[compareIdx] == P[i])
                p[i] = compareIdx + 1;
        }
        return p;
    }

    static ArrayList<Integer> kmp(char[] T, char[] P) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] pi = preprocessing(P);
        int i = -1, j = 0;
        while (++i < T.length) {
            while (j > 0 && T[i] != P[j]) j = pi[j - 1];

            if (T[i] == P[j]) {
                j++;
                if (j == P.length) {
                    result.add(i - P.length + 2);
                    j = pi[j - 1];
                }
            }
        }
        return result;
    }
}