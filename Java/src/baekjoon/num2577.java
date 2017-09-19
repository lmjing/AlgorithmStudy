package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2577 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int num = 1;
        for(int i=0;i<3;i++)
            num *= stdin.nextInt();

        int[] count = new int[10];
        for(int a:count)
            a = 0;

        while(num>0){
            int temp = num % 10;
            count[temp]++;
            num /= 10;
        }

        for(int a:count)
            System.out.println(a);
    }
}
