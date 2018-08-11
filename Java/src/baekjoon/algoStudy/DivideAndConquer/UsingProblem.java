package baekjoon.algoStudy.DivideAndConquer;

import java.util.*;

public class UsingProblem {
    public class Num1780 {
        int[][] map;
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int input = sc.nextInt();
                    if (input == -1) input = 2;
                    map[i][j] = input;
                }
            }
            int[] result = getCount(new int[]{0, 0}, n);
            System.out.println(result[2]);
            System.out.println(result[0]);
            System.out.println(result[1]);
        }

        int[] getCount (int[] s, int n) {
            int[] count = new int[3];
            if (n == 1) {
                count[map[s[0]][s[1]]]++;
                return count;
            }
            int last = 3;
            for (int i = s[0]; i < s[0] + n; i += n / 3) {

                for (int j = s[1]; j < s[1] + n; j += n / 3) {
                    int[] result = getCount(new int[]{i, j}, n / 3);
                    for (int k = 0; k < 3; k++) {
                        if (result[k] > 0) last = k;
                        count[k] += result[k];
                    }
                }
            }
            if (count[last] == 9)
                count[last] = 1;
            return count;
        }
    }

    public static class Num11729 {
        static int count = 0;
        static StringBuilder result = new StringBuilder();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            solve(n, 1, 3);
            System.out.println(count);
            System.out.print(result);
        }

        private static void solve(int n, int x, int y) {
            if (n == 0) return;
            int z = 6 - (x + y);
            solve(n - 1, x, z);
            count++;
            result.append(x + " " + y + "\n");
            solve(n - 1, z, y);
        }
    }
}
