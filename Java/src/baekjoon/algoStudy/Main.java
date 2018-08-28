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

        list.printAll();

        // 입력 연산 수행
        for (int i = 0; i < m; i++) {
            list.move(sc.next(), sc.nextInt(), sc.nextInt());
        }

        list.printAll();
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
                node.before = target.before;
                node.next = target;
                target.before.next = node;
                target.before = node;
            }else {
                node.before = target;
                node.next = target.next;
                target.next.before = node;
                target.next = node;
            }
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