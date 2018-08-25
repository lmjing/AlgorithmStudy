package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();
         int m = sc.nextInt();

        CircleLinkedList list = new CircleLinkedList();
        for (int i = 1; i <= n; i++)
            list.add(i);

        list.printAll();
    }

    static class CircleLinkedList {
        Node front;
        Node rear;
        int size;

        public CircleLinkedList () {
            front = null;
            rear = null;
            size = 0;
        }

        public void add (int v) {
            if (size == 0) {
                rear = new Node(v);
                rear.next = rear;
                front = rear;
            } else {
                rear.next = new Node(v);
                rear = rear.next;
            }
            size++;
        }

        public void printAll () {
            Node cur = front;
            while (cur.next != front) {
                System.out.println(cur.vaule + " ");
                cur = cur.next;
            }
            System.out.println(cur.vaule);
        }

        public int removeAt (Node node, int i) {
            if (size == 0) return -1;

            Node before = node;
            while (--i > 0) {
                before = node;
                node = node.next;
            }
            return remove(before, node);
        }

        public int remove (Node before, Node node) {
            size--;
            int v = node.vaule;
            if (size > 0) before.next = node.next;
            node = null;
            return v;
        }

        class Node {
            int vaule;
            Node next;

            public Node (int v) {
                vaule = v;
                next = front;
            }
        }
    }


}