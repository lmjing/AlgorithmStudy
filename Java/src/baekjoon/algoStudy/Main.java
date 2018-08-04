package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int mi=0;
        double min = 0;
        int route = 0;

        int[] num = new int[n];
        int[] S = new int[n-k+1];
        double[] m = new double[n-k+1];
        double[] br = new double[n-k+1];
        double[] r = new double[n-k+1];

        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }

        route=n-k+1;
        mi=k;
        for(int i=0;i<n-k+1;i++){
            for(int j=n-1;j>=k-1;j--){
                S[i]+=num[j];
            }
            m[i]=S[i]/mi;
            n=n-1;
            k=k-1;

            System.out.println(m[i]);
        }
        
        n=n+route;
        k=k+route;
        System.out.println(n);
        System.out.println(k);

        for(int i=0;i<n-k+1;i++){
            for(int j=n-1;j>=k-1;j--){
                br[i]+=(num[j]-m[i])*(num[j]-m[i]);

                System.out.println(br[i]);
            }
            r[i]=br[i]/mi;
            n=n-1;
            k=k-1;
            System.out.println(m[i]);
            System.out.println(br[i]);
            System.out.println(r[i]);
        }
        
        n=n+route;
        k=k+route;

        min=r[0];

        for(int i=0;i<n-k+1;i++){
            System.out.println(r[i]);
        }
        System.out.println(min);
    }
}