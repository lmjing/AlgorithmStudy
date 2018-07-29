package baekjoon.algoStudy.chapter1_input_output;

import java.io.*;
import java.util.*;

public class AddAB {
    public void num1000() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.print(a + b);

        //이걸로 하면 시간 더 빠름
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        char[] test = new char[3];
//        br.read(test);
//        System.out.print(Integer.parseInt(String.valueOf(test[0])) + Integer.parseInt(String.valueOf(test[2])));
    }

    public void num2558() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int a = Integer.parseInt(scanner.nextLine());
//        int b = Integer.parseInt(scanner.nextLine());
//        System.out.print(a + b);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.print(a + b);
    }

    public void num10950() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            char[] c = new char[3];
            br.read(c);
            br.skip(1);
            System.out.println(Integer.parseInt(String.valueOf(c[0])) + Integer.parseInt(String.valueOf(c[2])));
        }
    }

    public void num10951() throws IOException {
        // Scanner만 hasNext 함수가 있기 때문에 EOF를 알 수 있다.
        // 백준에서 입력, 출력 나눠서 한꺼번에 보여줄 필요가 없다...
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }

    public void num10952() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }

    public void num10953() {
        //근데 이거 intellij에서 돌리면 마지막거 안됨 ㅋㅋㅋㅋ근데 성공
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int i=0; i<T; i++) {
            String[] inputs = sc.nextLine().split(",");
            System.out.println(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]));
        }
    }

    public void num11021() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int i=1; i<=T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case #" + i + ": " + (a + b));
        }
    }

    public void num11022() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for(int i=1; i<=T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case #" + i + ": " + a + " + " + b + " = " +(a + b));
        }
    }
    
    public static void num15552() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            bw.append((Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]) + "\n"));
        }
        bw.flush();
        bw.close();
    }
}
