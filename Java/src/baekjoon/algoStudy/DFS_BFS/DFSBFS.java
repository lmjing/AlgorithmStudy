package baekjoon.algoStudy.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DFSBFS {

    static class Num1260 {
        // NOTE: n, m 제대로 안봐서 계속 틀렸음
        static boolean[][] ad;
        static int n;

        public static void main() {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            int m = sc.nextInt();
            int v = sc.nextInt();
            sc.nextLine();
            ad = new boolean[n+1][n+1];
            for (int i=0; i<m; i++) {
                int a1 = sc.nextInt(); int a2 = sc.nextInt();
                ad[a1][a2] = true;
                ad[a2][a1] = true;
                sc.nextLine();
            }
            dfs(v, new boolean[n+1]);
            System.out.println();
            bfs(v, new boolean[n+1]);
        }

        private static void dfs(int v, boolean[] visited) {
            System.out.print(v + " ");
            visited[v] = true;
            for (int i=1; i<n+1; i++) {
                if (ad[v][i] && !visited[i]) {
                    dfs(i, visited);
                }
            }
        }

        private static void bfs(int v, boolean[] visited) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);
            visited[v] = true;
            StringBuilder s = new StringBuilder(String.valueOf(v));

            while (!queue.isEmpty()) {
                v = queue.remove();
                for (int i=1; i<n+1; i++) {
                    if (ad[v][i] && !visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                        s.append(" " + i);
                    }
                }
            }
            System.out.println(s);
        }
    }

    static class Num14502 {
        /*
        NOTE : n,m의 범위가 작아서 이중포문으로 계속 확인 가능
        그래서 3개의 벽 만들 수 있는 만큼 다 만들어서 바이러스 퍼트리고 일일이 수 확인 하는 방법 사용
         */
        // BEFORE: virusMap = tempMap; 으로 해서 바이러스 퍼트릴때 tempMap도 바껴서 다 못도는 현상 발생

        static int n, m;
        static int[][] map, tempMap, virusMap;
        static final int WallCount = 3;
        static int max = 0;

        static int[] dx = {0, 0, -1, 1};
        static int[] dy = {-1, 1, 0, 0};

        public static void main() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            tempMap = new int[n][m];
            virusMap = new int[n][m];
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<m; j++) {
                    map[i][j] = tempMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<n*m; i++) {
                if (map[i/m][i%m] == 0) {
                    tempMap[i/m][i%m] = 1;
                    createWalls(i, 1);
                    tempMap[i/m][i%m] = 0;
                }
            }
            System.out.println(max);
        }
        private static void createWalls(int i, int wallCount) {
            if (wallCount == 3) {
                // 바이러스 퍼트린다.
                for (int ii=0; ii<n; ii++) {
                    for (int jj=0; jj<m; jj++) {
                        virusMap[ii][jj] = tempMap[ii][jj];
                    }
                }
                for (int ii=0; ii<n; ii++) {
                    for (int jj=0; jj<m; jj++) {
                        if (tempMap[ii][jj] == 2) {
                            spreadVirus(ii, jj);
                        }
                    }
                }

                // 안전영역 최대 값 구한다.
                int count = safeAreaCount();
                max = max < count ? count : max;

                return;
            }
            for (int j=i+1; j<m*n; j++) {
                if (tempMap[j/m][j%m] == 0) {
                    tempMap[j/m][j%m] = 1;
                    createWalls(j, wallCount+1);
                    tempMap[j/m][j%m] = 0;
                }
            }
        }

        private static void spreadVirus(int y, int x) {
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >=0 && ny < n) {
                    if (virusMap[ny][nx] == 0) {
                        virusMap[ny][nx] = 2;
                        spreadVirus(ny, nx);
                    }
                }
            }
        }

        private static int safeAreaCount() {
            int count = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (virusMap[i][j] == 0) count++;
                }
            }
            return count;
        }
    }
}
