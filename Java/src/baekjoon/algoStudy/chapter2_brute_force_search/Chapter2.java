package baekjoon.algoStudy.chapter2_brute_force_search;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Chapter2 {
    public void num11723_bitmask() throws IOException {
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

    public void num10972_next_permutation() throws IOException {
        //다음 순열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int index = 0;
        for (String s : br.readLine().split(" ")) {
            input[index++] = Integer.parseInt(s);
        }

        String answer = null;
        for (int i=n-1; i>0; i--) {
            if (input[i] > input[i-1]) {
                for(int j=n-1; j>0; j--) {
                    if (i <= j && input[i-1] < input[j]) {
                        swap(input, i-1, j);
                        answer = makeAnswer(input, i);
                        break;
                    }
                }
                break;
            }
        }

        System.out.println(answer != null ? answer : -1);
    }

    void swap(int[] array, int i, int j) {
        //배열은 call by reference
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    String makeAnswer(int[] array, int i) {
        String answer = "";
        for (int j=0; j<i; j++) {
            answer += array[j] + " ";
        }
        for (int j=array.length-1; j>=i; j--) {
            answer += array[j] + " ";
        }
        return answer;
    }

    public void num10974_all_permutation() {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter(bw);

        int n = sc.nextInt();
        int[] permutation = new int[n];
        for (int i=0; i<n; i++) {
            permutation[i] = i+1;
            pw.print(i+1 + " ");
        }
        pw.println("");

        while (permutation != null) {
            permutation = next_permutation(pw, permutation);
        }
        pw.close();
    }

    private int[] next_permutation(PrintWriter pw, int[] permutation) {
        int i = permutation.length - 1;
        while (i > 0 && permutation[i-1] >= permutation[i]) i--;
        if (i<=0) {
            permutation[0] = -1;
        }else {
            int j = permutation.length - 1;
            while (i > j || permutation[i-1] > permutation[j]) j--;
            swap(permutation, i-1, j);
            return printArray(pw, permutation, i);
        }
        return null;
    }

    private int[] printArray(PrintWriter pw, int[] permutation, int i) {
        int[] newPermutation = new int[permutation.length];
        int index = 0;
        for (int z=0; z<i; z++) {
            newPermutation[index++] = permutation[z];
            pw.print(permutation[z] + " ");
        }
        for (int z=permutation.length-1; z>=i; z--) {
            newPermutation[index++] = permutation[z];
            pw.print(permutation[z] + " ");
        }
        pw.println("");
        return newPermutation;
    }

    public void num1722() {
        // 틀렸던 이유: int 타입으로 했더니 범위 초과해서 long으로 바꿨는데, 몇 개만 바꾸고 뭐는 안바꿔서 틀림.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int q = sc.nextInt();

        LinkedList<Integer> rest = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) {
            rest.add(i);
        }
        int index = 0;
        long fac = factorial(n-1);

        if (q == 1) {
            long k = sc.nextLong();
            String answer = "";
            // i는 남은 자리 수(앞이 rest(index)로 채워 진 경우 가능한 순열의 수)
            for (int i=n-1; i>0; i--) {
                long count = fac;
                while (count < k) {
                    // rest(index)는 해당 자리의 주인이 아님. 따라서, 해당자리의 주인은 더 큰 값이다.
                    k -= count;
                    index++;
                }
                // rest(index)는 해당 자리의 주인이므로 정답에 추가하고 rest에서 제외시킨다.
                answer += rest.get(index) + " ";
                rest.remove(index);
                // 해당 자리의 값이 확정되었으므로, 다음 자리의 값을 같은 방식으로 구한다.
                index = 0; // 각 자리의 값은 최소값부터 가정해 시작해야 하므로 초기화 해준다.
                fac /= i; // 남은 자리 factorial 다시 구하지 않고 나눔
            }
            answer += rest.getLast();
            System.out.println(answer);
        }else {
            long answer = 0;
            for (int i=n-1; i>0; i--) {
                int find = sc.nextInt();

                while (rest.get(index) < find) {
                    answer += fac;
                    index++;
                }
                rest.remove(index);
                index = 0;
                fac /= i;
            }
            System.out.println(answer + 1);
        }
    }

    private long factorial(long i) {
        if (i<=1) return 1;
        return i * factorial(i-1);
    }
}
