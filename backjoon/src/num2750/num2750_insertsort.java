package num2750;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2750_insertsort {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        int[] su = new int[cnt];
        for(int i=0;i<cnt;i++)
            su[i] = stdin.nextInt();

        for(int i=1;i<cnt;i++){
            int j = i-1, key=su[i];
            while(j>=0 && key <su[j]){

                int temp = su[j+1];
                su[j+1]=su[j];
                su[j] =temp;

                j--;
            }
            su[j+1] = key;
        }

        for(int a:su)
            System.out.println(a);
    }
}
