package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static Scanner sc;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        Array firstArray = new Array(sc.nextInt());
        firstArray.setInitArray();
        Array secondArray = new Array(sc.nextInt());
        secondArray.setInitArray();

        Iterator<Integer> fIter = firstArray.countMap.keySet().iterator();
        List<Integer> secondKeyListReverse = new ArrayList<>(secondArray.countMap.keySet());
        Collections.reverse(secondKeyListReverse);
        Iterator<Integer> sIter = secondKeyListReverse.iterator();

        int result = 0;

        int sKey = sIter.next(), fKey = fIter.next();
        while (sIter.hasNext() || fIter.hasNext()) {
            if (fKey >= T) break;
            int sum = sKey + fKey;

            if (sum == T) {
                result += firstArray.countMap.get(fKey) * secondArray.countMap.get(sKey);
                if (sIter.hasNext() && sIter.hasNext()) {
                    fKey = fIter.next();
                    sKey = sIter.next();
                } else break;
            } else if (sum < T) {
                if (fIter.hasNext()) fKey = fIter.next();
                else break;
            } else {
                if (sIter.hasNext()) sKey = sIter.next();
                else break;
            }
        }

        System.out.println(result);

    }

    static class Array {
        int n;
        SortedMap<Integer, Integer> countMap = new TreeMap<>();
        int[][] subArray;

        public Array(int n) {
            this.n = n;
            subArray = new int[n][n + 1];
        }

        public void setInitArray() {
            for (int i = 1; i <= n; i++) {
                int num = sc.nextInt();
                for (int j=0; j<i; j++) {
                    int count = subArray[j][i - 1] + num;
                    subArray[j][i] = count;
                    Integer value = countMap.get(count);
                    if (value == null) {
                        value = 0;
                        countMap.put(count, value);
                    }
                    countMap.replace(count, value + 1);
                }
            }
        }
    }
}