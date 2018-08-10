package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] map;
    public static void main(String[] args) {
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
        for (int c : getCount(new int[]{0, 0}, n))
            System.out.println(c);
    }

    static int[] getCount (int[] s, int n) {
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



