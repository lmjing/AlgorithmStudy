package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        Arrays.sort(array);
        int sum = array[0];
        for (int i = 1; i < n; i++) {
            array[i] += array[i - 1];
            sum += array[i];
        }
        System.out.println(sum);
    }
}