package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];
        boolean[][][] check = new boolean[3][9][10];
        LinkedList<int[]> blank = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                int su = sc.nextInt();
                if (su == 0) {
                    blank.add(new int[]{i, j});
                }else {
                    sudoku[i][j] = su;
                    check[0][i][su] = true;
                    check[1][j][su] = true;
                    check[2][i/3 * 3 + j/3][su] = true;
                }
            }
            sc.nextLine();
        }
        go(blank, check, sudoku);
//        print(sudoku);
    }

    static boolean go(LinkedList<int[]> blank, boolean[][][] check, int[][] sudoku) {
        if (blank.isEmpty()) {
            print(sudoku);
            return true;
        }else {
            int[] c = blank.removeFirst();
            for (int i=1; i<10; i++) {
                if (!check[0][c[0]][i] && !check[1][c[1]][i] && !check[2][c[0]/3 * 3 + c[1]/3][i]) {
                    sudoku[c[0]][c[1]] = i;
                    check[0][c[0]][i] = check[1][c[1]][i] = check[2][c[0]/3 * 3 + c[1]/3][i] = true;
                    if (go(new LinkedList<>(blank), check, sudoku))
                        return true;
                    sudoku[c[0]][c[1]] = 0;
                    check[0][c[0]][i] = check[1][c[1]][i] = check[2][c[0]/3 * 3 + c[1]/3][i] = false;
                    blank.addLast(c);
                }
            }
            return false;
        }
    }

    static void print(int[][] sudoku) {
        for (int i=0; i<9; i++) {
            StringBuffer s = new StringBuffer("");
            for (int j=0; j<9; j++) {
                s.append(sudoku[i][j] + " ");
            }
            System.out.println(s);
        }
    }
}