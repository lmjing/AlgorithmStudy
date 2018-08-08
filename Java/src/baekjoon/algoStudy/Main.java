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
            int find = sc.nextInt();
            int lb = lower_bound(haved, find);
            int ub = upper_bound(haved, find);
            System.out.print(ub - lb +" ");
        }
    }

    static int binary_search (int[] array, int find) {
        // NOTE : 찾은 idx 리턴하는 함수 (추후 활용하게 idx로 만듦)
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            int half = (l + r) / 2;
            if (array[half] == find)
                return half;
            else if (array[half] < find)
                l = half + 1;
            else
                r = half - 1;
        }
        return -1;
    }

    static int upper_bound (int[] array, int find) {
        // NOTE : 찾고자 하는 값보다 큰 값이 처음 나오는 위치
        int l = 0;
        int r = array.length;

        while (l < r) {
            int half = (l + r) / 2;
            if (array[half] <= find)
                l = half + 1;
            else r = half;
        }
        return r;
    }

    static int lower_bound (int[] array, int find) {
        // NOTE : 찾고자 값이 처음 나오는 위치
        int l = 0;
        int r = array.length;

        while (l < r) {
            int half = (l + r) / 2;
            if (array[half] < find)
                l = half + 1;
            else r = half;
        }
        return r;
    }
}