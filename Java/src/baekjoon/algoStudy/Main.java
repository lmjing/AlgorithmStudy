package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] haved = new int[m];
        for (int i = 0; i < m; i++)
            haved[i] = sc.nextInt();

        Arrays.sort(haved);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print((binary_search(haved, sc.nextInt(), 0, m - 1) > -1 ? 1 : 0) + " ");
        }
    }

    static int binary_search (int[] array, int find, int s, int e) {
        if (s > e) return -1;

        int half = s + (e - s) / 2;
        if (array[half] == find) return half;
        else if (array[half] < find) return binary_search(array, find, half + 1, e);
        else return binary_search(array, find, s, half - 1);
    }
}