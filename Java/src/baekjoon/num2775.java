package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 15..
 */
public class num2775 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        int aa[][] = new int[15][15];
        int result[] = new int[cnt];

        for(int i=0; i<15; i++)
            aa[0][i] = i+1;

        for(int i=1;i<15;i++){
            aa[i][0] = 1;
            for(int j=1;j<15;j++){
                aa[i][j] = aa[i][j-1] + aa[i-1][j];
            }
        }

        for(int i=0;i<cnt;i++){
            int k = stdin.nextInt();
            int n = stdin.nextInt();
            result[i] = aa[k][n-1];
        }
        for (int i=0;i<cnt;i++) System.out.println(result[i]);
    }
}
