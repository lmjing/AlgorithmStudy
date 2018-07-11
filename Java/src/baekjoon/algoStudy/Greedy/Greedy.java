package baekjoon.algoStudy.Greedy;

import java.util.*;

public class Greedy {
    public static class Num1931 {
        // USE : Interval Scheduling
        // NOTE : 메모리 관리가 핵심
        // BEFORE : 2차원 배열 사용 -> 메모리 초과 된 듯
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            Reservation[] reservations = new Reservation[N];

            for (int i = 0; i < N; i++) {
                reservations[i] = new Reservation(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(reservations);

            int result = 0;
            int last = -1;
            for (Reservation r : reservations) {
                if (last <= r.start) {
                    result++;
                    last = r.end;
                }
            }
            System.out.println(result);
        }

        static class Reservation implements Comparable<Reservation> {
            int start, end;

            public Reservation(int s, int e) {
                start = s;
                end = e;
            }

            @Override
            public int compareTo(Reservation o) {
                if (this.end < o.end) return -1;
                else if (this.end == o.end) {
                    if (this.start < o.start) return -1;
                    else if (this.start == o.start) return 0;
                    else return 1;
                } else return 1;
            }
        }
    }
}
