package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TextTree textTree = new TextTree();

        for (int i = 0; i < n; i++)
            textTree.add(sc.next());

        int count = 0;
        ArrayList<String> answer = new ArrayList();

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            if (textTree.check(str)) {
                count++;
                answer.add(str);
            }
        }
        System.out.println(count);

        Collections.sort(answer);
        String before = null;
        for (String s : answer) {
            if (!s.equals(before))
                System.out.println(s);
            before = s;
        }
    }

    static class TextTree {
        Node root;

        public TextTree () {
            root = new Node(-1);
        }

        public void add (String str) {
            char[] chars = str.toCharArray();
            int i = 0;

            Node cur = root;
            while (i < str.length()) {
                int c = chars[i++] - 97;
                if (cur.alphabets[c] == null)
                    cur.addSub(c);
                cur = cur.alphabets[c];
            }
        }

        public boolean check (String str) {
            char[] chars = str.toCharArray();
            int i = 0;

            Node cur = root;
            while (i < str.length()) {
                int c = chars[i++] - 97;
                if (cur.alphabets[c] == null)
                    return false;
                cur = cur.alphabets[c];
            }
            return cur.last ? true : false;
        }

        class Node {
            int v;
            boolean last;
            Node[] alphabets;

            public Node (int v) {
                this.v = v;
                last = true;
                alphabets = new Node[26];
            }

            public void addSub (int i) {
                alphabets[i] = new Node(i);
                last = false;
            }
        }
    }
}