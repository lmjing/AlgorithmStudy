package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] check = new boolean[n][n];
        int[][] count = new int[2][n]; // 0 : 행, 1: 열

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j ++) {
                if (input.charAt(j) == 'T') {
                    check[i][j] = true;
                    count[0][i]++;
                    count[1][j]++;
                }
            }
        }

        boolean invidualFlag = true;
        int allCnt = 0;
        do {
            allCnt = 0;
            int[] maxPoint = new int[]{0, -1, -1}; // 0 : vaule, 1 : row(0),col(1), 2 : idx
            //max찾기.
            for (int i = 0; i < n; i++) {
                allCnt += count[0][i] + count[1][i];
                if (count[0][i] > n / 2 || count[1][i] > n / 2) invidualFlag = false;
                if (maxPoint[0] < count[0][i]) {
                    maxPoint[0] = count[0][i];
                    maxPoint[1] = 0;
                    maxPoint[2] = i;
                }
                if (maxPoint[0] < count[1][i]) {
                    maxPoint[0] = count[1][i];
                    maxPoint[1] = 1;
                    maxPoint[2] = i;
                }
                //뒤집기
                count[maxPoint[1]][maxPoint[2]] = n - count[maxPoint[1]][maxPoint[2]];
                for (int j = 0; j < n; j++) {
                    int rev = Math.abs(maxPoint[1] - 1);
                    if (check[maxPoint[2]][j]) count[rev][j]--;
                    else count[rev][j]++;
                    check[maxPoint[2]][j] = !check[maxPoint[2]][j];
                }
                    count[Math.abs(maxPoint[1] - 1)][j];
            }
        } while (!(invidualFlag && allCnt <= n));
    }

    static class CheckPoint implements Comparable<CheckPoint>{
        int rc = -1; // 0 : row, c : col
        int idx = -1;
        int vaule;

        public CheckPoint (int rc, int idx, int v) {
            this.rc = rc;
            this.idx = idx;
            vaule = v;
        }

        @Override
        public int compareTo(CheckPoint o) {
            return this.vaule - o.vaule;
        }
    }
}