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
}
