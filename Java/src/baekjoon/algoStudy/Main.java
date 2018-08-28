package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DoubleLinkedList list = new DoubleLinkedList();

        for (int i = 1; i <= n; i++)
            list.addLast(i);

        list.printAllBack();
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