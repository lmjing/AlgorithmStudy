package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> primes = getprime(n);

        Iterator<Integer> iterator = primes.iterator();
        int p = iterator.hasNext() ? iterator.next() : 0;

        while (n > 1) {
            while (n > 1 && n % p == 0) {
                System.out.println(p);
                n /= p;
            }

            if (iterator.hasNext()) p = iterator.next();
            else {
                if (n > 1) System.out.println(n);
                break;
            }
        }
    }

    static ArrayList<Integer> getprime(int n){
        ArrayList<Integer> prime = new ArrayList<Integer>();
        int[] check = new int[n + 1];

        int i = 1;
        while (++i * i <= n) {
            if (check[i] == 0) {
                prime.add(i);
                for (int j = i * i; j <= n; j += i) {
                    check[j] = -1;
                }
            }
        }
        while (i <= n) {
            if (check[i] == 0)
                prime.add(i);
            i++;
        }
        return prime;
    }
}