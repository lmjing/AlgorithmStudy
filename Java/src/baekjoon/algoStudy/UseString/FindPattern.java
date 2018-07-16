package baekjoon.algoStudy.UseString;

import java.util.*;

public class FindPattern {
    public static void num10769(String[] args) {
        // 쉬운 문제라 (찾고자 하는 패턴 내에 중복된 패턴이 없어 되돌아갈 필요가 없다.)
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int check = 0;
        int smileCnt = 0;
        int sadCnt = 0;
        for (char c : input.toCharArray()) {
            if (c == ':' || (c == '-' && check == 1)) {
                check++;
                continue;
            }else if (check == 2) {
                if (c == '(') sadCnt++;
                else if (c == ')') smileCnt++;
            }
            check = 0;
        }

        int diff = smileCnt - sadCnt;
        if (diff == 0) {
            if (smileCnt == 0) System.out.println("none");
            else System.out.println("unsure");
        } else
            System.out.println(diff > 0 ? "happy" : "sad");
    }

    public static void num5525(String[] args) {
        // 쉬운 문제라 (찾고자 하는 패턴이 짧게 반복되어 3개만 확인해 넘길 수 있었기 때문)
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
