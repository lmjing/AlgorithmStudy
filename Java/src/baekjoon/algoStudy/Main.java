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
            public Node next;

            public Node(int v, int b) {
                vaule = v;
                before = list[b];
            }
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
        public DoubleLinkedList (Node f, Node r) {
            front = f;
            rear = r;
        }

        public void printAll () {
            Node cur = front;
            while (cur != null) {
                System.out.println(cur.vaule);
                cur = cur.next;
            }
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

        public void solve () {
            DoubleLinkedList maxNode = new DoubleLinkedList(list[1], list[1]);

            Node cur = front;
            Node curF = front;
            int cnt = 1;
            int max = 1;
            while (cur.next != null) {
                if (cur.vaule < cur.next.vaule) {
                    cnt++;
                } else {
                    if (cnt > max) {
                        max = cnt;
                        maxNode.front = curF;
                        maxNode.rear = cur;
                    }
                    cnt = 1;
                    curF = cur.next;
                }
                cur = cur.next;
            }

            System.out.print(solve2(maxNode.front, maxNode.rear));
        }

        public StringBuilder solve2 (Node f, Node b) {
            StringBuilder answer = new StringBuilder();
            int count = 0;

            f = f.before;
            // 앞으로 검사
            while (f != null) {
                Node r = f;
                f = f.before;
                if (r.vaule > r.next.vaule) {
                    Node temp = r.next;
                    while (temp != b && temp.next.vaule < r.vaule)
                        temp = temp.next;

                    count++;
                    answer.append("\nB " + r.vaule + " " + temp.vaule);
                    move("B", r.vaule, temp.vaule);
                }
            }

            // 뒤로 검사
            b = b.next;
            while (b != null) {
                Node r = b;
                b = b.next;
                if (r.before.vaule > r.vaule) {
                    Node temp = r.before;
                    while (temp != front && temp.before.vaule > r.vaule)
                        temp = temp.before;

                    count++;
                    answer.append("\nA " + r.vaule + " " + temp.vaule);
                    move("A", r.vaule, temp.vaule);
                }
            }

            System.out.print(count);
            return answer;
        }
    }
}