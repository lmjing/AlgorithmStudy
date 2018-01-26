package baekjoon.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        Alphabet alphabet = new Alphabet(r, c);
        for (int i=0; i<r; i++) {
            br.read(alphabet.map[i]);
            br.readLine();
        }
        alphabet.go(0, 0, new LinkedHashSet<>(), 0);
        System.out.println(alphabet.max);
    }

    static class Alphabet {
        char[][] map;
        int max;

        public Alphabet(int r, int c) {
            map = new char[r][c];
        }

        public void go(int x, int y, Set<Character> visited, int count) {
            visited.add(map[x][y]);
            count++;

            if (x-1 >= 0 && !visited.contains(map[x-1][y])) go(x-1, y, new LinkedHashSet<>(visited), count);
            if (x+1 < map.length && !visited.contains(map[x+1][y])) go(x+1, y, new LinkedHashSet<>(visited), count);
            if (y-1 >= 0 && !visited.contains(map[x][y-1])) go(x, y-1, new LinkedHashSet<>(visited), count);
            if (y+1 < map[0].length && !visited.contains(map[x][y+1])) go(x, y+1, new LinkedHashSet<>(visited), count);

            max = max < count ? count : max;
        }
    }
}