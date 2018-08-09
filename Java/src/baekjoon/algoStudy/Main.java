package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n + m];
        for (int i = 0; i < n + m; i++)
            array[i] = sc.nextInt();

        for (int su : merge_sort(array, 0, m + n - 1))
            System.out.print(su + " ");
    }

    static int[] merge_sort (int[] array, int s, int e) {
        if (s == e) return new int[]{array[s]};

        int m = (s + e) / 2;

        int[] a = merge_sort(array, s, m);
        int[] b = merge_sort(array, m + 1, e);

        int [] result = new int[e - s + 1];
        int ap = 0, bp = 0;
        for (int i = 0; i < result.length; i++) {
            if (ap >= a.length)
                result[i] = b[bp++];
            else if (bp >= b.length)
                result[i] = a[ap++];
            else result[i] = a[ap] < b[bp] ? a[ap++] : b[bp++];
            if (ap < a.length && a[ap] <= b[bp])
                result[i] = a[ap++];
            else
                result[i] = b[bp++];
        }
        return result;
    }
}