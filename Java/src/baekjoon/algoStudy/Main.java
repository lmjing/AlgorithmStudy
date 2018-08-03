package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] answer = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
//        System.out.println(answer[0] + " " + answer[1]);

        int[] answer2 = solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println(answer2[0] + " " + answer2[1]);
    }

    static class Solution {
        class Position {
            int x, y;
            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean [][] check;

        public int[] solution(int m, int n, int[][] picture) {
            check = new boolean[m][n];

            Queue<Position> queue = new LinkedList<>();
            queue.add(new Position(0, 0));

            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            while (!queue.isEmpty()) {
                Position p = queue.remove();
                if (check[p.x][p.y]) continue;

                int v = picture[p.x][p.y];
                int count = 0;

                System.out.println("=============");
                System.out.println(p.x + " " + p.y + " " + v);

                Queue<Position> temp = new LinkedList<>();
                temp.add(p);

                while (!temp.isEmpty()) {
                    Position cur = temp.remove();
                    if (check[cur.x][cur.y]) continue;

                    check[cur.x][cur.y] = true;
                    count++;
                    System.out.println("------------------");
                    System.out.println(cur.x + " " + cur.y + " " + count);
                    for (int i = 0; i < 2; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !check[nx][ny]) {
                            if (picture[nx][ny] != v) queue.add(new Position(nx, ny));
                            else {
                                temp.add(new Position(nx, ny));
                                System.out.println(nx + " " + ny);
                            }
                        }
                    }
                }

                if (v > 0) {
                    if (maxSizeOfOneArea < count) maxSizeOfOneArea = count;
                    numberOfArea++;
                    System.out.println(numberOfArea + " " + count);
                }
            }

            return new int[] {numberOfArea, maxSizeOfOneArea};
        }
    }
}

