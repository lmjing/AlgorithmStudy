package baekjoon.algoStudy.chapter2_brute_force_search;

import java.io.*;

public class BitMask {
    public void num11723() throws IOException {
        /*
        비트 마스크 연습
        문제 : java Scanner, System.out은 너무 느려서 계속 시간초과가 떴다.
        둘다 BufferedReader와 BufferedWriter & PrintWriter로 변경하니 성공.
        pw 쓸 때는 pw.close(); 해주어야지만 콘솔에 출력된다.
        참고 사이트 : http://bloodygale.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%9E%85%EC%B6%9C%EB%A0%A5IO-2-%ED%85%8D%EC%8A%A4%ED%8A%B8Text-%EC%9E%85%EC%B6%9C%EB%A0%A5
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter(bw);

        int count = Integer.parseInt(br.readLine());
        int bitmask = 0;

        for(int i=0; i<count; i++) {
            String[] input = br.readLine().split(" ");
            switch (input[0]) {
                case "add": bitmask |= (1<<Integer.parseInt(input[1])); break;
                case "check":
                    int check = (bitmask & (1<<Integer.parseInt(input[1])));
                    pw.println(check >> Integer.parseInt(input[1])); break;
                    /* 이 방법보단 위에 방법이..
                    int check = (bitmask & (1<<Integer.parseInt(input[1]))) != 0 ? 1 : 0;
                    pw.println(check); break;
                    */
                case "remove": bitmask &= ~(1<<Integer.parseInt(input[1])); break;
                case "toggle": bitmask ^= (1<<Integer.parseInt(input[1])); break;
                case "all": bitmask = (1<<21) - 1; break;
                case "empty": bitmask = 0; break;
            }
        }
        pw.close();
    }
}
