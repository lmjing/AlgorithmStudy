package baekjoon.individual.CodingTestPractice;

import java.util.*;

public class LinePlus {
    static int[][] lines; // 입력된 라인 시작 - 끝 좌표
    static int[][] friends;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        lines = new int[n + 1][2];
        friends = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            lines[i][0] = sc.nextInt();
            lines[i][1] = sc.nextInt();

            for (int j = 1; j < i; j++) {
                if (!(lines[i][1] < lines[j][0] || lines[j][1] < lines[i][0])) {
                    friends[i][j] = friends[j][i] = 1;
                }
            }
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            boolean[] visited = new boolean[n + 1];
            visited[0] = visited[s] = true;
            System.out.println(getFriends(s, e, visited, 0));
        }
    }

    static int getFriends (int s, int e, boolean[] visited, int vCnt) {
        if (friends[s][e] != 0) {
            return friends[s][e] + (friends[s][e] == -1 ? 0 : vCnt);
        }

        int min = visited.length;
        for (int i = 1; i < friends.length; i++) {
            if (!visited[i] && friends[s][i] == 1) {
                visited[i] = true;
                int fCnt = getFriends(i, e, visited, vCnt + 1);
                if (min > fCnt && fCnt != -1) min = fCnt;
                visited[i] = false;
            }
        }

        if (vCnt == 0)
            friends[s][e] = friends[e][s] = min;
        if (min == visited.length) { // 연결 고리 없는 경우
            min = -1;
        }

        return min;
    }

//    int getFriends (int s, int e, boolean[] visited) {
//        if (s == e) return 0;
//        //if () // 다 방문했으면 리턴 -1
//        if (friends[s][e] > 0) return friends[s][e];
//
//        int min = friends.length;
//        int sx = lines[s][0], sy = lines[s][1];
//        for (int i = 1; i <= friends.length; i++) {
//            if (i == s) continue; // 자신은 건너 뜀
//
//            if ((lines[i][0] >= sx && lines[i][0] <= sy) || (lines[i][1] >= sx && lines[i][1] <= sy)) {
//                friends[s][i] = friends[i][s] = 1;
//                visited[i] = true;
////                int f = 1 + getFriends(i, e, )
//            }
//        }
//
//    }
}
