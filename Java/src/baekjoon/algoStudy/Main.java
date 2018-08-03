package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AhoCorasick ac = new AhoCorasick();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++)
            ac.add(sc.next());
        ac.makeFailureLinks();

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++)
            System.out.println(ac.search(sc.next()) ? "YES" : "NO");
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

        public void makeFailureLinks () {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                int p = queue.remove();
                Node current = trie.get(p);
                for (int i = 0; i < 26; i++) {
                    if (current.children[i] != -1) {
                        makeFailureLink(p, current.children[i]);
                        queue.add(current.children[i]);
                    }
                }
            }
        }

        private void makeFailureLink (int p, int q) {
            if (p == 0) trie.get(q).fl = 0;
            else {
                int pf = trie.get(p).fl;
                int c = trie.get(q).c;
                int fl = trie.get(pf).children[c];

                if (fl != -1) trie.get(q).fl = fl;
                else makeFailureLink(pf, q);
            }
        }

        public boolean search (String str) {
            return search(str, 0, 0);
        }

        private boolean search (String str, int idx, int node) {
            if (checkOutputLink(node)) return true;
            if (idx == str.length()) return false;

            int c = str.charAt(idx) - 'a';
            if (trie.get(node).children[c] != -1) {
                return search(str, idx + 1, trie.get(node).children[c]);
            } else {
                if (node == 0) return search(str, idx + 1, 0);
                return search(str, idx, trie.get(node).fl);
            }
        }

        private boolean checkOutputLink (int node) {
            if (node == 0) return false;
            if (trie.get(node).vaild) return true;
            return checkOutputLink(trie.get(node).fl);
        }
    }
}