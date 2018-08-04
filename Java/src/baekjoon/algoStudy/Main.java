package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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
            while (cur[0] != end[0] && cur[1] != end[1]) {
                // 1. 걸어가는 수
                cur[
                // 2. 날아가는 수
                // 3. 날아 + 걸어가는 수
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}