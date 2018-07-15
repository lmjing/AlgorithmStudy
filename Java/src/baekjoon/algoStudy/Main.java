package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> minus = new LinkedList<>();
        LinkedList<Integer> plus = new LinkedList<>();

        int minusCnt = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input > 0) plus.add(input);
            else minus.add(input);
        }

        Arrays.sort(input);
        int mi = 0;
        int temp = 1; // 묶을 값들
        boolean turn = true; // true : 1번 째 값
        int answer = 0;

        for (int su : input) {
            if (su <= 0) {
                mi++;
                if (mi < minusCnt) {
                    temp *= su;
                    if (mi % 2 == 0) {
                        answer += temp;
                        temp = 1;
                    }
                } else answer += su;
            } else {

            }
        }
    }
}