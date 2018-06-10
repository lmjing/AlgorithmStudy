package baekjoon.algoStudy.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    // USE : BFS (갈수있는 3가지 경우, 최소 count 및 경로 출력하는 문제 - 클래스 사용)
    public static void num13913() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visited = new boolean[100001];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, new StringBuilder()));

        if (k < n) {
            System.out.println(n-k);
            StringBuilder s = new StringBuilder();
            s.append(n);
            for (int i=n-1; i>=k; i--) s.append(" "+i);
            System.out.println(s);
            return;
        }
        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            if (visited[cur.x]) continue;
            if (cur.x == k) {
                System.out.println(cur.count);
                System.out.print(cur.s);
                break;
            }
            visited[cur.x] = true;
            if (cur.x-1 > -1 && !visited[cur.x-1]) queue.add(new Point(cur.x-1, cur));
            if (cur.x+1 < 100001 && !visited[cur.x+1]) queue.add(new Point(cur.x+1, cur));
            if (cur.x*2 < 100001 &&!visited[cur.x*2]) queue.add(new Point(cur.x*2, cur));
        }
    }

    static class Point {
        int x;
        StringBuilder s;
        int count;

        public Point(int x, Point before) {
            this.x = x;
            StringBuilder s = new StringBuilder(before.s);
            this.s = s.append(" " + x);
            this.count = before.count + 1;
        }

        public Point(int x, StringBuilder s) {
            this.x = x;
            this.s = s.append(x);
            this.count = 0;
        }
    }

    static class num1463 {
        // NOTE : 자세한 로직 설명과 통과한 다른 코드들은 블로그에 기술되어 있음
        // USE : BFS
        static Scanner sc;
        static boolean[] array;
        public static void main (String[] args) {
            sc = new Scanner(System.in);
            int n = sc.nextInt();

            Queue<Node> queue = new LinkedList<>();
            array = new boolean[n+1];
            queue.add(new Node(n, 0));

            while (!queue.isEmpty()) {
                Node node = queue.remove();
                int num = node.num;
                if (num == 1) {
                    System.out.println(node.count);
                    break;
                }
                if (num > 1 && !array[num]) {
                    array[num] = true;
                    int count = node.count + 1;
                    if (num % 3 == 0) queue.add(new Node(num / 3, count));
                    if (num % 2 == 0) queue.add(new Node(num / 2, count));
                    queue.add(new Node(num - 1, count));
                }
            }
        }

        static class Node {
            int num;
            int count;

            public Node (int num, int count) {
                this.num = num;
                this.count = count;
            }
        }
    }
}
