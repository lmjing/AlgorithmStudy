package baekjoon.algoStudy.UseString;

import java.util.*;

public class FindPattern {
    public static class KMP {
        static int[] preprocessing (String str) {
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

    public static class Num1786 {
        // USE : KMP (완전 설명하는 문제)

        public static void answer1(String[] args) {
            // NOTE : 정답을 위한 코드 (더 빠르고 짧음)
            Scanner sc = new Scanner(System.in);
            char[] T = sc.nextLine().toCharArray();
            char[] P = sc.nextLine().toCharArray();

            // 전처리
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

        public static void answer2() {
            //NOTE : AKM 재사용 목적으로 컴포넌트 구분함.
            Scanner sc = new Scanner(System.in);
            char[] T = sc.nextLine().toCharArray();
            String P = sc.nextLine();

            ArrayList<Integer> result = kmp(T, P);
            StringBuilder answer = new StringBuilder();
            for (int i : result)
                answer.append(i + " ");

            System.out.println(result.size());
            System.out.println(answer);
        }

        static ArrayList<Integer> kmp(char[] T, String P) {
            ArrayList<Integer> result = new ArrayList<>();
            int[] pi = KMP.preprocessing(P);
            int i = -1, j = 0;
            while (++i < T.length) {
                while (j > 0 && T[i] != P.indexOf(j)) j = pi[j - 1];

                if (T[i] == P.indexOf(j)) {
                    j++;
                    if (j == P.length()) {
                        result.add(i - P.length() + 2);
                        j = pi[j - 1];
                    }
                }
            }
            return result;
        }
    }

    public static void num1305() {
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

    public static class Num1701 {
        public static void shortVersion() {
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

        public static void longVersion() {
            Scanner sc = new Scanner(System.in);
            StringBuilder str = new StringBuilder(sc.nextLine());
            int result = 0;

            while (str.length() > 0) {
                int maxLength = 0;
                for (int l : KMP.preprocessing(str.toString())) {
                    if (maxLength < l) maxLength = l;
                }
                if (result < maxLength) result = maxLength;
                str = str.deleteCharAt(0);
            }
            System.out.println(result);
        }
    }
}