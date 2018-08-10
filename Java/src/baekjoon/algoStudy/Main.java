package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        quickSort(array, 0 , array.length - 1);
        for (int su : array)
            System.out.println(su);
    }

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
}