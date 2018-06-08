package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static Scanner sc;
    static boolean[] array;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> before = new LinkedList<>();
        Queue<Integer> after = new LinkedList<>();
        array = new boolean[n+1];
        int count = 0;
        before.add(n);

        while (!before.isEmpty()) {
            int num = before.remove();
            if (num == 1) {
                System.out.println(count);
                break;
            }
            if (num > 1 && !array[num]) {
                array[num] = true;
                if (num % 3 == 0) after.add(num / 3);
                if (num % 2 == 0) after.add(num / 2);
                after.add(num - 1);
            }

            if (before.isEmpty()) {
                before = after;
                after = new LinkedList<>();
                count++;
            }
        }
    }
}