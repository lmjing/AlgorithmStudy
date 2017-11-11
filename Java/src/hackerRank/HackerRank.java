package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerRank {
    public static void main(String[] args) throws IOException {
        WarmUp.DiagonalDifference();
    }

    static class WarmUp {
        static void DiagonalDifference() throws IOException {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            int count = Integer.parseInt(br.readLine());
            String[][] input = new String[count][count];
            int sum1 = 0, sum2 = 0;

            for(int i=0; i<count; i++) {
                input[i] = br.readLine().split(" ");
                sum1 += Integer.parseInt(input[i][i]);
                sum2 += Integer.parseInt(input[i][count - i - 1]);
            }
            System.out.print(Math.abs(sum1 - sum2));
        }
    }
}
