package baekjoon.algoStudy.DP;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DynamicProgramming {
    static class num1463 {
        // NOTE : 자세한 로직 설명과 통과한 다른 코드들은 블로그에 기술되어 있음
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
