package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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