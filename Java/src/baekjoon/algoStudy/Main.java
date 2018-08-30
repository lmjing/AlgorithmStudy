package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DoubleLinkedList list = new DoubleLinkedList();

        // 이중 연결리스트 초기화
        for (int i = 1; i <= n; i++)
            list.addLast(i);

        // 입력 연산 수행
        for (int i = 0; i < m; i++) {
            list.move(sc.next(), sc.nextInt(), sc.nextInt());
        }
        list.printAll();

        list.solve();
    }

    public static class DoubleLinkedList {
        Node front;
        Node rear;
        int size;

        public DoubleLinkedList () {
            front = null;
            rear = null;
        }

        public void addLast (int v) {
            Node newNode = new Node(v, rear);
            if (size == 0) {
                rear = newNode;
                front = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        private Node remove (int i) {
            Node cur = get(i);
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

            return cur;
        }

        private Node get (int i) {
            Node cur = front;
            while (cur.vaule != i)
                cur = cur.next;
            return cur;
        }

        public void move (String flag, int i, int j) {
            Node node = remove(i);
            Node target = get(j);
            if (flag.equals("A")) {
                if (target != front) {
                    target.before.next = node;
                    node.before = target.before;
                }
                target.before = node;
                node.next = target;
            }else {
                if (target != rear) {
                    target.next.before = node;
                    node.next = target.next;
                }
                target.next = node;
                node.before = target;

            }
        }

        public void solve () {
            Node b = findLongArray();
            Node f = b.before;

            // 앞으로 검사
            while (f != null) {
                if (f.vaule > f.next.vaule) {
                    Node temp = b;
                    while (temp.vaule > f.vaule)
                        temp = temp.before;

                    int x = f.vaule;
                    f = f.before;
                    System.out.println("B " + x + " " + temp.vaule);
                    move("B", x, temp.vaule);
                } else
                    f = f.before;
            }

            // 뒤로 검사
            b = b.next;
            while (b != null) {
                if (b.before.vaule > b.vaule) {
                    Node temp = f;
                    while (temp.vaule < b.vaule)
                        temp = temp.next;

                    int x = b.vaule;
                    b = b.next;
                    System.out.println("A " + x + " " + temp.vaule);
                    move("A", x, temp.vaule);
                } else
                    b = b.next;
            }
        }

        // 최대로 증가하는 수열 먼저 찾고
        // 그 처음과 끝부터 한칸씩 이동하며 비교 후, 삽입하는 방식.
        public Node findLongArray () {
            Node cur = front;
            int max = 1;
            Node maxNode = cur;
            int cnt = 1;
            while (cur != null) {
                if (cur.next != null && cur.vaule < cur.next.vaule) {
                    cnt++;
                } else {
                    if (max < cnt) {
                        max = cnt;
                        maxNode = cur;
                    }
                    cnt = 1;
                }
                cur = cur.next;
            }
            return maxNode;
        }

        public void printAll () {
            Node cur = front;
            while (cur != null) {
                System.out.println(cur.vaule);
                cur = cur.next;
            }
        }

        public void printAllBack () {
            Node cur = rear;
            while (cur != null) {
                System.out.println(cur.vaule);
                cur = cur.before;
            }
        }

        class Node {
            int vaule;
            Node before;
            public Node next;

            public Node (int v, Node b) {
                vaule = v;
                before = b;
                next = null;
            }
        }
    }
}