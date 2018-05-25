package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static Scanner sc;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        Pizza A = new Pizza(m);
        Pizza B = new Pizza(n);

        int ai = 0; int bi = B.subSumVector.size() - 1;
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
        Vector<Integer> subSumVector = new Vector<>();

        public Pizza(int size) {
            pizza = new int[size];
            this.size = size;
            for (int i=0; i<size; i++) pizza[i] = sc.nextInt();

//            System.out.println("=====================");
            makeNextSubSum(1, true, 0, pizza[0]);
//            System.out.println("---------------------");
            makeNextSubSum(1, false, 0, 0);
            Collections.sort(subSumVector);

//            StringBuilder str = new StringBuilder();
//            for (int s : subSumVector) str.append(s + " ");
//            System.out.println(str);
        }

        public void makeNextSubSum (int i, boolean before, int diffCnt, int sum) {
//            System.out.println(i + " " + before + " " + diffCnt + " " + sum);
            if (diffCnt > 2) return;
            if (i == size) {
//                System.out.println("add : "+ sum + "/ size : " + size + ", i : " + i);
                subSumVector.add(sum);
                return;
            }

            // ^ = XOR : 달라야 true
            makeNextSubSum(i + 1, true, before ^ true ? diffCnt + 1 : diffCnt, sum + pizza[i]);
            makeNextSubSum(i + 1, false, before ^ false ? diffCnt + 1 : diffCnt, sum);
        }
    }
}