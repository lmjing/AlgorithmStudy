package baekjoon.individual;

import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 10..
 */
public class num2920 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int input[] = new int[8];
        int type = 0;
        for(int i=0;i<8;i++) {
            input[i] = stdin.nextInt();
        }
        boolean flag = true;
        for(int i=1;i<8;i++){
            int temp = input[i]-input[i-1];
            switch (temp){
                case 1 : type = 1; break;
                case -1 : type = 2; break;
                default: flag = false;
            }
        }
        if(flag == false) System.out.print("mixed");
        else{
            if(type == 1) System.out.print("ascending");
            else if(type == 2) System.out.print("descending");
        }
    }
}
