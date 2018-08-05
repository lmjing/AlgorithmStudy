package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] A = new char[n][m];
        boolean[][] check = new boolean[n][m]; // 짝수 : false, 홀수 : true

        // A배열 인풋
        for (int i = 0; i < n; i++)
            A[i] = sc.next().toCharArray();
        // B배열 인풋 받으면서 동시에 A와 비교
        // 동일할 경우 : 짝수번 뒤집힘, 다를 경우 : 홀수번 뒤집힘

        int diff = 0;
        for (int i = 0; i < n; i++) {
            char[] inputs = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (inputs[j] != A[i][j]) {
                    check[i][j] = true;
                    diff++;
                }
            }
        }

        if (diff == 0)
            System.out.println(0);
        else
            System.out.println(getAnswer(check));
    }

    static int getAnswer (boolean[][] check) {
        int n = check.length;
        int m = check[0].length;

        if (n < 3 || m < 3)
            return -1;

        int count = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                // 마지막 3개가 다 다를 경우 불가능하다.
                if (i == n - 3 && !(check[i][j] == check[i + 1][j] && check[i][j] == check[i + 2][j]))
                    return -1;
                if (j == m - 3 && !(check[i][j] == check[i][j + 1] && check[i][j] == check[i][j + 2]))
                    return -1;
                // 가능한 경우 홀수 일때 3x3을 모두 뒤집는다.
                if (check[i][j]) {
                    reverse(check, i, j);
                    count++;
                }
            }
        }
        boolean flag = check[n - 3][m - 3];
        for (int i = n - 1; i > n - 3; i--) {
            for (int j = m - 1; j > n - 3; j--) {
                if (flag != check[i][j]) return -1;
            }
        }
        return count;
    }

    static void reverse (boolean[][] check, int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++)
                check[i][j] = !check[i][j];
        }
    }
}