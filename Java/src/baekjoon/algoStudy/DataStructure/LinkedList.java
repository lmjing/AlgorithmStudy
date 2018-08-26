package baekjoon.algoStudy.DataStructure;

import java.util.*;

public class LinkedList {
    public class Num1158 {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();

            CircleLinkedList list = new CircleLinkedList();
            for (int i = 1; i <= n; i++)
                list.add(i);

            System.out.println(list.answer(m));
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

            public StringBuilder answer (int m) {
                Node cur = front;
                StringBuilder str = new StringBuilder("<");
                while (size > 0) {
                    cur = removeAt(cur, m);
                    str.append(cur.vaule + ", ");
                    cur = cur.next;
                }
                str.delete(str.length() - 2, str.length());
                return str.append(">");
            }

            public Node removeAt (Node node, int i) {
                if (size == 0) return null;

                Node before = node;
                while (--i > 0) {
                    before = node;
                    node = node.next;
                }
                return remove(before, node);
            }

            public Node remove (Node before, Node node) {
                if (size > 1) before.next = node.next;
                size--;
                return node;
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
}
