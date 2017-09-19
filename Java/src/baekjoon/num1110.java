package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 7..
 */
public class num1110 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int input = stdin.nextInt();
        int temp = input;
        int cnt = 0;

        while (true) {
            if (temp < 100 && temp >= 0) {
                int x = temp / 10;
                int y = temp % 10;
                int z = (x+y) % 10;
                temp = y * 10 + z;
                cnt++;

                if(input==temp) break;
            }else break;
        }

        System.out.print(cnt);
    }
}
