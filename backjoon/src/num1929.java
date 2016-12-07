import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by mijeong on 2016. 12. 5..
 * 시간초과로 인해 에라토스테네스의 체 이용해 구현
 * 에라토스테네스의 체 : 120 이하의 수들 중 소수들은 11^2 > 120 이므로, 120보다 작거나 같은 수 가운데 2, 3, 5, 7의 배수를 지우고 남는 수는 모두 소수이다.


 */
class num1929
{
    public static void main (String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        int m = stdin.nextInt();
        int n = stdin.nextInt();

        int[] arr = new int[n+1];
        arr[0] = arr[1] = 1;

        for(int a:getprime(n)){
            for(int i=a+a;i<=n;i+=a){
                arr[i] = 1;
            }
        }
        for(int i=m;i<=n;i++){
            if(arr[i]==0)
                System.out.println(i);
        }
    }

    static ArrayList<Integer> getprime(int n){
        int max = (int) Math.sqrt(n);
        ArrayList<Integer> prime = new ArrayList<Integer>();
        for(int i=2;i<=max;i++){
            boolean flag = true;
            for(int a=0;a<prime.size();a++){
                if(i%prime.get(a)==0){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                prime.add(i);
            }
        }
        return prime;
    }
}