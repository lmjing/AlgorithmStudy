package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Reservation[] reservations = new Reservation[N];
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            reservations[i] = new Reservation(sc.nextInt(), sc.nextInt());
            maxTime = maxTime < reservations[i].end ? reservations[i].end : maxTime;
        }
        Arrays.sort(reservations);

        LinkedList<Reservation> sucess = new LinkedList<>();
        for (Reservation newR : reservations) {
            boolean flag = true;
            Iterator iterator = sucess.iterator();

            while (flag && iterator.hasNext()) {
                Reservation oldR = (Reservation) iterator.next();
                if (!(newR.start >= oldR.end || newR.end <= oldR.start))
                    flag = false;
            }
            if (flag) sucess.add(newR);
        }

        System.out.println(sucess.size());
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