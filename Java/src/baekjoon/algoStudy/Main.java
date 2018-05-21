package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] input;
    static int[] index = {0, 0, 0, 0};
    static int count = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        input = new int[n][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<4; j++) {
                input[i][j]= sc.nextInt();
            }
        }

        int N = n*n;
        int[] front = new int[N];
        int[] back = new int[N];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                front[i * n + j] = input[i][0] + input[j][1];
                back[i * n + j] = input[i][2] + input[j][3];
            }
        }

        Arrays.sort(front);
        Arrays.sort(back);

        int fi = 0;
        int bi = N - 1;

        while (fi < N && bi >= 0) {
            int f = front[fi]; int b = back[bi];
            if (f * b == 1) break;

            int sum = f + b;
            if (sum == 0) {
                int c1 = 1, c2 = 1;
                while (++fi < N && front[fi] == f) c1++;
                while (--bi >= 0 && back[bi] == b) c2++;
                count += c1 * c2;
            }else if (sum > 0) bi--;
            else fi++;
        }

        System.out.println(count);
    }
}