package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AhoCorasick ac = new AhoCorasick();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++)
            ac.add(sc.next());
        ac.makeFailureLink();

        int count = 0;
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++)
            count += ac.search(sc.next());
        System.out.println(count);
    }

    static class AhoCorasick {
        ArrayList<Node> trie;

        class Node {
            int c;
            boolean vaild;
            int[] children;
            int fl;

            public Node() {
                c = -1;
                vaild = false;
                children = new int[26];
                for (int i = 0; i < 26; i++)
                    children[i] = -1;
                fl = -1;
            }
        }

        public AhoCorasick () {
            trie = new ArrayList<>();
            init();
        }

        private int init () {
            Node next = new Node();
            trie.add(next);
            return trie.size() - 1;
        }

        public void add (String str) {
            add(0, str, 0);
        }

        private void add (int node, String str, int idx) {
            if (str.length() == idx) {
                trie.get(node).vaild = true;
                return;
            }
            int i = str.charAt(idx) - 'a';
            if (trie.get(node).children[i] == -1)
                trie.get(node).children[i] = init();
            int next = trie.get(node).children[i];
            trie.get(next).c = i;
            add(next, str, idx + 1);
        }

        public void makeFailureLink () {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                int p = queue.remove();
                Node current = trie.get(p);
                for (int i = 0; i < 26; i++) {
                    if (current.children[i] != -1) {
                        check(p, current.children[i]);
                        queue.add(current.children[i]);
                    }
                }
            }
        }

        private void check (int p, int q) {
            System.out.println(p + " " + q);
            if (p == 0) {
                trie.get(q).fl = 0;
                System.out.println(q + " failureLink : " + 0);
            } else {
                int pf = trie.get(p).fl;
                int c = trie.get(q).c;
                int fl = trie.get(pf).children[c];

                if (fl != -1) {
                    trie.get(q).fl = fl;
                    System.out.println(q + " failureLink : " + fl);
                }
                else check(pf, q);
            }
        }

        public int search (String str) {
            return search(str, 0, 0 ,0);
        }

        private int search (String str, int idx, int node, int count) {
            int j = node;
            while (trie.get(j).vaild) {
                count++;
                j = trie.get(j).fl;
            }
            if (idx == str.length()) {
                return count;
            }

            int c = str.charAt(idx) - 'a';
            if (trie.get(node).children[c] != -1) {
                return search(str, idx + 1, trie.get(node).children[c], count);
            } else {
                if (node == 0) return search(str, idx + 1, 0, count);
                return search(str, idx, trie.get(node).fl, count);
            }
        }
    }
}