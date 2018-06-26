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

    static class Num9095 {
        static int[] answer = new int[11];
        public static void bottom_up () {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for (int i = 1; i <= 10; i++) {
                if (i < 4) answer[i] = 1;
                for (int j = 1; j <= 3 && j < i; j++) {
                    answer[i] += answer[i - j];
                }
            }

            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                System.out.println(answer[n]);
            }
        }

        public static void Top_down () {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            goTo(10);

            for (int i = 0; i < T; i++) {
                int n = sc.nextInt();
                System.out.println(answer[n]);
            }
        }

        public static int goTo (int n) {
            if (n <= 3) answer[n] = 1;
            for (int i = 1; i <= 3 && i < n; i++) {
                answer[n] += answer[n - i] == 0 ? goTo(n - i) : answer[n - i];
            }
            return answer[n];
        }
    }

    static class Num11052 {
        static int[] max;
        static int[] price;

        public static void bottom_up() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            price = new int[n + 1];
            max = new int[n + 1];
            max[1] = price[1];

            for (int i = 1; i <= n; i++) {
                price[i] = sc.nextInt();
                max[i] = price[i];
                for (int j = i - 1; j >= i / 2 && i > 1; j--) {
                    if (max[j] + price[i - j] > max[i]) max[i] = max[j] + price[i - j];
                }
            }

            System.out.println(max[n]);
        }

        public static void top_down() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            price = new int[n + 1];
            max = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                price[i] = sc.nextInt();
                max[i] = price[i];
                for (int j = i - 1; j >= i / 2 && i > 1; j--) {
                    if (max[j] + price[i - j] > max[i]) max[i] = max[j] + price[i - j];
                }
            }

            System.out.println(max[n]);
        }

        public static int goTo (int n) {
            if (max[n] == 0) {
                max[n] = price[n];
                if (n > 1) {
                    for (int j = n - 1; j >= n / 2; j--) {
                        if (goTo(j) + price[n - j] > max[n]) max[n] = max[j] + price[n - j];
                    }
                }
            }
            return max[n];
        }
    }
}
