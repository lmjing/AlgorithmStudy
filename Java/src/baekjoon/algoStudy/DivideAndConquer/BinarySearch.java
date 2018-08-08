package baekjoon.algoStudy.DivideAndConquer;

import java.util.*;

public class BinarySearch {
    static int binary_search (int[] array, int find) {
        // NOTE : 찾은 idx 리턴하는 함수 (추후 활용하게 idx로 만듦)
        // NOTE : 전제 : array는 정렬된 배열이다.
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (array[m] == find)
                return m;
            else if (array[m] < find)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }


    static int upper_bound (int[] array, int find) {
        // NOTE : 찾고자 하는 값보다 큰 값이 처음 나오는 위치
        int l = 0;
        int r = array.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (array[m] <= find)
                l = m + 1;
            else r = m;
        }
        return r;
    }

    static int lower_bound (int[] array, int find) {
        // NOTE : 찾고자 값이 처음 나오는 위치
        int l = 0;
        int r = array.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (array[m] < find)
                l = m + 1;
            else r = m;
        }
        return r;
    }

    public static void num10815 () {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] haved = new int[m];
        for (int i = 0; i < m; i++)
            haved[i] = sc.nextInt();

        Arrays.sort(haved);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print((binary_search(haved, sc.nextInt()) > -1 ? 1 : 0) + " ");
        }
    }

    public static void num10816_userMap() {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();
        int m = sc.nextInt();
        int[] haved = new int[m];
        for (int i = 0; i < m; i++) {
            haved[i] = sc.nextInt();
            Object before = map.get(haved[i]);
            if (before != null)
                map.put(haved[i], (int)before + 1);
            else map.put(haved[i], 1);
        }

        Arrays.sort(haved);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int find = sc.nextInt();
            if (binary_search(haved, find) == -1)
                System.out.print(0 + " ");
            else
                System.out.print(map.get(find) + " ");
        }
    }

    public static void num10816_useUpperLowerBound() {
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
}
