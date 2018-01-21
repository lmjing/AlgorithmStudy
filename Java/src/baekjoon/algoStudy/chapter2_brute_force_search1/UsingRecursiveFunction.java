package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class UsingRecursiveFunction {
    static void num9095() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(cal(n));
        }
    }

    static int cal(int n) {
        if (n < 1) return 0;
        int sum = 0;
        // 앞자리가 i일 경우
        for (int i=1; i<=3; i++) {
            if (i>=n) {
                sum ++;
                break;
            }
            int diff = n - i;
            sum += cal(diff);
        }
        return sum;
    }

    static void num1759() {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        LinkedList<String> arrayList = new LinkedList<>();
        for (int i=0; i<C; i++) arrayList.add(sc.next());
        Collections.sort(arrayList);
        makePassword(arrayList, 0, 0, L, "", 0);
    }

    static void makePassword(LinkedList<String> arrayList, int count, int i, int L, String str, int vowel) {
        if (count == L) {
            if (vowel >= 1 && L-vowel >= 2) System.out.println(str);
            return;
        }
        if (i >= arrayList.size()) return;

        String s = arrayList.get(i);
        int newVowel = vowel;
        if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) ++newVowel;
        makePassword(arrayList, count + 1, i+1, L, str + s, newVowel);
        makePassword(arrayList, count, i+1, L, str, vowel);
    }
}
