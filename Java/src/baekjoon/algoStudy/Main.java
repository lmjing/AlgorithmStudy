package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        Subset subset = new Subset(n, s);

        for (int i=0; i<n/2; i++) subset.setLeftNum(sc.nextInt(), i);
        for (int i=0; i<n-n/2; i++) subset.setRightNum(sc.nextInt(), i);

        System.out.println(subset.getAnswer());
    }

    static class Subset {
        int n, s;
        long[] leftArray;
        long[] rightArray;
        int l, r;

        public Subset(int n, int s) {
            this.n = n;
            this.s = s;
            leftArray = new long[(int) Math.pow(2, n/2)];
            rightArray = new long[(int) Math.pow(2, n - n/2)];
            l = 1; r = 1;
        }

        void setLeftNum(long num, int k) {
            for(int i = 0; i < Math.pow(2, k); i++) {
                leftArray[l++] = leftArray[i] + num;
            }
        }

        void setRightNum(long num, int k) {
            for(int i = 0; i < Math.pow(2, k); i++) {
                rightArray[r++] = rightArray[i] + num;
            }
        }

        long getAnswer() {
            l = 0; r = rightArray.length - 1;
            Arrays.sort(leftArray);
            Arrays.sort(rightArray);
            long count = 0;
            while (l < leftArray.length && r >= 0) {
                long ln = leftArray[l]; long rn = rightArray[r];
                long sum = ln + rn;
                if (sum == s) {
                    long lc = 1, rc = 1;
                    ++l; --r;
                    while (l < leftArray.length && leftArray[l] == ln) {
                        ++lc;
                        ++l;
                    }
                    while (r >= 0 && rightArray[r] == rn) {
                        ++rc;
                        --r;
                    }
                    count += lc*rc;
                    if(ln == 0 && rn == 0) --count;
                }else if (sum > s) --r;
                else ++l;
            }
            return count;
        }
    }
}