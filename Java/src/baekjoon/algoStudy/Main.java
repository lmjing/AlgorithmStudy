package baekjoon.algoStudy;

import java.util.*;

public class Main {

    static int n;
    static int s;
    static int[] array;
    static int count = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }
        nextSubset(0, 1, array[0]);
        nextSubset(0, 0, 0);
        System.out.println(count);
    }

    static void nextSubset (int i, int c, int sum) {
        if (n <= i) {
            if (sum == s && c > 0)
                count++;
            return;
        }
        nextSubset(i+1, c+1, sum + array[i]);
        nextSubset(i+1, c, sum);
    }
}