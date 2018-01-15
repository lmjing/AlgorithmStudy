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

    public static void num2251_fail() {
        Scanner sc = new Scanner(System.in);
        int[] volume = new int[3];
        for (int i=0; i<3; i++) volume[i] = sc.nextInt();
        Set<Integer> answer = new HashSet<>();

        int[][] another = {{1, 2}, {0, 2}, {0, 1}};
        boolean[][] visited = new boolean[volume[0]+1][volume[2]+1];

        Queue<Bottle> queue = new LinkedList<>();
        queue.offer(new Bottle(new int[]{0, 0, volume[2]}, -1, -1));

        while (!queue.isEmpty()) {
            Bottle current = queue.poll();
            if (current.water[0] == 0 && !visited[current.water[0]][current.water[2]]) {
                answer.add(current.water[2]);
            }
            visited[current.water[0]][current.water[2]] = true;

            for (int s=0; s<3; s++) {
                if (current.water[s] > 0) {
                    for (int e : another[s]) {
                        if (current.water[e] < volume[e] && !(current.to == s && e ==current.from)) {
                            // 공간이 있으면서 직전 노드가 아닌 경우 일단 계산한다.
                            int[] newWater = new int[3];
                            if (current.water[s] > volume[e] - current.water[e]) {
                                // 옮겨야 할 양이 더 많은 경우
                                newWater[s] = current.water[s] - (volume[e] - current.water[e]);
                                newWater[e] = volume[e];
                            }else {
                                newWater[e] = current.water[e] + current.water[s];
                                newWater[s] = 0;
                            }
                            newWater[3-s-e] = current.water[3-s-e];
                            if (!visited[newWater[0]][newWater[2]]) {
                                queue.offer(new Bottle(newWater, s, e));
                            }
                        }
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder("");
        for (int a:answer) {
            result.append(a);
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        System.out.print(result);
    }

    static class Bottle {
        int[] water = new int[3];
        int from;
        int to;

        public Bottle(int[] water, int from, int to) {
            this.water = water;
            this.from = from;
            this.to = to;
        }
    }
}
