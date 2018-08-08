package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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

//    static int getCount (int[] array, int find) {
//        int i = binary_search(array, find);
//        if (i == -1) return 0;
//        else return
//
////        int count = 0;
////        for (int j = i; j < array.length && array[j] == find; j++)
////            count++;
////        for (int j = i - 1; j >= 0 && array[j] == find; j--)
////            count++;
//        return count;
//    }

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
}