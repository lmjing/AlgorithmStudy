package baekjoon.algoStudy.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static class Num11057 {
        public static void bottom_up() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int[] temp = new int[10];
            for (int i = 0; i < 10; i++) temp[i] = 1;

            for (int j = 1; j < n; j++) {
                for (int i = 1; i < 10; i++) {
                    temp[i] = (temp[i] + temp[i-1]) % 10007;
                }
            }

            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += temp[i];
            }
            System.out.println(sum % 10007);
        }
    }

    public static void top_down() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long sum = 0;
        for (int su : goTo(n)) sum += su;
        System.out.println(sum % 10007);
    }

    static int[] goTo (int n) {
        int[] current = new int[10];
        if (n == 1) {
            for (int i = 0; i < 10; i++) current[i] = 1;
        }else {
            int[] before = goTo(n - 1);
            current[0] = 1;
            for (int i = 1; i < 10; i++) current[i] = (current[i-1] + before[i]) % 10007;
        }
        return current;
    }

    public static class Num9465 {
        // TODO : 답지 보고 품 다시 풀 것, 다시 혼자 풀어서 맞았을 경우에만 포스팅 실시. (틀린 코드도 함께 적어 포스팅)
        // NOTE : 기존 방식 (백준에서 처음에 틀린 코드 보기)는 top-down으로 너무 많은 수가 생기는데, 이 경우는 n번만 돌아서 시간 초과 안 뜸.
        static String[][] input;
        static long[][] dp;
        static int n;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                n = Integer.parseInt(br.readLine());
                input = new String[2][n];
                dp = new long[n+1][3];

                for (int j = 0; j < 2; j++) input[j] = br.readLine().split(" ");

                for (int j = 1; j <= n; j++) {
                    dp[j][0] = Math.max(dp[j-1][1], dp[j-1][2]);
                    dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2]) + Integer.parseInt(input[0][j-1]);
                    dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]) + Integer.parseInt(input[1][j-1]);
                }

                System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
            }
        }
    }

    public static class Num10844 {
        static int[][] dp;

        public static void top_down() {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            dp = new int[N][10];
            getTo(N);

            long sum = 0;
            long answer = 9;
            if (N > 1) {
                for (int i = 0; i < 10; i++) sum += dp[N-1][i];
                answer = (sum * 2 - dp[N-1][0] - dp[N-1][9]) % 1000000000;
            }
            System.out.println(answer);
        }

        static int[] getTo (int n) {
            int[] temp = new int[10];
            if (n == 1) {
                for (int i = 1; i < 10; i++) temp[i] = 1;
            }
            else {
                dp[n-1] = getTo(n-1);
                temp[0] = dp[n-1][1];
                temp[9] = dp[n-1][8];
                for (int i = 1; i < 9; i++)
                    temp[i] = (dp[n-1][i-1] + dp[n-1][i+1]) % 1000000000;
            }
            return temp;
        }

        public static void bottom_up() {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            long[] count = new long[10];
            long sum = 9;
            for (int i = 1; i < 10; i++) count[i] = 1;

            for (int i = 2; i < N; i++) {
                long[] temp = new long[10];
                temp[0] = count[1];
                temp[9] = count[8];
                sum = temp[0] + temp[9];

                for (int j = 1; j < 9; j++) {
                    temp[j] = (count[j-1] + count[j+1]) % 1000000000;
                    sum += temp[j];
                }
                count = temp;
            }

            System.out.println(N == 1 ? sum : (sum * 2 - count[0] - count[9]) % 1000000000);
        }
    }

    static class Num2193 {
        public static void top_down() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            System.out.println(goTo(n)[0]);
        }

        static long[] goTo(int n) {
            if (n == 1) return new long[]{1, 0, 1};

            long[] current = new long[3];
            long[] before = goTo(n - 1);
            current[0] = before[1] * 2 + before[2];
            current[1] = before[1] + before[2];
            current[2] = before[1];
            return current;
        }
    }

    public static void bottom_up() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] dp = new long[n][3];
        dp[0] = new long[]{1, 0, 1};

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][1] * 2 + dp[i-1][2];
            dp[i][1] = dp[i-1][1] + dp[i-1][2];
            dp[i][2] = dp[i-1][1];
        }

        System.out.println(dp[n-1][0]);
    }

    static class Num2156 {
        static int[] input;
        static long[][] dp;
        public static void top_down() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            input = new int[n + 1];
            dp = new long[n + 1][2];

            for (int i = 1; i <= n; i++) input[i] = sc.nextInt();
            dp[n] = goTo(n);
            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }

        public static long[] goTo (int n) {
            if (n == 1) return new long[] {0, input[1]};
            else if (n == 2) return new long[] {input[1], input[1] + input[2]};

            dp[n - 1] = goTo(n - 1);
            long[] current = new long[2];
            current[0] = Math.max(dp[n - 1][0], dp[n - 1][1]);
            current[1] = input[n] + Math.max(dp[n - 2][0] + input[n - 1], dp[n - 1][0]);

            return current;
        }

        public static void bottom_up() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] input = new int[n];
            long[][] dp = new long[n][2];

            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
                if (i == 0) dp[0][1] = input[i];
                else if (i == 1) {
                    dp[1][0] = input[i-1];
                    dp[1][1] = input[i-1] + input[i];
                } else {
                    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                    dp[i][1] = input[i] + Math.max(dp[i-2][0] + input[i-1], dp[i-1][0]);
                }
            }
            System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
        }
    }

    public static void num11053() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][2]; // 0 : length, 1 : last
        int max = 1;

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = sc.nextInt();
            for (int j = 0; j < i; j++) {
                if (dp[j][1] < dp[i][1])
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
            }
            max = max < dp[i][0] ? dp[i][0] : max;
        }
        System.out.println(max);
    }

    public static void num11055() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] input = new int[n][2]; // 0 : vaule, 1 : sum
        int max = 0;

        for (int i = 0; i < n; i++) {
            int vaule = sc.nextInt();
            input[i][0] = vaule;
            input[i][1] = vaule;
            for (int j = 0; j < i; j++) {
                if (vaule > input[j][0])
                    input[i][1] = Math.max(input[i][1], input[j][1] + vaule);
            }
            max = max < input[i][1] ? input[i][1] : max;
        }
        System.out.println(max);
    }
}
