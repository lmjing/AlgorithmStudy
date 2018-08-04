package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(answer[0] + " " + answer[1]);

        int[] answer2 = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println(answer2[0] + " " + answer2[1]);
    }

    static class Solution {
        int m, n;
        int[][] picture;
        boolean[][] visit;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int checkArea(int x, int y) {
            int result = 1;
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                System.out.println(nx + " " + ny);
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && picture[x][y] == picture[nx][nx])
                    result += checkArea(nx, ny);
            }
            return result;
        }

        public int[] solution(int m, int n, int[][] picture) {
            this.m = m;
            this.n = n;
            this.picture = picture;
            visit = new boolean[m][n];

            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] == 0 || visit[i][j]) continue;

                    int count = checkArea(i, j);
                    if (maxSizeOfOneArea < count) maxSizeOfOneArea = count;
                    numberOfArea++;
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
    }
}