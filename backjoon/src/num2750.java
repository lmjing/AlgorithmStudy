import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 */
public class num2750 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        int[] su = new int[cnt];
        for(int i=0;i<cnt;i++)
            su[i] = stdin.nextInt();

        for (int i=0;i<su.length-1;i++){
            int index = i;
            int min = su[i];
            for(int j=i+1;j<su.length;j++){
                if(su[j]<min) {
                    min = su[j];
                    index = j;
                }
            }
            su[index] = su[i];
            su[i] = min;
        }

        for(int a:su)
            System.out.println(a);
    }
}
