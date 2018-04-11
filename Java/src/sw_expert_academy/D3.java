package sw_expert_academy;

import java.util.*;

public class D3 {

    // 거듭제곱
    public static void square_question() {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<10; i++) {
            int t = Integer.parseInt(sc.nextLine());
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            System.out.println("#" + t + " " + square(n,m));
        }
    }
    
    static int square(int n, int m) {
        if(m==1) return n;
        return n * square(n, m-1);
    }

}
