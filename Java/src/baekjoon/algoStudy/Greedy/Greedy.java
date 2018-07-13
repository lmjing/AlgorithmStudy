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

    public static void num11399() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        Arrays.sort(array);
        int sum = array[0];
        for (int i = 1; i < n; i++) {
            array[i] += array[i - 1];
            sum += array[i];
        }
        System.out.println(sum);
    }

    public static class Num1541 {
        public static void longVersion() {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            Stack<Integer> nums = new Stack<>();
            Stack<Character> operators = new Stack<>();
            int num = 0;
            for (char c : input.toCharArray()) {
                if (c == '-' || c == '+') {
                    operators.push(c);
                    nums.push(num);
                    num = 0;
                } else num = num * 10 + (c - '0');
            }
            nums.push(num);

            int answer = 0;
            while (!operators.isEmpty()) {
                char oper = operators.pop();
                int su = nums.pop();
                if (oper == '-') answer -= su;
                else nums.push(su + nums.pop());
            }
            System.out.println(answer + nums.pop());
        }

        public static void shortVersion() {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            int num = 0;
            int sum = 0;
            int answer = 0;
            boolean flag = true;
            for (char c : input.toCharArray()) {
                int su = c - '0';
                if (su < 0) {
                    sum += num;
                    num = 0;
                    if (c == '-') {
                        if (flag) answer += sum;
                        else answer -= sum;
                        sum = 0;
                        flag = false;
                    }
                } else num = num * 10 + (c - '0');
            }
            sum += num;
            System.out.println(answer + (flag ? sum : -1 * sum));
        }
    }
}
