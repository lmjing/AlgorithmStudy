package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Reservation[] reservations = new Reservation[N];
        for (int i = 0; i < N; i++) {
            reservations[i] = new Reservation(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(reservations);

        boolean[] timeCheck = new boolean[2 ^ 31];
        int answer = 0;

        // 일부러 끝나는 시간은 check하지 않는다.
        for (Reservation r : reservations) {
            boolean able = true;
            for (int i = r.start; i < r.end && able; i++) {
                if (timeCheck[i]) able = false;
            }
            if (able) {
                answer++;
                for (int i = r.start; i < r.end; i++) timeCheck[i] = true;
            }
        }

        System.out.println(answer);
    }

    static class Reservation implements Comparable<Reservation> {
        int start, end;
        int timeLength;

        public Reservation (int s, int e) {
            start = s;
            end = e;
            timeLength = e - s;
        }

        @Override
        public int compareTo(Reservation o) {
            return this.timeLength - o.timeLength;
        }
    }
}