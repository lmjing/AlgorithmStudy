package baekjoon.algoStudy;

import java.util.*;

public class Main {
    static Scanner sc;
    public static void main (String[] args) {
//        sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        Array firstArray = new Array(sc.nextInt());
//        firstArray.setInitArray();
//        Array secondArray = new Array(sc.nextInt());
//        secondArray.setInitArray();

        int[] test1 = new int[1000];
        int[] test2 = new int[1000];
        for (int i=1; i<=999; i++) {
            test1[i] = 100;
            test2[i] = 100;
        }
        test1[0] = 1; test1[1] = 3; test1[2] = 1; test1[3] = 2;
        test2[0] = 1; test2[1] = 3; test2[999] = 2;
        int T = 5;
        Array firstArray = new Array(1000);
        firstArray.setInitArray(test1);
        Array secondArray = new Array(1000);
        secondArray.setInitArray(test2);

        Iterator<Integer> fIter = firstArray.countMap.keySet().iterator();
        List<Integer> secondKeyListReverse = new ArrayList<>(secondArray.countMap.keySet());
        Collections.reverse(secondKeyListReverse);
        Iterator<Integer> sIter = secondKeyListReverse.iterator();

        long result = 0;

        // 1개 이상이란 가정하에
        int fKey = fIter.next();
        int sKey = sIter.next();

        do {
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
        } while (sIter.hasNext() || fIter.hasNext());

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

        public void setInitArray(int[] array) {
            for (int i = 1; i <= n; i++) {
                int num = array[i-1];
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