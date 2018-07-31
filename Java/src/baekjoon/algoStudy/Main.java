package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            boolean flag = true;
            Trie trie = new Trie();

            String[] inputs = new String[n];
            for (int j = 0; j < n; j++) inputs[j] = sc.next();
            Arrays.sort(inputs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            for (int j = 0; j < n; j++) {
                if (flag) flag = trie.add(inputs[j]);
            }
            System.out.println(flag ? "YES" : "NO");
        }
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
            int[] children = new int[10];
            boolean vaild;

            public Node () {
                for (int i = 0; i < 10; i++)
                    children[i] = -1;
                vaild = false;
            }
        }

        public boolean add (String s) {
            return add(root, s, 0);
        }

        private boolean add (int node, String s, int idx) {
            if (trie.get(node).vaild == true) return false;
            if (s.length() == idx) {
                trie.get(node).vaild = true;
                return true;
            }
            int c = s.charAt(idx) - '0';
            if (trie.get(node).children[c] == -1) {
                int next = init();
                trie.get(node).children[c] = next;
            }
            int child = trie.get(node).children[c];
            return add(child, s, idx + 1);
        }
    }
}
