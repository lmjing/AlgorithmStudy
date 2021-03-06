package baekjoon.algoStudy.chapter2_brute_force_search1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Chapter3 {
    public void num1476() {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        int[] esm = {15, 28, 19};
        for (int i=0; i<3; i++) {
            input[i] = sc.nextInt();
            if (input[i] == esm[i]) input[i] = 0;
        }

        for (int i=0; i<=15*29; i++) {
            int n = 28 * i + input[1];
            if (n % 15 == input[0] && n % 19 == input[2]) {
                System.out.println(n > 0 ? n : 15*28*19);
                break;
            }
        }
    }

    public void num1107_fail1() {
        // 짧게 풀려다가 복잡해져서 망한 케이스
        LinkedList<Integer> enableKeys = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            enableKeys.add(i);
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int inputNum = Integer.parseInt(input);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            enableKeys.remove(Integer.valueOf(sc.nextInt()));
        }
        // 가까운 수로 접근하는 방식
        int answer = nearNumber(input, inputNum, enableKeys);
        // -1이면 모두 번호로 입력 가능
        if (answer == -1) answer = input.length();
        // +,- 버튼으로 가는게 젤 빠를 경우 변경
        answer = answer > Math.abs(inputNum - 100) ? Math.abs(inputNum - 100) : answer;

        System.out.println(answer);
    }

    private int largeOfSu(LinkedList<Integer> enableKeys, int index, int rest, String nearNum) {
        String numStr = "";
        if (enableKeys.size() <= index) {
            int front = nearNum.length() > 0 ? Integer.parseInt(nearNum) + 1 : 1;
            numStr += front;
            numStr += enableKeys.getFirst();
        }else numStr = nearNum + enableKeys.get(index);
        for (int i=0; i<rest; i++) numStr += enableKeys.getFirst();
        return Integer.parseInt(numStr);
    }

    private int smallOfSu(LinkedList<Integer> enableKeys, int index, int rest, String nearNum) {
        String numStr = "";
        for (int i=0; i<rest; i++) numStr += enableKeys.getLast();
        if (0 <= index - 1) {
            numStr = nearNum + enableKeys.get(index - 1) + numStr;
        }
        return Integer.parseInt(numStr);
    }

    private int nearNumber(String input, int inputNum, LinkedList<Integer> enableKeys) {
        if (enableKeys.isEmpty()) return 9999999;
        String nearNumStr = "";
        String[] inputArray = input.split("");
        for (int i = 0; i < input.length(); i++) {
            int su = Integer.parseInt(inputArray[i]);

            int index = 0;
            boolean findFlag = false;
            for (index = 0; index < enableKeys.size(); index++) {
                int find = enableKeys.get(index);
                if (find == su) {
                    findFlag = true;
                    break;
                }
                if (find > su) break;
            }

            if (findFlag) {
                nearNumStr += su;
                continue;
            }

            int rest = input.length() - (i + 1);
            int nearLarge = largeOfSu(enableKeys, index, rest, nearNumStr);
            int nearSmall = smallOfSu(enableKeys, index, rest, nearNumStr);
            int nearNum = Math.abs(inputNum - nearLarge) < Math.abs(inputNum - nearSmall) ?
                    nearLarge : nearSmall;
            return Integer.toString(nearNum).length() + Math.abs(inputNum - nearNum);
        }
        return -1;
    }

    static boolean[] ableKeys = new boolean[10];
    static int input = 0;
    public void num1107_fail2() {
        // 알고리즘 풀이 방법 활용해서 했는데 안되는 반례를 못찾겠음
        Scanner sc = new Scanner(System.in);
        input = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++) {
            ableKeys[sc.nextInt()] = true;
        }

        int choose = input;
        //1. 번호만 눌러서 가는 경우
        int answer = possible(input);
        if (n == 10) choose = 100;
        else if (answer == 0) {
            // 바로 채널을 이동 할 수 없는 경우 근접한 수를 찾는다.
            int large = input+1;
            while (possible(large) == 0) large++;

            int small = input-1;
            while (possible(small) == 0) small--;

            choose = Math.abs(large - input) < Math.abs(small - input) ? large : small;
        }
        choose = Math.abs(choose - input) < Math.abs(100 - input) ? choose : 100;
        answer = possible(choose);
        // 정답 : choose(눌리는 근접한 수)의 자리수 + | choose - input |
        answer += Math.abs(choose - input);
        System.out.println(answer);
    }

    public void num1107_answer() {
        // PDF에 C++ 답보고 따라한거임 더 빠른 방법 있을 것 같은데 뭔지 모르겠음
        Scanner sc = new Scanner(System.in);
        input = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        for (int i=0; i<n; i++) {
            ableKeys[sc.nextInt()] = true;
        }

        int answer = Math.abs(input - 100);
        for (int i=0; i<=1000000; i++) {
            int len = possible(i);
            if (len > 0) {
                int temp = len + Math.abs(i - input);
                if (answer > temp) answer = temp;
            }
        }
        System.out.println(answer);
    }


    private int possible(int n) {
        if (n == 0) return ableKeys[0] ? 0 : 1;
        int len = 0;
        while (n > 0) {
            if (ableKeys[n % 10]) return 0;
            len++;
            n /= 10;
        }
        return len;
    }

    public static void num9095() {
        // 몇 개 되지 않아 미리 다 해 구해놓음
        // countArray에는 n을 만들기 위해 필요한 개수 저장하는 공간
        // n이 양수기 때문에 0에는 접근할 일이 없고 0은 예외적으로 1로 함. 이유는 아래에 설명
        int[] countArray = new int[11];
        countArray[0] = 1;
        countArray[1] = 1;

        for (int n=2; n<11; n++) {
            // 작은 값 부터 시작하기 때문에 아래 count 함수에서 n-i에 접근하는데 문제가 없다.
            count(countArray, n);
        }

        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        for (int i=0; i<count; i++) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(countArray[n]);
        }
    }

    static void count(int[] countArray, int n) {
        int sum = 0;
        for (int i=1; i<=3 && i<=n; i++) {
            // n을 만들 때 맨 앞자리가 i라고 가정하면 n-i을 만들기 위해 필요한 값은 countArray[n-i]에 저장되어 있으니깐 써먹음
            // 앞이 i로 채워졌기 때문에 예를 들어 n = 2; 이고 i = 2;일때 2로만 나타낼 수 있을 것
            // 즉, 앞에 i로 이미 채워 졌기 때문에 countArray[0]이 될 경우 [0]은 1로 예외적으로 저장시킨다.
            sum += countArray[n-i];
        }
        countArray[n] = sum;
    }

    static void num10971_dfs() {
        //USE : DFS, DP (전부다 갈 수 있는지 확인하고 전부 방문한 최소값 구하기) - TSP
        //NOTE : PPT에는 순열로 구했는데 나는 DP, 로직은 짰는데 사소한거에서 실수 너무 많이한다. 예외처리 잘하자.
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Num10971 num10971 = new Num10971(n);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                num10971.setCost(i, j, sc.nextInt());
            }
            sc.nextLine();
        }
        num10971.visited[0] = true;
        num10971.go(0, 1, 0);
        System.out.print(num10971.min);
    }

    public static class Num10971 {
        public int n;
        public int[][] cost;
        public int min;
        private boolean[] visited;

        public Num10971(int n) {
            this.n = n;
            this.cost = new int[n][n];
            this.min = 999999999;
            this.visited = new boolean[n];
        }

        public void setCost(int i, int j, int c) {
            cost[i][j] = c;
        }

        private void go(int c, int count, int sum) {
            if (min <= sum) return;
            if (count == n) {
                if (cost[c][0] > 0) min = Math.min(min, sum + cost[c][0]);
                return;
            }

            for (int i=0; i<n; i++) {
                if (visited[i]) continue;
                if (cost[c][i] == 0) continue;

                visited[i] = true;
                go(i, count+1, sum + cost[c][i]);
                visited[i] = false;
            }
        }
    }
}
