package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primes = getprime(n);

        long diff = 1;

        Iterator<Integer> iterator = primes.iterator();
        int p = iterator.hasNext() ? iterator.next() : 0;

        while (n > 1) {
            while (n % p == 0) {
                System.out.println(p);
                n /= p;
                diff *= p;
            }

            if (iterator.hasNext()) p = iterator.next();
            else {
                if (n > 1) System.out.println(n);
                break;
            }
        }
        System.out.println(diff * n);
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