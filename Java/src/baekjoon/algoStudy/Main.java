package baekjoon.algoStudy;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        long[] count = new long[1000];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        count[input[0]] = 1;
        long maxVaule = input[0];
        long maxLength = 1;

        for (int i = 1; i < n; i++) {
            if (input[i-1] < input[i]) {
                count[i] = Math.max(count[i], count[input[i-1]] + 1);
                System.out.println("a : " + count[i]);
            } else {
                if (count[i] == 0) {
                    int idx = i-1;
                    while (idx >= 0 && input[idx] >= input[i]) idx--;
                    count[i] = idx == -1 ? 1 : count[idx] + 1;
                    System.out.println("b : " + count[i]);
                }
            }
            max = max < count[i] ? count[i] : max;
            System.out.println("m : " + max);
        }
        System.out.println(max < count[n-1] ? count[n-1] : max);
    }
}