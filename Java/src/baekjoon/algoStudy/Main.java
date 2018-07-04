package baekjoon.algoStudy;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n]; // 0 : value, 1 : count
//        int[] sorted = new int[n];
        LinkedList<Integer> sorted = new LinkedList<>();

        long[] count = new long[1000];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
//            sorted[i] = input[i];
            sorted.add(input[i]);
            count[input[i]] = 1;
        }
//        Arrays.sort(sorted);
        Collections.sort(sorted);

        for (int i = 1; i < n; i++) {
            if (input[i-1] < input[i]) {
                count[i] += Math.max(count[input[i-1]], count[sorted.indexOf(input[i]) - 1]);
            }else {
                Iterator<Integer> t = sorted.iterator();
                
            }
        }
    }
}