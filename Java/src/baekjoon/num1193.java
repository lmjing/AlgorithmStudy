package baekjoon;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num1193 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int input = stdin.nextInt();

        int x, y = 1;

        int sunseo = 1;
        int sum = 0;
        while(!(input>sum&&input<=sum+sunseo)){
            sum+=sunseo;
            sunseo++;
        }
        sum+=sunseo;
        int cnt = sunseo-(sum-input)-1;

        if(sunseo%2==0){
            x=1; y=sunseo;
            x+=cnt; y-=cnt;
        }else{
            x=sunseo; y=1;
            x-=cnt; y+=cnt;
        }

        System.out.print(x+"/"+y);
    }
}
