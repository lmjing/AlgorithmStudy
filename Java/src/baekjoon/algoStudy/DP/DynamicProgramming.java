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
        // NOTE : 규칙이 단순한거였는데 너무 딥하게 들어가서 3~4시간 걸림..
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

        public static void top_down () {
            Scanner sc  = new Scanner(System.in);

            int n = sc.nextInt();
            tile = new long[n+1];

            tile[1] = 1;
            if (n > 1) tile[2] = 2;

            System.out.println(goTo(n));
        }

        public static long goTo (int n) {
            if (n==1) return 1;
            if (n==2) return 2;

            long a = tile[n-1] > 0 ? tile[n-1] : goTo(n-1);
            long b = tile[n-2] > 0 ? tile[n-2] : goTo(n-2);
            tile[n] = (a + b) % 10007;

            return tile[n];
        }
    }

    static class Num11727 {
        //NOTE : 30분도 안걸림
        static int[] tile;
        public static void bottom_up () {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            tile = new int[n+1];
            tile[1] = 1;
            if (n > 1) tile[2] = 3;

            for (int i = 3; i <= n; i++) {
                tile[i] = (tile[i-2] * 2 + tile[i-1]) % 10007;
            }

            System.out.println(tile[n]);
        }

        public static void top_down () {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            tile = new int[n+1];
            tile[1] = 1;
            if (n > 1) tile[2] = 3;

            System.out.println(goTo(n));
        }

        public static int goTo (int n) {
            if (n > 2)
                tile[n] = (goTo(n-1) + tile[n-2] * 2) % 10007;
            return tile[n];
        }
    }
}
