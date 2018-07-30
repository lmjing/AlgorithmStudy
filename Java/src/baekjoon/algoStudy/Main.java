package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Trie trie = new Trie();
        int result = 0;
        for (int i = 0; i < N; i++) trie.add(sc.next());
        for (int i = 0; i < M; i++) {
            if (trie.search(sc.next()))
                result++;
        }
        System.out.println(result);
    }

    static class Trie {
        ArrayList<Node> trie;
        int root;

        public Trie () {
            trie = new ArrayList<>();
            root = init();
        }

        public int init() {
            Node x = new Node();
            trie.add(x);
            return trie.size() - 1;
        }

        class Node {
            int[] children = new int[26];

            public Node () {
                for (int i = 0; i < 26; i++)
                    children[i] = -1;
            }
        }

        public void add (String s) {
            add(root, s, 0);
        }

        private void add (int node, String s, int idx) {
            if (s.length() == idx) {
                return;
            }
            int c = s.charAt(idx) - 'a';
            if (trie.get(node).children[c] == -1) {
                int next = init();
                trie.get(node).children[c] = next;
            }
            int child = trie.get(node).children[c];
            add(child, s, idx + 1);
        }

        public boolean search (String s) {
            return search(root, s, 0);
        }

        private boolean search (int node, String s, int idx) {
            if (node == -1) return false;
            if (s.length() == idx) {
                return true;
            }
            int c = s.charAt(idx) - 'a';
            int child = trie.get(node).children[c];
            return search(child, s, idx + 1);
        }
    }
}