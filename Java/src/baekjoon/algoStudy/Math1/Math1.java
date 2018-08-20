package baekjoon.algoStudy.Math1;

import java.util.*;

public class Math1 {
    public static void num11005() {
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
