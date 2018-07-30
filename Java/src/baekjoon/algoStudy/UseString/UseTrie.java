package baekjoon.algoStudy.UseString;

import java.util.*;

public class UseTrie {
    // NOTE : 문제별 간단한 코드 보려면 백준 내역 볼 것. 여긴 중복코드 줄일려고 이렇게 관리함.
    static public abstract class Trie {
        ArrayList<Node> trie;
        int root;

        class Node {
            int[] children = new int[26];
            boolean vaild;

            public Node () {
                for (int i = 0; i < 26; i++)
                    children[i] = -1;
                vaild = false;
            }
        }

        public int init() {
            Node x = new Node();
            trie.add(x);
            return trie.size() - 1;
        }

        public Trie() {
            trie = new ArrayList<>();
            root = init();
        }

        public void add (String s) {
            add(root, s, 0);
        }

        abstract void add (int node, String s, int idx);

        public boolean search (String s) {
            return search(root, s, 0);
        }

        abstract boolean search (int node, String s, int idx);
    }


    public static class Num14425 {
        static class Trie extends UseTrie.Trie {
            @Override
            void add (int node, String s, int idx) {
                if (s.length() == idx) {
                    trie.get(node).vaild = true;
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

            @Override
            boolean search (int node, String s, int idx) {
                if (s.equals("codingsh")) System.out.println(node + " " + idx);
                if (node == -1) return false;
                if (s.length() == idx) return trie.get(node).vaild;
                int c = s.charAt(idx) - 'a';
                int child = trie.get(node).children[c];
                return search(child, s, idx + 1);
            }
        }

        public static void main() {
            // NOTE : (java는 원래) 시간초과
            // TODO : 시간초과 안 나게 풀어볼 것
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();

            Trie trie = new Trie();
            int result = 0;
            for (int i = 0; i < N; i++)
                trie.add(sc.next());
            for (int i = 0; i < M; i++) {
                if (trie.search(sc.next())) result++;
            }
            System.out.println(result);
        }
    }

    
}