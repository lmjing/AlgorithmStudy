package baekjoon.algoStudy.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSBFS {

    // NOTE: n, m 제대로 안봐서 계속 틀렸음
    static boolean[][] ad;
    static int n;
    public static void num1260() {
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
