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

    public static void num11722() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n][2];
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i][0] = sc.nextInt();
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j][0] > dp[i][0])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }
            maxLength = Math.max(maxLength, dp[i][1]);
        }

        System.out.println(maxLength);
    }

    public static void num11054() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n][3]; // 0: vaule, 1: length(<), 2: length(>)
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            dp[i][0] = v;
            dp[i][1] = 1; dp[i][2] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j][0] < v)
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
                if (dp[j][0] > v) {
                    dp[i][2] = Math.max(dp[i][2], dp[j][2] + 1);
                    dp[i][2] = Math.max(dp[i][2], dp[j][1] + 1);
                }
            }
            maxLength = Math.max(maxLength, Math.max(dp[i][1], dp[i][2]));
        }
        System.out.println(maxLength);
    }

    public static class Num1912 {
        static int[] input;
        static long max;
        public static void top_down() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            input = new int[n + 1];
            for (int i = 1; i <= n; i++) input[i] = sc.nextInt();
            getMaxSum(n);

            System.out.println(max);
        }

        static long getMaxSum (int n) {
            if (n == 1) {
                max = input[n];
                return input[n];
            }
            long sum = Math.max(input[n], getMaxSum(n - 1) + input[n]);
            max = Math.max(max, sum);
            return sum;
        }

        public static void bottom_up() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            long max = -1000000001;
            long[] dp = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                int input = sc.nextInt();
                dp[i] = Math.max(input, dp[i - 1] + input);
                max = max < dp[i] ? dp[i] : max;
            }
            System.out.println(max);
        }
    }

    static public class Num4811 {
        // TODO : 다시풀기
        static long[][] dp = new long[30][31];
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            while (input > 0) {
                System.out.println(goTo(input - 1, 1));
                input = sc.nextInt();
            }

        }

        static long goTo (int w, int h) {
            if (w == 0) dp[w][h] = 1;
            else if (dp[w][h] == 0) {
                long sum = 0;
                sum += goTo(w - 1, h + 1);
                if (h > 0)
                    sum += goTo(w, h - 1);
                dp[w][h] = sum;
            }
            return dp[w][h];
        }
    }

    static public class Num2579 {
        static int[][] dp;
        public static void top_down (String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            dp = new int[n + 1][2];

            for (int i = 1; i <= n; i++) {
                dp[i][0] = dp[i][1] = sc.nextInt();
            }

            goTo(n);
            System.out.println(Math.max(dp[n][0], dp[n][1]));
        }

        static void goTo (int i) {
            if (i <= 1) return;
            goTo(i - 1);
            if (i > 2)
                dp[i][0] += Math.max(dp[i - 2][0], dp[i - 2][1]);
            dp[i][1] += dp[i - 1][0];
        }

        public static void bottom_up (String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                int step = sc.nextInt();
                dp[i][0] = (i > 1 ? Math.max(dp[i - 2][1], dp[i - 2][0]) : 0) + step;
                dp[i][1] = (i > 0 ? dp[i - 1][0] : 0) + step;
            }
            System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
        }
    }

    public static class Num2133 {
        static int[] dp;

        public static void bottom_up () {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            dp = new int[n + 1];

            int answer = 0;
            if (n % 2 == 0) {
                dp[2] = 3;
                dp[0] = 1;
                for (int i = 4; i <= n; i += 2) {
                    for (int j = 2; j <= i; j += 2) {
                        int standard = j == 2 ? 3 : 2;
                        dp[i] += standard * dp[i - j];
                    }
                }
                answer = dp[n];
            }

            System.out.println(answer);
        }

        public static void top_down () {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            dp = new int[n + 1];
            System.out.println(n % 2 == 0 ? goTo(n) : 0);
        }

        static int goTo (int n) {
            if (n == 0) return 1;
            if (n == 2) dp[2] = 3;
            else if (dp[n] == 0) {
                for (int i = 2; i <= n; i += 2) {
                    int standard = i == 2 ? 3 : 2;
                    dp[n] += standard * goTo(n - i);
                }
            }
            return dp[n];
        }
    }

    static class Num9461 {
        static long[] dp = new long[101];
        public static void momWay_bottomUp() {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            dp[1] = dp[2] = 1;
            for (int i = 3; i <= 100; i++)
                dp[i] = dp[i - 2] + dp[i - 3];

            for (int i = 0; i < T; i++)
                System.out.println(dp[sc.nextInt()]);
        }

        public static void momWay_topDown() {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int i = 0; i < T; i++)
                System.out.println(goTo(sc.nextInt()));
        }

        static long goTo (int n) {
            if (n == 1 || n == 2) dp[n] = 1;
            else if (dp[n] == 0 && n > 0)
                dp[n] = goTo(n - 2) + goTo(n - 3);
            return dp[n];
        }

        public static void myWay_bottomUp() {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            dp[1] = dp[2] = dp[3] = 1;
            dp[4] = dp[5] = 2;
            for (int i = 6; i <= 100; i++)
                dp[i] = dp[i - 1] + dp[i - 5];

            for (int i = 0; i < T; i++)
                System.out.println(dp[sc.nextInt()]);

        }

        public static void myWay_topDown() {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            for (int i = 0; i < T; i++)
                System.out.println(goTo2(sc.nextInt()));

        }

        static long goTo2 (int n) {
            if (n == 1 || n == 2 || n == 3) dp[n] = 1;
            else if (n == 4 || n == 5) dp[n] = 2;
            else if (dp[n] == 0 && n > 0)
                dp[n] = goTo(n - 1) + goTo(n - 5);
            return dp[n];
        }
    }

    public static class Num2225 {
        static int[][] dp;
        public static void top_down() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();

            dp = new int[n + 1][k + 1];
            System.out.println(goTo(n, k));
        }

        static int goTo (int n, int k) {
            if (n == 1)
                dp[n][k] = k;
            else if (k == 1)
                dp[n][k] = 1;
            else if (dp[n][k] == 0)
                dp[n][k] = goTo(n - 1, k) + goTo(n, k - 1);
            return dp[n][k] % 1000000000;
        }

        public static void bottom_up() {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();

            dp = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (i == 1) dp[i][j] = j;
                    else if (j == 1) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    dp[i][j] %= 1000000000;
                }
            }
            System.out.println(dp[n][k]);
        }
    }

    public static void num2011() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int mod = 1000000;
        int[] dp = new int[input.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= input.length(); i++) {
            int now = i - 1;
            if (input.charAt(now) > '0')
                dp[i] = dp[i - 1];
            int su = (input.charAt(now - 1) - '0') * 10 + (input.charAt(now) - '0');
            if (su >= 10 && su <= 26)
                dp[i] = (dp[i] + dp[i - 2]) % mod;
        }
        System.out.println(input.equals("0") ? 0 : dp[input.length()]);
    }

    public class Num2580 {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int[][] sudoku = new int[9][9];
            boolean[][][] check = new boolean[3][9][9];
            LinkedList<Point> emptyPoints = new LinkedList<>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    int su = sc.nextInt();
                    sudoku[i][j] = su;
                    if (su > 0) {
                        su--;
                        int box = (i / 3) * 3 + (j / 3);
                        check[0][i][su] = check[1][j][su] = check[2][box][su] = true;
                    } else emptyPoints.add(new Point(i, j));
                }
            }
            solve(sudoku, check, emptyPoints);
        }

        boolean solve (int[][] sudoku, boolean[][][] check, LinkedList<Point> emptyPoints) {
            // NOTE : 틀린 이유는 빈칸 리스트가 잘못됨. 아예 중간에 틀리면 뒤에 add가 되버려서... 이상해짐....순서가..
            if (emptyPoints.isEmpty()) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder str = new StringBuilder(String.valueOf(sudoku[i][0]));
                    for (int j = 1; j < 9; j++)
                        str.append(" " + sudoku[i][j]);
                    System.out.println(str);
                }
                return true;
            }
            Point p = emptyPoints.remove();
            int box = (p.x / 3) * 3 + (p.y / 3);
            for (int i = 0; i < 9; i++) {
                if (!check[0][p.x][i] && !check[1][p.y][i] && !check[2][box][i]) {
                    sudoku[p.x][p.y] = i + 1;
                    check[0][p.x][i] = check[1][p.y][i] = check[2][box][i] = true;

                    if (solve(sudoku, check, emptyPoints)) return true;

                    sudoku[p.x][p.y] = 0;
                    check[0][p.x][i] = check[1][p.y][i] = check[2][box][i] = false;
                }
            }
            emptyPoints.addFirst(p);
            return false;
        }

        class Point {
            int x, y;
            public Point (int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
