package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static boolean[][][] check = new boolean[9][9][9];
    static LinkedList<Point> emptyPoints = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int su = sc.nextInt();
                sudoku[i][j] = su;
                if (su > 0)
                    check[i][j][su - 1] = true;
                else emptyPoints.add(new Point(i, j));
            }
        }
        solve();
    }

    static boolean solve () {
        if (emptyPoints.isEmpty()) {
            print();
            return true;
        }
        Point p = emptyPoints.remove();
        for (int i = 0; i < 9; i++) {
            if (!check[p.x][p.y][i]) {
                check[p.x][p.y][i] = true;
                sudoku[p.x][p.y] = i + 1;
                if (solve()) return true;
                check[p.x][p.y][i] = false;
                sudoku[p.x][p.y] = 0;
            }
        }
        emptyPoints.add(p);
        return false;
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