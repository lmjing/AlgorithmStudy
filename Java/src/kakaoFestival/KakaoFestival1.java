package kakaoFestival;

import java.text.DecimalFormat;
import java.util.*;

public class KakaoFestival1 {
    public static void num1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[][] festival1 = {{500, 300, 200, 50, 30, 10}, {1, 2, 3, 4, 5, 6}};
        int[][] festival2 = {{512, 256, 128, 64, 32}, {1, 2, 4, 8, 16}};

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long money = 0;
            int aSum = 0;
            for (int j = 0; j < 6 && a > 0; j++) {
                aSum += festival1[1][j];
                if (a <= aSum) {
                    money += festival1[0][j] * 10000;
                    break;
                }
            }

            int bSum = 0;
            for (int j = 0; j < 5 && b > 0; j++) {
                bSum += festival2[1][j];
                if (b <= bSum) {
                    money += festival2[0][j] * 10000;
                    break;
                }
            }
            System.out.println(money);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] inputs = new int[n + 1];
        long[] sums = new long[n + 1];

        long sum = 0;
        double smallTemp = 999999999;

        for (int i = 1; i <= n; i++) {
            inputs[i] = sc.nextInt();
            sum += inputs[i];
            sums[i] = sum;

            if (i >= k) {
                double average = (double)(sums[i] - sums[i - k]) / k;
                double temp = 0;
                for (int j = i; j > i - k; j--)
                    temp += Math.pow(inputs[j] - average, 2);

                if (smallTemp > temp)
                    smallTemp = temp;
            }
        }

        DecimalFormat form = new DecimalFormat("#.###########");
        double dNumber = Math.sqrt(smallTemp / k);
        System.out.println(form.format(dNumber)); //10.12 출력
//        String answer = String.format("%.11f", Math.sqrt(smallTemp / k));
//        System.out.println(answer);
//        System.out.println(Math.sqrt(smallTemp / k));

//        StringBuffer str = new StringBuffer(String.valueOf((int)Math.floor(answer) + "."));
//        answer -= Math.floor(answer);
//        for (int i = 1; i <= 11; i++) {
//            answer *= 10;
//            str.append(String.valueOf((int)Math.floor(answer)));
//            answer -= Math.floor(answer);
//        }
    }

    public static void num3(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] inputs = sc.nextLine().toCharArray();

        StringBuffer[] vals = {new StringBuffer(), new StringBuffer()};
        int turn = 0;

        char val1, val2;
        for (int i = 0; i < inputs.length; i++) {
            char c = inputs[i];
            if (c == '&') {

            } else if (c == '!') {
                turn = 1;
            } else if (c == '=') {
                turn = 1;
            } else {
                vals[turn].append(c);
            }
        }
    }

    public static void num4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] checkPoints = new int[n + 1][2];
        int rowSize = 0, colSize = 0;
        for (int i = 1; i <= n; i++) {
            checkPoints[i][0] = sc.nextInt();
            if (rowSize < checkPoints[i][0] + 1) rowSize = checkPoints[i][0] + 1;
            checkPoints[i][1] = sc.nextInt();
            if (colSize < checkPoints[i][1] + 1) colSize = checkPoints[i][1] + 1;
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();

            ArrayList<Integer>[] row = new ArrayList[rowSize];

            int[] cur = checkPoints[a];
            int[] end = checkPoints[b];
            boolean flag = true;
            boolean boost = true; // 첫번째는 hp 채울필요 X
            while (cur[0] != end[0] && cur[1] != end[1]) {
                // 걸어가는 경우 구하기
                //int walk =
//                if (boost) // 있으면 각 좌표 차이 절대값 구해서 적은 수가 walk
                    // else : 없으면 피타고라스의 함수 정리 이용해서 거리 구하기(최소)
                    // walk가 hp보다 적으면 성공.

                    // 1. 걸어가는 수
                // 2. 날아가는 수
                // 3. 날아 + 걸어가는 수
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
