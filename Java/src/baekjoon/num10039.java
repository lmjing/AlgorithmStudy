package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 10..
 */
public class num10039 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int jumsu[] = new int[5];
        int sum = 0;
        for(int i=0;i<5;i++){
            jumsu[i] = stdin.nextInt();
            if(jumsu[i]<40) jumsu[i] = 40;
            sum += jumsu[i];
        }
        System.out.print(sum/5);
    }
}
