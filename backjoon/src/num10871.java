import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 1..
 * X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
 */
public class num10871 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int x = stdin.nextInt();

        String result = "";
        for (int i =0; i<N;i++) {
            int a = stdin.nextInt();
            if(a < x)
                result += a+" ";
        }
        System.out.print(result);
    }
}
