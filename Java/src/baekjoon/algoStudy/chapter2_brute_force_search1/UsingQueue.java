package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.LinkedList;
import java.util.Scanner;

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
}
