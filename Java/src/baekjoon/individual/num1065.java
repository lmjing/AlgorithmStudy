package baekjoon.individual;

import java.util.Scanner;

public class num1065 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int insert = stdin.nextInt();
        int result = 0;
        if(insert<100&&insert>=1)
            result = insert;
        else{
            result = 99;
            for(int j=100;j<=insert;j++){
                result+=check(j);
            }
        }
        System.out.print(result);
    }
    public static int check(int num){
        int[] su = new int[3];
        if(num<1000) {
            for (int i = 0; i < 3; i++) {
                su[i] = num % 10;
                num = (num - su[i]) / 10;
            }
            if ((su[1] - su[0]) == (su[2] - su[1])) {
                return 1;
            }
        }
        return 0;
    }
}
