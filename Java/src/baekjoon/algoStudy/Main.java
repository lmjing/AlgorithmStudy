package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        String str = new String();
        while (n > 0) {
            int r = n % b;
            str = (char)(r + (r < 10 ? 48 : 55)) + str;
            n -= r;
            n /= b;
        }
        System.out.print(str);
    }
}