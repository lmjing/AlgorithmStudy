package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        char[] s = sc.nextLine().toCharArray();

        int result = 0;
        int patternCnt = 0;
        for (int i = 1; i < m - 1; i++) {
            if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                patternCnt++;
                if (patternCnt == n) {
                    patternCnt--;
                    result++;
                }
                i++;
            } else patternCnt = 0;
        }
        System.out.println(result);
    }
}