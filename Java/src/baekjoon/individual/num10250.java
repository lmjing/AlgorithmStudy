package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 17..
 * (1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W).
 */
public class num10250 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int testcase = stdin.nextInt();
        int result[] = new int[testcase];
        for(int i=0;i<testcase;i++){
            int h = stdin.nextInt();
            int w = stdin.nextInt();
            int n = stdin.nextInt();

            if(h>=1 && w<=99 && n>=1 && n<=h*w) {
                int n_w = n/h + 1;
                if(n/h == 0){
                    n_w = 1;
                }else if(n % h == 0) n_w = n/h;
                int n_h = n % h;
                if (n_h == 0) n_h = h;
                result[i] = n_h * 100 + n_w;
            }
        }
        for(int r : result) System.out.println(r);
    }
}
