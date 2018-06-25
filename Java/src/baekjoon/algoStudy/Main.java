package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[] answer = new int[11];
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        goTo(10);

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(answer[n]);
        }
    }

    public static int goTo (int n) {
        if (n == 1) return 1;
        if (n <= 3) answer[n] = 1;
        for (int i = 1; i <= 3 && i < n; i++) {
            answer[n] += answer[n - i] == 0 ? goTo(n - i) : answer[n - i];
        }
        return answer[n];
    }
}