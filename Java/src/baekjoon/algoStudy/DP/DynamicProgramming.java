package baekjoon.algoStudy.DP;

import java.util.*;

public class DynamicProgramming {
    public void num1463_bottomUp() {
        // USE : DP (Bottom-up)
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

    static class Num1463_TopDown {
        static int[] temp;
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            temp = new int[n+1];

            System.out.println(go(n));
        }

        public static int go (int n) {
            if (n <= 1) return 0;
            if (temp[n] > 0) return temp[n];

            int min = go(n - 1) + 1;
            if (n % 3 == 0) min = Math.min(min, go(n / 3) + 1);
            if (n % 2 == 0) min = Math.min(min, go(n / 2) + 1);
            temp[n] = min;

            return min;
        }
    }

    static class Num11726 {
        static long[] tile;
        public static void bottom_up () {
            Scanner sc  = new Scanner(System.in);

            int n = sc.nextInt();
            tile = new long[n+1];

            tile[1] = 1;
            if (n > 1) tile[2] = 2;

            for (int i = 3; i <= n; i++) tile[i] = (tile[i-2] + tile[i-1]) % 10007;

            System.out.println(tile[n]);
        }
    }
}
