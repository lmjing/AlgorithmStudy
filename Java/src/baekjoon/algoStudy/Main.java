package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int count = 0;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solve(n, 1, 3);
        System.out.println(count);
        System.out.print(result);
    }

    private static void solve(int n, int x, int y) {
        if (n == 0) return;
        int z = 6 - (x + y);
        solve(n - 1, x, z);
        count++;
        result.append(x + " " + y + "\n");
        solve(n - 1, z, y);
    }
}