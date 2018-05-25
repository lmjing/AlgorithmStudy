package baekjoon.algoStudy.chapter2_brute_force_search2;

import java.util.*;

public class MeetInTheMiddle {

    public class Num1208 {
        // USE : 완전 탐색, 이분법
        /*
        BEFORE : github issue #1 참고
         */
        // AFTER : 모두 0이고 s도 0인 경우 기존 방법 사용하되, 공집합 + 공집합인 경우 = 1 을 뺌
        // NOTE : 거의 이틀동안 품, 이분법 하는 것도 레퍼런스 참고해서 품 ㅠㅠ
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int s = sc.nextInt();
            Subset subset = new Subset(n, s);

            for (int i=0; i<n/2; i++) subset.setLeftNum(sc.nextInt(), i);
            for (int i=0; i<n-n/2; i++) subset.setRightNum(sc.nextInt(), i);

            System.out.println(subset.getAnswer());
        }

        class Subset {
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
}
