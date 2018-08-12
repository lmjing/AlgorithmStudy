package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean[][][] check = new boolean[3][9][9];
    static LinkedList<Point> emptyPoints = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int su = sc.nextInt();
                sudoku[i][j] = su;
                if (su > 0) {
                    check(i, j, su - 1);
                } else emptyPoints.add(new Point(i, j));
            }
        }
        solve();
    }

    static void check (int x, int y, int v) {
        sudoku[x][y] = v + 1;
        check[0][x][v] = true;
        check[1][y][v] = true;
        check[2][(x / 3) * 3 + (y / 3)][v] = true;
    }

    static void reset (int x, int y, int v) {
        sudoku[x][y] = 0;
        check[0][x][v] = false;
        check[1][y][v] = false;
        check[2][(x / 3) * 3 + (y / 3)][v] = false;
    }

    static void solve () {
        if (emptyPoints.isEmpty()) {
            print();
            flag = true;
            return;
        }
        Point p = emptyPoints.remove();
        int temp = (p.x / 3) * 3 + (p.y / 3);
        boolean result = true;
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (!check[0][p.x][i] && !check[1][p.y][i] && !check[2][temp][i]) {
                check(p.x, p.y, i);
                solve();
                if (flag) return;
                reset(p.x, p.y, i);
            }
        }
        emptyPoints.add(p);
    }

    static void print() {
        for (int i = 0; i < 9; i++) {
            StringBuilder str = new StringBuilder(String.valueOf(sudoku[i][0]));
            for (int j = 1; j < 9; j++)
                str.append(" " + sudoku[i][j]);
            System.out.println(str);
        }
    }

    static class Point {
        int x, y;
        boolean check;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
            check = false;
        }
    }
}