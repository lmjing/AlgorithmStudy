package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 9..
 */
public class num1546 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int count = stdin.nextInt();
        float jumsu[] = new float[count];
        float max = 0;
        for(int i=0;i<count;i++){
            jumsu[i] = stdin.nextFloat();
            if(jumsu[i]>max) max = jumsu[i];
        }

        float sum = 0;
        for(int i=0;i<count;i++){
            jumsu[i] = jumsu[i]/max*100.00f;
            sum += jumsu[i];
        }
        float result = Math.round(sum/(double)count * 100);
        System.out.printf("%.2f",result/100);
    }
}
