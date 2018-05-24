package baekjoon.algoStudy;

import java.util.*;

public class Main {
    // Diff : 부분집합의 합과 다른 것 = 공집합이 없음
    static Scanner sc;
    public static void main (String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();
        Array firstArray = new Array(sc.nextInt());
        firstArray.setInitArray();
        Array secondArray = new Array(sc.nextInt());
        secondArray.setInitArray();

        Collections.sort(firstArray.subSumArray);
        Collections.sort(secondArray.subSumArray);
        int fi = 0; int si = secondArray.subSumArray.size() - 1;
        int result = 0;

        int firstSize = firstArray.subSumArray.size();
        while (fi < firstSize && si >= 0) {
            int f = firstArray.subSumArray.get(fi);
            int s = secondArray.subSumArray.get(si);
            int sum = f + s;

            if (sum == T) {
                int cnt1 = 1; int cnt2 = 1;
                while (++fi < firstSize && firstArray.subSumArray.get(fi) == f) cnt1++;
                while (--si >= 0 && secondArray.subSumArray.get(si) == s) cnt2++;
                result += cnt1 * cnt2;
            }else if (sum > T) --si;
            else ++fi;
        }

        System.out.println(result);
    }

    static class Array {
        int n;
        List<Integer> subSumArray = new LinkedList<>();
        int[] sumTempArray;
//        SortedMap<Integer, Integer> countMap = new TreeMap<>();
//        int[][] subArray;

        public Array(int n) {
            this.n = n;
            sumTempArray = new int[n + 1];
//            subArray = new int[n][n + 1];
        }

        public void setInitArray() {
            for (int i = 1; i <= n; i++) {
                int num = sc.nextInt();
                for (int j=i; j>0; j--) {
                    int sum = sumTempArray[j-1] + num;
                    sumTempArray[j] = sum;
                    subSumArray.add(sum);
                }
            }
        }
    }
}