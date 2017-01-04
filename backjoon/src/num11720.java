import java.util.Scanner;

/**
 * Created by mijeong on 2017. 1. 4..
 */
public class num11720 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int cnt = stdin.nextInt();
        String num = stdin.next();
        int sum = 0;

        for(int i=0;i<cnt;i++){
            int n = Integer.parseInt(num.substring(i,i+1));
            sum += n;
        }

        System.out.print(sum);
    }
}
