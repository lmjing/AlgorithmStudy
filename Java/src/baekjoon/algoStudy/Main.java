package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuffer S = new StringBuffer();
        for (int i = 0; i < n; i++)
            S.append(sc.nextLine() + " ");

        int result = 0;
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine();
            if (S.toString().contains(str)) result++;
        }
        System.out.println(result);
    }
}