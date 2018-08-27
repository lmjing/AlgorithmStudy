package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static int[] fx = { 1, 1, -1, -1};
    static int[] fy = { -1, 1, -1, 1};
    static int[] dx = { 0, 0, -1, -1};
    static int[] dy = { 0, 1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int allCount = 0;
        // 교차점 순회
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                allCount += pointCount(i, j);
            }
        }
        System.out.println(allCount);
    }

    private static int pointCount(int x, int y) {
        int same = 0;
        for (int dir = 0; dir < 2; dir++) {
            ArrayList<Long> left = getRevenue(x + dx[dir], y + dy[dir], dir);
            int rd = 3 - dir;
            ArrayList<Long> right = getRevenue(x + dx[rd], y + dy[rd], rd);

            for (long l : left) {
                for (long r : right) {
                    if (l == r) same++;
                }
            }
        }

        return same;
    }

    private static ArrayList<Long> getRevenue(int x, int y, int dir) {
        long[][] revMap = new long[n + 1][n + 1];
        ArrayList<Long> revenue = new ArrayList<>();
        for (int i = x; fx[dir] > 0 ? i <= n : i > 0; i += fx[dir]) {
            int horSum = 0;
            for (int j = y; fy[dir] > 0 ? j <= n : j > 0; j += fy[dir]) {
                horSum += map[i][j];
                revMap[i][j] = revMap[i - fx[dir]][j] + horSum;
                revenue.add(revMap[i][j]);
            }
        }
        return revenue;
    }
}