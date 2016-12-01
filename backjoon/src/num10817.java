import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 1..
 * 세 정수 A, B, C가 주어진다. 이 때, 두 번째로 큰 정수를 출력하는 프로그램을 작성하시오.
 */
public class num10817 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int[] su = new int[3];

        for(int i =0;i<3;i++) {
            su[i] = stdin.nextInt();
        }

        for(int i=0;i<2;i++){
            for(int j=i+1;j<3;j++) {
                if (su[i] > su[j]) {
                    int temp = su[i];
                    su[i] = su[j];
                    su[j] = temp;
                }
            }
        }
        System.out.print(su[1]);
    }
}
