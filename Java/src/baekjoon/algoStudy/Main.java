package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];

        int minusCnt = 0;
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
            if (input[i] <= 0) minusCnt++;
        }

        Arrays.sort(input);
        int i = -1;
        int answer = 0;

        while (++i < minusCnt) {
            if (i + 1 < minusCnt) answer += input[i] * input[++i];
            else answer += input[i];
        }

        i = n;
        while (--i >= minusCnt) {
            if (i - 1 >= minusCnt && input[i - 1] > 1)
                answer += input[i] * input[--i];
            else answer += input[i];
        }
        System.out.println(answer);
    }
}