package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        while (n > 1) {
            int r = n % b;
            if (r < 10) System.out.print(r);
            else System.out.print((char) (r + 55));
            n -= r;
            n /= b;
        }
    }
}