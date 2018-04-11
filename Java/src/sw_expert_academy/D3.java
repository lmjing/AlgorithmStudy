package sw_expert_academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    //Magnetic
    public static void num1220() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=1; i<11; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][n];
            StringBuilder[] col = new StringBuilder[n];
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    if(col[k] == null) col[k] = new StringBuilder();
                    String temp = st.nextToken();
                    if(!temp.equals("0"))col[k].append(temp);
                }
            }

            int sum = 0;
            for(int j=0; j<n; j++) {
                StringBuilder str = col[j];
                int len = str.length();

                int ni = 0; int mi = len-1;
                while(ni<len && str.charAt(ni) == '2') ni++;
                while(mi>=0 && str.charAt(mi) == '1') mi--;
                if(ni >= mi) continue;

                int count = 0;
                char before = str.charAt(ni);
                for(int k=ni+1; k<=mi; k++) {
                    if(str.charAt(k) == '2' && before != '2') count++;
                    before = str.charAt(k);
                }
                sum += count;
            }
            System.out.println("#" + i + " " + sum);
        }
    }

}
