package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] minArray = new int[n+1];

        for (int i = 2; i <= n; i++) {
            int min = minArray[i-1] + 1;
            if (i % 3 == 0) min = Math.min(min, minArray[i/3] + 1);
            if (i % 2 == 0) min = Math.min(min, minArray[i/2] + 1);
            minArray[i] = min;
        }
        System.out.println(minArray[n]);
    }
}