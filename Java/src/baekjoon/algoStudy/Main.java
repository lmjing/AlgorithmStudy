package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(solve(n, m, k));
    }

    static StringBuilder solve (int n, int m, int k) {
        if (n % 2 == 1 && m + k != n + 1)
            return new StringBuilder("-1");
        if (n % 2 == 0 && (m + k != n + 1) && !(m == n / 2 && k == n / 2))
            return new StringBuilder("-1");
        StringBuilder result = new StringBuilder();
        int s = 1, e = n;

        // 오름차순
        while (s < m)
            result.append(s++ + " ");

        result.append(e-- + " ");
        // 내림차순
        int temp = s + (k - 1);
        String des = "";
        while (s < temp)
            des = (s++) + " " + des;

        result.append(des);

        while (s <= e) {
            result.append(e-- + " ");
            if (s <= e) result.append(s++ + " ");
        }
        return result;
    }
}