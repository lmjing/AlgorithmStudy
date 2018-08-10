package baekjoon.algoStudy.DivideAndConquer;

import java.util.*;

public class Sort {
    private static void quickSort(int[] array, int s, int e) {
        if (s >= e) return;
        int m = (s + e) / 2;
        int pivot = array[m];
        int l = s, r = e;
        while (l < r) {
            while (array[l] < pivot) l++;
            while (array[r] > pivot) r--;
            if (l < r)
                swap(array, l, r);
        }
        quickSort(array, s, l - 1);
        quickSort(array, l + 1, e);
    }

    private static void swap(int[] array, int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
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
        }
        return result;
    }

    public void num11728() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n + m];
        for (int i = 0; i < n + m; i++)
            array[i] = sc.nextInt();

        for (int su : merge_sort(array, 0, m + n - 1))
            System.out.print(su + " ");
    }


    public static void num2751() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        quickSort(array, 0 , array.length - 1);
        for (int su : array)
            System.out.println(su);
    }
}
