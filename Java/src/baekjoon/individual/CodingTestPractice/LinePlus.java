package baekjoon.individual.CodingTestPractice;

import java.util.*;

public class LinePlus {
    static int[][] lines; // 입력된 라인 시작 - 끝 좌표
    static int[][] dist; // 친구 관계 수

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        lines = new int[n + 1][2];
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();

            for (int j = 1; j < i; j++) {
                dist[i][j] = dist[j][i] = !(lines[i][1] < lines[j][0] || lines[j][1] < lines[i][0]) ? 1 : n;
            }
        }

        for (int k = 1; k <= n; k++) { // 거쳐가는 정점
            for (int i = 1; i <= n; i++) { // 출발하는 정점
                for (int j = 1; j <= n; j++) { // 도착하는 정점
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            System.out.println(dist[s][e] == n ? -1 : dist[s][e]);
        }
    }
}
