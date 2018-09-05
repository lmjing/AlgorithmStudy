package sw_expert_academy;

import java.util.*;

public class D2 {
    public static void num2369() {
        // NOTE : 2차시도 만에 성공함. testcase 잘못 출력.. 확인 잘하자..
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int sum = 0;
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                sum += (r - l) + 1;
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}
