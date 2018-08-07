package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node[] array = new Node[n];
        for (int i = 0; i < n ; i++)
            array[i] = new Node(i, sc.nextInt());
        Arrays.sort(array);

        int[] count = new int[n];
        count[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (array[i].vaule == array[i - 1].vaule)
                count[i] = count[i - 1];
            else {
                count[i] = count[i - 1] + 1;
                max = max < count[i] ? count[i] : max;
            }
        }
        System.out.println(max);
    }

    static class Node implements Comparable<Node> {
        int idx;
        int vaule;

        public Node (int i, int v) {
            idx = i;
            vaule = v;
        }

        @Override
        public int compareTo(Node o) {
            if (this.vaule == o.vaule) {
                return this.idx - o.idx;
            }else return this.vaule - o.vaule;
        }
    }
}