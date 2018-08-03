package baekjoon.algoStudy;

import javafx.geometry.Pos;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    class Solution {
        class Position {
            int x, y;
            int flag;
            public Position(int x, int y, int flag) {
                this.x = x;
                this.y = y;
                this.flag = flag;
                check[x][y] = true;
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        boolean [][] check;

        public int[] solution(int m, int n, int[][] picture) {
            check = new boolean[m][n];

            Map<Integer, Integer> counts = new HashMap<>();
            Queue<Position> queue = new LinkedList<>();

            // 1부터 시작.
            int flag = picture[0][0] > 0 ? 1 : 0;
            queue.add(new Position(0, 0, flag));

            while (!queue.isEmpty()) {
                Position p = queue.remove();
                int v = picture[p.x][p.y];
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >= 0 && nx < m && ny < n && ny >= 0 && !check[nx][ny]) {

                    }
                }
            }

            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
    }
}

