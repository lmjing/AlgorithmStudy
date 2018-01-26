package baekjoon.algoStudy.chapter2_brute_force_search1;

import baekjoon.algoStudy.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

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
}
