package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        boolean[][][] check = new boolean[3][9][9];
        Queue<Point> emptyPoints = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int su = sc.nextInt();
                sudoku[i][j] = su;
                if (su > 0) {
                    su--;
                    check[0][i][su] = true;
                    check[1][j][su] = true;
                    check[2][(i / 3) * 3 + (j / 3)][su] = true;
                } else emptyPoints.add(new Point(i, j));
            }
        }

        while (!emptyPoints.isEmpty()) {
            Point p = emptyPoints.remove();
            int temp = (p.x / 3) * 3 + (p.y / 3);
            for (int i = 0; i < 9; i++) {
                if (!check[0][p.x][i] && !check[1][p.y][i] && !check[2][temp][i])
                    sudoku[p.x][p.y] = i + 1;
            }
        }

        for (int i = 0; i < 9; i++) {
            StringBuilder str = new StringBuilder(String.valueOf(sudoku[i][0]));
            for (int j = 1; j < 9; j++)
                str.append(" " + sudoku[i][j]);
            System.out.println(str);
        }
    }

    static class Point {
        int x, y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}