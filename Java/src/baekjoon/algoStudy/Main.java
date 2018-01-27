package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] array = new int[k];
            for (int i=0; i<k; i++) array[i] = sc.nextInt();
            sc.nextLine();
            makeLotto(array, 0, new StringBuffer(""), 0);
            System.out.println();
        }
    }

    static void makeLotto(int[] array, int i, StringBuffer lotto, int j) {
        if (j == 6) {
            System.out.println(lotto);
            return;
        }
        if (i >= array.length) return;

        StringBuffer newLotto = new StringBuffer(lotto);
        newLotto.append(array[i] + " ");
        makeLotto(array,i+1, newLotto, j+1);
        makeLotto(array,i+1, lotto, j);
    }
}