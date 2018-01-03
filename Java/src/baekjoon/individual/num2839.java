package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 3..
 */
public class num2839 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int su = stdin.nextInt();
        int min = 999999999;

        if(su>=3 && su<=5000){
            for(int x = 0; x <= su/5; x ++){
                int temp = su - x*5;
                if(temp % 3 == 0){
                    int y = temp / 3;
                    if(min > x+y) min = x+y;
                }
            }
        }

        if(min == 999999999) min = -1;
        System.out.print(min);
    }
}
