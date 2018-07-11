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
                return (o1[1] - o1[0]) - (o2[1] - o2[0]);
            }
        });

        LinkedList<int[]> sucess = new LinkedList<>();
        for (int[] newR : reservations) {
            boolean flag = true;
            Iterator iterator = sucess.iterator();

            while (flag && iterator.hasNext()) {
                int[] oldR = (int[]) iterator.next();
                if (!(newR[0] >= oldR[1] || newR[1] <= oldR[0]))
                    flag = false;
            }
            if (flag) sucess.add(newR);
        }

        System.out.println(sucess.size());
    }
}