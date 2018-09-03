package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, Boolean> checkList = new HashMap<>();

        for (int i = 0; i < n; i++)
            checkList.put(sc.next(), true);

        ArrayList<String> answer = new ArrayList();

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            if (checkList.containsKey(str)) {
                answer.add(str);
            }
        }
        System.out.println(answer.size());

        Collections.sort(answer);
        for (String s : answer) {
                System.out.println(s);
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