package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.ArrayList;
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
}
