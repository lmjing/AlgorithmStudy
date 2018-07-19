package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] p = sc.nextLine().toCharArray();
        int[] pi = new int[p.length];
        int[] alphabet = new int[26];

        int i = 0;
        int maxLength = 0;
        int startIdx = 0;
        int compareIdx = 0;

        for (int k = 0; k < 26; k++)
            alphabet[k] = -1;
//        System.out.print(pi[i]);
        while (++i < pi.length) {
            while (compareIdx > 0 && p[compareIdx] != p[i])
                compareIdx = pi[compareIdx - 1];

            if (p[compareIdx] == p[i]) {
                pi[i] = ++compareIdx - startIdx;
                if (maxLength < pi[i]) maxLength = pi[i];
            } else if (alphabet[p[i] - 'a'] > -1){
                startIdx = alphabet[p[i] - 'a'];
                compareIdx = startIdx + 1;
                pi[i] = 1;
                if (maxLength < 1) maxLength = 1;
            } else alphabet[p[i] - 'a'] = i;
//                charIdxs.put(p[i], i);
//            System.out.print(pi[i]);
        }
//        System.out.println("");
        System.out.println(maxLength);
    }
}