import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2292 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int input = stdin.nextInt();

        int before;
        int num = 1;
        int i = 0;
        do {
            before = num;
            num += i * 6;
            i++;
        }while (!(input>before&&input<=num));

        System.out.print(i);
    }
}
