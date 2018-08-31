package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DoubleLinkedList list = new DoubleLinkedList(n);

        // 입력 연산 수행
        for (int i = 0; i < m; i++) {
            list.move(sc.next(), sc.nextInt(), sc.nextInt());
        }

        list.solve();
    }

    public static class DoubleLinkedList {
        Node front;
        Node rear;
        Node[] list;

        class Node {
            int vaule;
            Node before;
            Node next;

            public Node(int v, int b) {
                vaule = v;
                before = list[b];
            }
        }

        public void solve () {
            StringBuilder answer = new StringBuilder();
            int answerCnt = 0;

            // 0 : before, 1 : cnt, 2 : (0 : 방문X, 1 : 방문)
            int[][] check = new int[list.length][3];
            // 앞부터 증가하는 수열 구함
            Node cur = front;
            int max = 0;
            check[0][2] = 1;
            while (cur != null) {
                int i = cur.vaule;
                check[i][2] = 1;
                int b = i - 1;
                if (check[b][2] == 0) {
                    b = max;
                    while (b > i)
                        b = check[b][0];
                }
                check[i][0] = b;
                check[i][1] = check[b][1] + 1;

                if (check[max][1] < check[i][1])
                    max = i;

                cur = cur.next;
            }
            // 최대값 기준으로 거꾸로 추적하며 방문 해제
            while (max > 0) {
                check[max][2] = 0;
                max = check[max][0];
            }
            // 옮겨야 하는 노드들 옮기기
            for (int i = 1; i < check.length; i++) {
                if (check[i][2] == 1) {
                    int target = i - 1; // 우선 왼쪽 (0이 아닌 이상 이미 방문함)
                    if (target == 0) { // 오른쪽 확인
                        target = i + 1;
                        while (check[target][2] == 1) target++;
                    }
                    answerCnt++;
                    answer.append("\n" + (target == i - 1 ? "B " : "A ") + i + " " + target);
                    check[i][2] = 0;
                }
            }
            System.out.print(answerCnt);
            System.out.print(answer);
        }

        public DoubleLinkedList (int n) {
            list = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new Node(i, i - 1);
                if (list[i].before != null) list[i].before.next = list[i];
            }
            front = list[1];
            rear = list[n];
        }

        private void remove (Node cur) {
            if (cur == front) {
                front = cur.next;
                front.before = null;
            } else cur.before.next = cur.next;

            if (cur == rear) {
                rear = cur.before;
                rear.next = null;
            } else cur.next.before = cur.before;

            cur.before = null;
            cur.next = null;
        }

        public void move (String flag, int i, int j) {
            Node node = list[i];
            Node target = list[j];
            remove(node);
            if (flag.equals("A")) {
                if (target != front) {
                    target.before.next = node;
                    node.before = target.before;
                } else front = node;
                target.before = node;
                node.next = target;
            }else {
                if (target != rear) {
                    target.next.before = node;
                    node.next = target.next;
                } else rear = node;
                target.next = node;
                node.before = target;
            }
        }
    }
}