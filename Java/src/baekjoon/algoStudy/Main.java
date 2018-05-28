package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static Scanner sc;
    static int T;
    static int as, al, bs, bl;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        T = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        Pizza A = new Pizza(m);
        Pizza B = new Pizza(n);


        // -4, -2, 0, 3 => -5이상 가능 인데 -4부터 있어서 -4부터 / 5부터 가능한데, 3까지 밖에 없어서 마지막 부터
        // 0, 3, 4, 10, 14, 15 => 1초과 ~ / 9이하만 가능

        int minA = T - B.subSumVector.get(B.subSumVector.size() - 1) - 1;
        int maxA = T - B.subSumVector.get(0) + 1;
        // 15 ~ 70
        int minB = T - A.subSumVector.get(A.subSumVector.size() - 1) - 1;
        int maxB = T - A.subSumVector.get(0) + 1;
        // start : min 미만인 마지막 구함
        // end : max 초과인 시작점 구함 (upper_bound)
        A.upperbound(minA, maxA, T);
        B.upperbound(minB, minB, T);

        int ai = A.startIdx; int bi = B.lastIdx;
        long result = 0;
        while (ai < A.subSumVector.size() && bi >= 0) {
            int a = A.subSumVector.get(ai);
            int b = B.subSumVector.get(bi);
            int sum = a + b;

            if (sum == T) {
                long cnt1 = 1, cnt2 = 1;
                while (++ai < A.subSumVector.size() && A.subSumVector.get(ai) == a) cnt1++;
                while (--bi >= 0 && B.subSumVector.get(bi) == b) cnt2++;
                result += cnt1 * cnt2;
            } else if (sum > T) bi--;
            else ai++;
        }
        System.out.println(result);
    }

    static class Pizza {
        int[] pizza;
        int size;
        int startIdx;
        int lastIdx;
        int min;
        int max;

        Vector<Integer> subSumVector = new Vector<>();

        public Pizza(int size) {
            pizza = new int[size];
            this.size = size;
            for (int i=0; i<size; i++) pizza[i] = sc.nextInt();

            makeNextSubSum(1, true, 0, pizza[0]);
            makeNextSubSum(1, false, 0, 0);
            Collections.sort(subSumVector);
        }

        public void makeNextSubSum (int i, boolean before, int diffCnt, int sum) {
            if (diffCnt > 2) return;
            if (i == size) {
                subSumVector.add(sum);
                return;
            }
            // ^ = XOR : 달라야 true
            makeNextSubSum(i + 1, true, before ^ true ? diffCnt + 1 : diffCnt, sum + pizza[i]);
            makeNextSubSum(i + 1, false, before ^ false ? diffCnt + 1 : diffCnt, sum);
        }

        public void upperbound (int min, int max, int T) {
            this.min = min > T ? T : min;
            this.max = max < T ? T : max;

            getStartIdx(0, 0, subSumVector.size() - 1);
            getLastIdx(subSumVector.size() - 1, 0, subSumVector.size() - 1);
        }

        public void getStartIdx (int idx, int s, int e) {
//            System.out.println(idx + " " + s + " " + e);
            if (s >= e) {
                startIdx = e;
                return;
            }

            if (subSumVector.get(idx) < min) {
                getLastIdx((s + idx - 1)/2, s, idx - 1);
            } else {
                getLastIdx((idx + 1 + e)/2, idx + 1, e);
            }
        }

        public void getLastIdx (int idx, int s, int e) {
//            System.out.println(idx + " " + s + " " + e);
            if (s >= e) {
                lastIdx = e - 1;
                return;
            }

            if (subSumVector.get(idx) > max) {
                getLastIdx((s + idx - 1)/2, s, idx - 1);
            } else {
                getLastIdx((idx + 1 + e)/2, idx + 1, e);
            }
        }
    }
}