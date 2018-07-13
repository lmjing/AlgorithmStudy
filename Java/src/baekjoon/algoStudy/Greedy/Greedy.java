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

            Stack<Integer> nums = new Stack<>(); // 숫자를 넣어둘 스택
            Stack<Character> operators = new Stack<>(); // 연산자 넣어둘 스택
            int num = 0;
            for (char c : input.toCharArray()) {
                if (c == '-' || c == '+') {
                    operators.push(c);
                    nums.push(num);
                    num = 0; // 새로운 숫자를 받기 위해서
                } else num = num * 10 + (c - '0');
            }
            nums.push(num);

            int answer = 0;
            /*
            입력 값 기준으로 뒤에서 부터 차례대로 처리하게 된다.
            + 는 일단 더해서 넣고 - 는 뒤에서 부터 다 더해진 값을 그냥 꺼내 최종 값에 빼준다.
             */
            while (!operators.isEmpty()) { // 연산자 기준으로 처리
                char oper = operators.pop();
                int su = nums.pop(); // 우선 숫자 하나는 무조건 활용하니 꺼내 놓는다.
                if (oper == '-') answer -= su;
                else nums.push(su + nums.pop());
            }
            System.out.println(answer + nums.pop()); // 숫자가 하나 더 많고 해당 값은 항상 양수이므로 더해준다.
        }

        public static void shortVersion() {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            int num = 0; // 입력 숫자 구분용
            int sum = 0; // +연산을 위한 변수(괄호 안 숫자 합산용)
            int answer = 0; // 최종 정답
            /*
             해당 flag는 - 부호가 나와서 앞서 계산된 값을 저장할 때,
             해당 값의 부호를 나타내는 기호이다.
             첫번째 값은 무조건 양수이므로 +인 true이고,
             이후 한번이라도 -가 나온 경우 false를 유지한다.
             중간에 나오는 +연산은 -를 위해 더 해주기만 할 뿐이므로 true로 바꾸지 않는다.
              */
            boolean flag = true; // +일 경우 true, -일 경우 false
            for (char c : input.toCharArray()) {
                int su = c - '0';
                if (su < 0) {
                    sum += num; // 부호가 나오면 일단 sum에 더해준다. (-는 앞의 값에 영향을 주지 않음)
                    num = 0; // 부호가 나왔으므로 새로운 숫자를 위해 초기화
                    if (c == '-') {
                        // -가 나오면 flag에 따라 최종 값에 더해준다.
                        if (flag) answer += sum; // 음수
                        else answer -= sum; // 양수
                        sum = 0; // 괄호가 시작되었으므로 초기화 한다.
                        flag = false;
                    }
                } else num = num * 10 + (c - '0');
            }
            sum += num; // 마지막 숫자 괄호 안 합산
            System.out.println(answer + (flag ? sum : -1 * sum)); // 부호에 따라 마지막 값 처리
        }
    }

    static class Num2875 {
        public static void greedy() {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int team = 0;
            while (n >= 2 && m >= 1 && n + m >= 3 + k) {
                n -= 2;
                m--;
                team++;
            }
            System.out.println(team);
        }

        public static void onlyOperator() {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int team = 0;
            if (n + m > k) { // 애초에 빼야할 수가 더 많으면 계산하지 않는다.
                // 2 : 1 비율로 작은 값이 k를 제외하지 않은 상태에서의 팀의 수를 구한다.
                team = n / 2 < m ? n / 2 : m;
                k -= (n + m) - team * 3; // 빼야하는 수에서 팀이 되지 않은 인원을 뺀다.
                // 그래도 더 빼야하는 경우
                // 빼야하는 사람들을 3명이 한 팀이 되도록 묶어 전체 팀원 수에서 제외한다.
                if (k > 0) team -= (k + 2) / 3;
            }
            System.out.println(team);
        }
    }
}
