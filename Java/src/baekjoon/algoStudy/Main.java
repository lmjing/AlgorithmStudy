package baekjoon.algoStudy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int i=1; i<=T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case #" + i + ": " + (a + b));
        }
    }
}
