package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 5..
 */
class num2581
{
    static ArrayList<Integer> result;

    public static void main (String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int m = stdin.nextInt();
        int n = stdin.nextInt();

        result = new ArrayList<Integer>();

        getprime(m,n);

        if(result.size()>0){
            int sum = 0;
            for(int i=0;i<result.size();i++){
                sum += result.get(i);
            }
            System.out.println(sum);
            System.out.print(result.get(0));
        }else System.out.print(-1);
    }

    static void getprime(int m, int n){
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i=2;i<=n;i++){
            boolean flag = true;
            for(int a=0;a<prime.size();a++){
                if(i%prime.get(a)==0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                prime.add(i);
                if(i<=n&&i>=m) result.add(i);
            }
        }
    }
}