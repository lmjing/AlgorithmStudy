package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = Integer.parseInt(sc.nextLine());
        char[] screen = sc.nextLine().toCharArray();

        LinkedList<Character> ad = new LinkedList<>();
        LinkedList<Character> temp = new LinkedList<>();
        ad.add(screen[0]);
        Iterator iter = ad.iterator();
        char compare = (char) iter.next();

        int i = 0;
        while (++i < L) {
            if (compare == screen[i] && iter.hasNext()) {
                System.out.println(ad.size());
                temp.add(screen[i]);
                compare = (char) iter.next();
            } else {
                if (!temp.isEmpty()) {
                    ad.addAll(temp);
                    temp = new LinkedList<>();
                }
                ad.add(screen[i++]);
                iter = ad.iterator();
                compare = (char) iter.next();
            }
        }
        System.out.println(ad.size());
    }
}