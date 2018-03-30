package baekjoon.algoStudy.chapter2_brute_force_search1;

import baekjoon.algoStudy.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UsingRecursiveFunction {
    static void num9095() {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(cal(n));
        }
    }

    static int cal(int n) {
        if (n < 1) return 0;
        int sum = 0;
        // 앞자리가 i일 경우
        for (int i=1; i<=3; i++) {
            if (i>=n) {
                sum ++;
                break;
            }
            int diff = n - i;
            sum += cal(diff);
        }
        return sum;
    }

    static void num1759() {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        LinkedList<String> arrayList = new LinkedList<>();
        for (int i=0; i<C; i++) arrayList.add(sc.next());
        Collections.sort(arrayList);
        makePassword(arrayList, 0, 0, L, "", 0);
    }

    static void makePassword(LinkedList<String> arrayList, int count, int i, int L, String str, int vowel) {
        if (count == L) {
            if (vowel >= 1 && L-vowel >= 2) System.out.println(str);
            return;
        }
        if (i >= arrayList.size()) return;

        String s = arrayList.get(i);
        int newVowel = vowel;
        if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) ++newVowel;
        makePassword(arrayList, count + 1, i+1, L, str + s, newVowel);
        makePassword(arrayList, count, i+1, L, str, vowel);
    }

    static int sum = 0;
    static public void num9663() {
        // DIFF: 현재 row에서 접근할 수 있는 가능한 남은 자리(col) & 이전 row의 저장위치(col)저장한 배열 두개 사용
        // NOTE: PDF에 나와있는 일반적인 방식 코드 보지 않음

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 초기 : 가능한 자리는 전부 다니깐 0~n-1까지 배열을 만들어 넘겨준다.
        ArrayList<Integer> restIndexList = new ArrayList<>();
        for (int i=0; i<n; i++) restIndexList.add(i);
        // 이전 배열은 없으니깐 새로 만들어서 넘겨준다.
        calc(0, new ArrayList<>(), restIndexList);
        System.out.println(sum);
    }

    static void calc(int row, ArrayList<Integer> beforeRowList, ArrayList<Integer> restIndexList) {
        // 현재 row에서 가능한 자리(col)가 없는 경우 다 채워진 것이므로 경우의 수를 높여주고 끝낸다.
        if (restIndexList.isEmpty()) {
            sum++; return;
        }

        // 1차적으로 가능한 자리(남은 자리)가 대각선에서 겹치는 경우가 있는지 일일히 확인한다.
        for (int i : restIndexList) {
            boolean available = true;
            for (int before = 0; before < row; before++) {
                // 대각선에서 겹치는 경우 = 이전 행의 자리와 현재 행의 자리의 차와 이전 행과 현재 행의 차이가 같으면 대각선이다.
                if (Math.abs(beforeRowList.get(before) - i) == Math.abs(before - row)) {
                    available = false; break;
                }
            }
            /*
             대각선으로 겹치지 않는 경우 현재 자리가 가능하단 뜻이므로
             남은 가능한 자리에서 현재 자리를 제외하고
             이전 row의 저장위치 배열에 현재 자리를 저장한다.
             NOTE : JAVA 특성상 그냥 복사하면 얕은 배열로 되어 깊은 복사 방식으로 새로 만들어 넘겨주었다.
              */
            if (available) {
                ArrayList<Integer> newBeforeRowList = (ArrayList<Integer>) beforeRowList.clone();
                newBeforeRowList.add(i);
                ArrayList<Integer> newRestIndexList = (ArrayList<Integer>) restIndexList.clone();
                newRestIndexList.remove(Integer.valueOf(i));
                calc(row + 1, newBeforeRowList, newRestIndexList);
            }
        }
    }

    static void num1987() throws IOException {
        // NOTE : 시간초과 -> 수정 후 맞음
        // NOTE : 시도 횟수 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        Alphabet alphabet = new Alphabet(r, c);
        for (int i=0; i<r; i++) {
            br.read(alphabet.map[i]);
            br.readLine();
        }
        alphabet.go(0, 0, new boolean[26], 0);
        System.out.println(alphabet.max);
    }

    static class Alphabet {
        char[][] map;
        int max;

        public Alphabet(int r, int c) {
            map = new char[r][c];
        }

        public void go(int x, int y, boolean[] visited, int count) {
            visited[(int)map[x][y]-65] = true;
            count++;

            // BEFORE : 방문한 글자 Set에 저장해서 contains로 확인함 -> contains로 확인할 때 마다 O(N) 시간 소요 => 시간 초과
            // AFTER : 알파벳은 26글자로 제한적이라는 특징 이용 -> 26개의 배열 확인 -> index로 접근해 방문 여부 확인 => 성공
            if (x-1 >= 0 && !visited[map[x-1][y]-65]) go(x - 1, y, deepCopyArray(visited), count);
            if (x+1 < map.length && !visited[map[x+1][y]-65]) go(x+1, y, deepCopyArray(visited), count);
            if (y-1 >= 0 && !visited[map[x][y-1]-65]) go(x, y-1, deepCopyArray(visited), count);
            if (y+1 < map[0].length && !visited[map[x][y+1]-65]) go(x, y+1, deepCopyArray(visited), count);

            max = max < count ? count : max;
        }

        private boolean[] deepCopyArray(boolean[] before) {
            boolean[] newArray = new boolean[before.length];
            System.arraycopy(before, 0, newArray, 0, before.length);
            return newArray;
        }
    }

    static class num1182 {
        // NOTE : 시도 횟수 1
        // NOTE : 주의 사항 - s가 0인 경우 아래 로직대로 하면 전체다 포함되지 않아 sum = 0 으로 동일해지는 경우 count++ 가 된다.
        // DIFF : 위의 주의사항을 PDF는 s=0인 경우 정답 -1하고 나는 그냥 재귀함수에 공집합인지 아닌지의 여부를 boolean으로 확인 함
        int[] input;
        int n;
        int s;
        void main() {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            s = sc.nextInt();
            sc.nextLine();
            input = new int[n];
            for (int i=0; i<n; i++) input[i] = sc.nextInt();
            System.out.println(getCount(0, 0, false));
        }

        int getCount(int i, int sum, boolean zeroCheck) {
            if (i >= n) return sum == s && zeroCheck? 1 : 0;
            return getCount(i+1, sum, zeroCheck) + getCount(i+1, sum+input[i], true);
        }
    }

    static void num6603() {
        // NOTE : 시도횟수 1
        // BEFORE : 나는 포함하지 않는 것 부터 호출해서 사전순 반대로 출력됨, 그래서 따로 배열을 만들어서 저장한 후 뒤에서 부터 출력하는 귀찮은 짓을 함
        // AFTER : PDF 참고 -> 나를 포함할 경우부터 호출하면 사전순으로 호출된다.
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            int[] array = new int[k];
            for (int i=0; i<k; i++) array[i] = sc.nextInt();
            sc.nextLine();
            makeLotto(array, 0, new StringBuffer(""), 0);
            System.out.println();
        }
    }

    static void makeLotto(int[] array, int i, StringBuffer lotto, int j) {
        if (j == 6) {
            System.out.println(lotto);
            return;
        }
        if (i >= array.length) return;

        StringBuffer newLotto = new StringBuffer(lotto);
        newLotto.append(array[i] + " ");
        makeLotto(array,i+1, newLotto, j+1);
        makeLotto(array,i+1, lotto, j);
    }

    static void num2580() {
        Scanner sc = new Scanner(System.in);
        Sudoku sudoku = new Sudoku();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                sudoku.init(i, j, sc.nextInt());
            }
            sc.nextLine();
        }

        sudoku.find(new LinkedList<>(sudoku.queue));
    }

    public static class Sudoku {
        // 0 : 가로, 1 : 세로, 2 : 네모
        public boolean[][][] check = new boolean[3][9][9];
        public int [][] sudoku = new int[9][9];
        private int count = 0;
        public Queue<Integer> queue = new LinkedList<>();

        public void init(int i, int j, int vaule) {
            sudoku[i][j] = vaule;
            if (vaule == 0) {
                queue.add(i*10 + j);
                count++;
            }else {
                vaule--; // 0~8인데 입력값은 1~9라서 하나 줄임
                check[0][i][vaule] = true;
                check[1][j][vaule] = true;
                check[2][(i/3)* 3 + j/3][vaule] = true;
            }
        }

        //TODO: queue 복사시간 걸리니깐, List에 저장하고 매개변수에 index 전달해서 다음 index -> 안해도 통과함
        //BEFORE: 그냥 return으로 하면 가능한거 전부다 출력해버림
        public boolean find(Queue<Integer> queue) {
            if (count == 0) {
                for (int i=0; i<9; i++) {
                    StringBuilder res = new StringBuilder();
                    for (int j=0; j<9; j++) {
                        res.append(sudoku[i][j] + " ");
                    }
                    System.out.println(res);
                }
                return true;
            }

            int blank = queue.remove();
            int x = blank / 10, y = blank % 10;
            for (int i=0; i<9; i++) {
                if (!check[0][x][i] && !check[1][y][i] && !check[2][(x/3)*3 + y/3][i]) {
                    sudoku[x][y] = i+1; count--;
                    check[0][x][i] = true; check[1][y][i] = true; check[2][(x/3)*3 + y/3][i] = true;
                    //AFTER: boolean으로 정답 나온 경우 멈춰버림
                    if (find(new LinkedList<>(queue))) break;
                    //NOTE : 얘네 있어야 하는 이유는 만약 가능한게 2개라서 임의로 넣어서 하다가 아니면 그 전단계로 가야하니깐
                    sudoku[x][y] = 0; count++;
                    check[0][x][i] = false; check[1][y][i] = false; check[2][(x/3)*3 + y/3][i] = false;
                }
            }
            return false;
        }
    }
}
