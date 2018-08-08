package baekjoon.algoStudy;

import java.util.*;

public class DivideAndConquer {
    static int binary_search (int[] array, int find) {
        // NOTE : 찾은 idx 리턴하는 함수 (추후 활용하게 idx로 만듦)
        // NOTE : 전제 : array는 정렬된 배열이다.
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
}
