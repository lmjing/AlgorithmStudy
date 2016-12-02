package num2750;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2750_bubblesort {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        int[] su = new int[cnt];
        for(int i=0;i<cnt;i++)
            su[i] = stdin.nextInt();

        for(int i=0;i<su.length-1;i++){
            for(int j=0;j<su.length-i-1;j++){
                if(su[j]>su[j+1]){
                    int temp = su[j];
                    su[j] = su[j+1];
                    su[j+1] = temp;
                }
            }
        }

        for(int a:su)
            System.out.println(a);
    }
}
