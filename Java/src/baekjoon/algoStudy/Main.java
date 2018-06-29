package baekjoon.algoStudy;

import java.io.*;
import java.util.*;

public class Main {
    static String[][] array;
    static long max;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            array = new String[2][n];
            max = 0;

            for (int j = 0; j < 2; j++) array[j] = br.readLine().split(" ");
            goTo(0, 0, 0);
            goTo(0, 1, 0);
            System.out.println(max);
        }
    }

    static void goTo (int x, int y, long sum) {
        if (x >= n) {
            max = max < sum ? sum : max;
            return;
        }
        goTo(x + 1, Math.abs(1 - y), sum + Integer.parseInt(array[y][x]));
        goTo(x + 2, Math.abs(1 - y), sum + Integer.parseInt(array[y][x]));
    }
}