package baekjoon.algoStudy.chapter2_brute_force_search1;

import baekjoon.algoStudy.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UsingQueue {
    public static void num1697() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        LinkedList<Node> queue = new LinkedList<Node>();
        int[] visited = new int[100001];
        queue.addLast(new Node(n, 0));
        while (queue.getFirst().index != k) {
            Node c = queue.removeFirst();

            visited[c.index] = 1;
            if (c.index-1 >= 0 && visited[c.index-1] == 0) {
                queue.addLast(new Node(c.index-1, c.depth+1));
            }
            if (c.index+1 <= 100000 && visited[c.index+1] == 0) {
                queue.addLast(new Node(c.index+1, c.depth+1));
            }
            if (c.index*2 <= 100000 && visited[c.index*2] == 0 && c.index < k) {
                queue.addLast(new Node(c.index*2, c.depth+1));
            }
        }
        System.out.println(queue.getFirst().depth);
    }

    private static class Node {
        int index;
        int depth = 0;

        Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }

    public static void num1963() {
        //1. 일단 네 자리 소수를 다 만든다. (1000 이상) (소수의 여부를 확인하는 배열을 만들 것)
        ArrayList<Integer> four_majority = new ArrayList<Integer>();
        makeMajority(four_majority);

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++) {
            int start = sc.nextInt(); int end = sc.nextInt();

            LinkedList<MajorityPW> queue = new LinkedList<MajorityPW>();
            queue.add(new MajorityPW(start, 0));
            int[] visited = new int[10000];

            while (!queue.isEmpty() && queue.getFirst().password != end) {
                MajorityPW current = queue.removeFirst();
                visited[current.password] = 1;
                for (int majority : four_majority) {
                    if (visited[majority] == 0 && check(majority, current.password)) {
                        queue.addLast(new MajorityPW(majority, current.depth + 1));
                    }
                }
            }
            sc.nextLine();
            System.out.println(queue.isEmpty() ? "Impossible" : queue.getFirst().depth);
        }
    }

    private static boolean check(int majority, int su) {
        int count = 0;
        while (su > 0 && majority > 0) {
            if (su % 10 != majority % 10) count++;
            su /= 10; majority /= 10;
        }
        return count == 1 ? true : false;
    }

    private static class MajorityPW {
        int depth;
        int password;

        MajorityPW(int password, int depth) {
            this.password = password;
            this.depth = depth;
        }
    }

    private static void makeMajority(ArrayList<Integer> four_majority) {
        ArrayList<Integer> majority = new ArrayList<Integer>();
        for (int i=2; i<10000; i++) {
            boolean flag = true;
            for (int ma: majority) {
                if (i % ma == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                majority.add(i);
                if (i >= 1000) four_majority.add(i);
            }
        }
    }

    public static void num9019_timeout1() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++) {
            int[] visited = new int[10000];
            LinkedList<DSLR> queue = new LinkedList<DSLR>();
            queue.addLast(new DSLR(sc.nextInt(), ""));
            int goal = sc.nextInt();
            sc.nextLine();

            while (!queue.isEmpty() && queue.getFirst().value != goal) {
                DSLR current = queue.removeFirst();
                visited[current.value] = 1;
                int d = current.value * 2 % 10000;
                if (visited[d] == 0) queue.addLast(new DSLR(d, current.route + "D"));
                int s = current.value - 1 <= 0 ? 9999 : current.value - 1;
                if (visited[s] == 0) queue.addLast(new DSLR(s, current.route + "S"));
                int l = (current.value % 1000) * 10 + current.value/1000;
                if (visited[l] == 0) queue.addLast(new DSLR(l, current.route + "L"));
                int r = (current.value / 10) + (current.value%10)*1000;
                if (visited[r] == 0) queue.addLast(new DSLR(r, current.route + "R"));
            }
            System.out.println(queue.isEmpty() ? "" : queue.getFirst().route);
        }
    }

    public static void num9019_timeout2() throws IOException {
        // 정답 : http://virusworld.tistory.com/83 과 비교했을 때 다를게 없는데 왜 얘는 시간초과일까
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            Queue<DSLR> queue = new LinkedList<>();
            queue.offer(new DSLR(start, ""));

            System.out.println(result(queue, goal));
        }
        br.close();
    }
    static String result(Queue<DSLR> queue, int goal) {
        int[] visited = new int[10000];
        while (!queue.isEmpty()) {
            DSLR current = queue.poll();
            if (current.value == goal) return current.route;
            visited[current.value] = 1;

            int d = current.value * 2 % 10000;
            if (visited[d] == 0) {
                StringBuilder beforeRoute = new StringBuilder(current.route);
                queue.offer(new DSLR(d, beforeRoute.append("D").toString()));
            }
            int s = current.value - 1 <= 0 ? 9999 : current.value - 1;
            if (visited[s] == 0) {
                StringBuilder beforeRoute = new StringBuilder(current.route);
                queue.offer(new DSLR(s,  beforeRoute.append("S").toString()));
            }
            int l = (current.value % 1000) * 10 + current.value/1000;
            if (visited[l] == 0) {
                StringBuilder beforeRoute = new StringBuilder(current.route);
                queue.offer(new DSLR(l,  beforeRoute.append("L").toString()));
            }
            int r = (current.value / 10) + (current.value%10)*1000;
            if (visited[r] == 0) {
                StringBuilder beforeRoute = new StringBuilder(current.route);
                queue.offer(new DSLR(r,  beforeRoute.append("R").toString()));
            }
        }
        return null;
    }

    static class DSLR {
        int value;
        String route;

        public DSLR(int value, String route) {
            this.value = value;
            this.route = route;
        }
    }

    public static class Num2251 {
        // USE : BFS, QUEUE
        // TODO : a -> b로 온 후, b -> a로 가는 건 똑같은 상황이라 막는다면, 더 빨라질 수 있다고 생각함
        /*
        BEFORE : 방문했던 노드를 a * 100 + b * 10 + c로 했었음 근데 각 자리는 최대 200임
        즉, 이 방법은 중복 인덱스를 불러옴
         */
        // AFTER : (레퍼런스 참고) a, b 값 만으로 c를 알 수 있으므로 a, b를 키로 하는 value를 저장하는 형식으로 진행
        // NOTE : 접근방식은 맞았으나, 인덱스 접근이 틀려서 엄청 오래 걸림.. 그 틀린 이유를 전혀 알지 못했음
        static boolean[][] visited;
        static int[] answers;
        static int N;

        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int[] bottleSize = new int[3];
            for(int i=0; i<3; i++) bottleSize[i] = sc.nextInt();
            N = bottleSize[2];
            answers = new int[N+1];
            visited = new boolean[bottleSize[0]+1][bottleSize[1]+1];
            Queue<Bottles> queue = new LinkedList<>();
            queue.add(new Bottles(0, 0));

            while (!queue.isEmpty()) {
                Bottles now = queue.remove();

                // i->j
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if(i != j && now.bottles[i] > 0 && now.bottles[j] < bottleSize[j]) {
                            int[] newBottles = {now.bottles[0], now.bottles[1], now.bottles[2]};
                            int all = newBottles[i] + newBottles[j];
                            if (all > bottleSize[j]) {
                                newBottles[i] -= bottleSize[j] - newBottles[j];
                                newBottles[j] = bottleSize[j];
                            }else {
                                newBottles[j] = all;
                                newBottles[i] = 0;
                            }

                            int a = newBottles[0];
                            int b = newBottles[1];
                            if (!visited[a][b]) {
                                queue.add(new Bottles(a, b));
                            }
                        }
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            for(int i=0; i<N+1; i++) {
                if(answers[i] > 0) ans.append(i + " ");
            }
            System.out.println(ans);
        }

        static class Bottles {
            int[] bottles = new int[3];
            public Bottles(int a, int b) {
                bottles[0] = a;
                bottles[1] = b;
                int c = N - (a+b);
                bottles[2] = c;
                visited[a][b] = true;
                if(a == 0) answers[c] = 1;
            }
        }
    }

    public static void num1525() {
        //NOTE : 답지 보고 한거나 다름 없음
        Scanner sc = new Scanner(System.in);
        int start = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int input = sc.nextInt();
                if (input == 0) input = 9;
                start = start * 10 + input;
            }
        }

        Puzzle puzzle = new Puzzle();
        puzzle.queue.add(start);
        puzzle.count.put(start, 0);
        puzzle.check_next();
    }

    public static class Puzzle {
        private int[] dx = {0, 0, -1, 1};
        private int[] dy = {-1, 1, 0, 0};

        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Integer> count = new HashMap<>();

        public void check_next() {
            while (!queue.isEmpty()) {
                int nowInt = queue.remove();
                if (nowInt == 123456789) break;
                String now = String.valueOf(nowInt);
                int idx = now.indexOf('9');

                int x = idx/3, y = idx%3;
                for (int i=0; i<4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx <3 && ny >= 0 && ny < 3) {
                        StringBuilder next = new StringBuilder(now);
                        char temp = next.charAt(idx);
                        next.setCharAt(x*3+y, next.charAt(nx*3+ny));
                        next.setCharAt(nx*3+ny, temp);
                        int nextInt = Integer.parseInt(next.toString());
                        if (!count.containsKey(nextInt)) {
                            queue.add(nextInt);
                            count.put(nextInt, count.get(nowInt)+1);
                        }
                    }
                }
            }

            if (count.containsKey(123456789)) {
                System.out.println(count.get(123456789));
            }else {
                System.out.println(-1);
            }
        }
    }


    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] count;
    static int[][] map;

    static int n;
    static int m;
    public static void num1261() {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        count = new int[n][m];
        map = new int[n][m];

        sc.nextLine();
        for (int i=0; i<n; i++) {
            String temp = sc.nextLine();
            for (int j=0; j<m; j++) {
                count[i][j] = -1;
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        Queue<Position> q = new LinkedList<>();
        Queue<Position> nextQueue = new LinkedList<>();
        q.offer(new Position(0, 0));
        count[0][0] = 0;

        while (!q.isEmpty()) {
            Position cur = q.remove();
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (count[ny][nx] == -1) {
                        if (map[ny][nx] == 0) {
                            count[ny][nx] = count[cur.y][cur.x];
                            q.offer(new Position(nx, ny));
                        }else {
                            count[ny][nx] = count[cur.y][cur.x] + 1;
                            nextQueue.offer(new Position(nx, ny));
                        }
                    }
                }
            }

            if (q.isEmpty()) {
                q = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
        System.out.println(count[n-1][m-1]);
    }

    static class Position {
        int x; int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
