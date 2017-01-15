import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 15..
 */
public class num1475 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        String temp = stdin.next();
        String input[] = temp.split("");
        int[] count = new int[10];

        for(String a : input){
            count[Integer.parseInt(a)] ++;
        }

        count[6] = (count[6] + count[9] + 1) / 2;
        count[9] = 0;

        int max = 0;
        for(int i=0; i<9; i++){
            if(count[i] > max) max = count[i];
        }

        System.out.print(max);
    }
}
