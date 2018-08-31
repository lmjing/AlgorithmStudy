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

        private Node get (int i) {
            Node cur = front;
            while (cur.vaule != i)
                cur = cur.next;
            return cur;
        }

        public void move (String flag, int i, int j) {
            move(flag, get(i), get(j));
        }

        public void move (String flag, Node node, Node target) {
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

//        public StringBuilder solve () {
//            StringBuilder answer = new StringBuilder();
//            int count = 0;
//
//            Node b = findLongArray();
//            Node f = b.before;
//
//            // 앞으로 검사
//            while (f != null) {
//                Node r = f;
//                f = f.before;
//                if (r.vaule > r.next.vaule) {
//                    Node temp = r.next;
//                    while (temp != b && temp.next.vaule < r.vaule)
//                        temp = temp.next;
//
//                    count++;
//                    answer.append("\nB " + r.vaule + " " + temp.vaule);
//                    move("B", r, temp);
//                }
//            }
//
//            // 뒤로 검사
//            b = b.next;
//            while (b != null) {
//                Node r = b;
//                b = b.next;
//                if (r.before.vaule > r.vaule) {
//                    Node temp = r.before;
//                    while (temp != front && temp.before.vaule > r.vaule)
//                        temp = temp.before;
//
//                    count++;
//                    answer.append("\nA " + r.vaule + " " + temp.vaule);
//                    move("A", r, temp);
//                }
//            }
//
//            System.out.print(count);
//            return answer;
//        }

        // 최대로 증가하는 수열 먼저 찾고
        // 그 처음과 끝부터 한칸씩 이동하며 비교 후, 삽입하는 방식.
//        public Node findLongArray () {
//            Node cur = front;
//            int max = 1;
//            Node maxNode = cur;
//            int cnt = 1;
//            while (cur != null) {
//                if (cur.next != null && cur.vaule < cur.next.vaule) {
//                    cnt++;
//                } else {
//                    if (max < cnt) {
//                        max = cnt;
//                        maxNode = cur;
//                    }
//                    cnt = 1;
//                }
//                cur = cur.next;
//            }
//            return maxNode;
//        }

        public void solve () {
            StringBuilder answer = new StringBuilder();

            DoubleLinkedList max = new DoubleLinkedList();

            Node cur = front;
            Node curF = front;
            int cnt = 1;
            while (cur.next != null) {
                if (cur.vaule < cur.next.vaule) {
                    cnt++;
                } else {
                    if (cnt > max.size) {
                        max.size = cnt;
                        max.rear = cur;
                        max.front = curF;
                    }
                    cnt = 1;
                    curF = cur.next;
                }
                cur = cur.next;
            }

            System.out.print(solve2(max.front, max.rear));
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
                    move("B", r, temp);
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
                    move("A", r, temp);
                }
            }

            System.out.print(count);
            return answer;
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