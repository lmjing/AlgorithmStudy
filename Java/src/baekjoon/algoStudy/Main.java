package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] reservations = new int[N][2];

        for (int i = 0; i < N; i++) {
            reservations[i][0] = sc.nextInt();
            reservations[i][1] = sc.nextInt();
        }
        Arrays.sort(reservations, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) return -1; // 빨리 끝나는 시간 기준
                else if (o1[1] == o2[1]){ // 같이 끝남
                    // 늦게 시작하는 순
                    return o2[0] - o1[0];
                } else return 1; // 더 늦게 끝남
            }
        });

        int result = 0;
        int last = -1;
        for (int[] newR : reservations) {
            if (last <= newR[0]) {
                result++;
                last = newR[1];
            }
        }
        System.out.println(result);
    }
}