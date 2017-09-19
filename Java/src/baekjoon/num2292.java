package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2292 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int input = stdin.nextInt();

        int before = 0;
        int num = 1;
        int i = 0;
        while (!(input>before&&input<=num))
        {
            before = num;
            num += (i) * 6;
            i++;
        }

        if(input==1)
            System.out.print(1);
        else
            System.out.print(i);
    }
}
