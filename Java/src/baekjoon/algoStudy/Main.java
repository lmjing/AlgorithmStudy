package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] check = new int[n + 1];

        int i = 1;
        while (++i * i <= n) {
            if (check[i] == 0) {
                if (i >= m)
                    System.out.println(i);
                for (int j = i * i; j <= n; j += i) {
                    check[j] = -1;
                }
            }
        }
        while (i <= n) {
            if (check[i] == 0 && i >= m)
                System.out.println(i);
            i++;
        }
    }
}