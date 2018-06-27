package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] answer = new int[n+1];
        int[] temp = new int[n+1];

        answer[1] = 9;
        temp[1] = 1;

        for (int i=2; i<=n; i++) {
            answer[i] = answer[i-1]*2-temp[i-1];
        }

        System.out.println(answer[n]);
    }
}