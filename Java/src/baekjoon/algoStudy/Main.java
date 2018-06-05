package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static Scanner sc;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Number> queue = new LinkedList<>();

        queue.add(new Number(n, 0));
        while (!queue.isEmpty()) {
            Number now = queue.remove();
            if (now.num == 1) {
                System.out.println(now.count);
                break;
            }
            if (n % 3 == 0) queue.add(new Number(now.num / 3, now.count + 1));
            if (n % 2 == 0) queue.add(new Number(now.num / 2, now.count + 1));
            queue.add(new Number(now.num - 1, now.count + 1));
        }
    }

    static class Number {
        int num;
        int count;

        public Number (int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}