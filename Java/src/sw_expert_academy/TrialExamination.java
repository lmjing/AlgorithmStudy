package sw_expert_academy;

import java.util.*;

public class TrialExamination {
    //QUIZ : num4014 활주로 건설
    //NOTE : 1시간 5분 걸림
    static class Group {
        LinkedList<Area> areas = new LinkedList<>();

        public void add(int h) {
            if(!areas.isEmpty() &&areas.getLast().height == h) areas.getLast().count++;
            else areas.add(new Area(h));
        }
        public int getCount() {
            return areas.size();
        }
    }
    static class Area {
        int count = 0;
        int height;

        public Area(int h) {
            height = h;
            count++;
        }
    }

    public static void num4014_main() {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            sc.nextLine();
            int N = sc.nextInt();
            int X = sc.nextInt();
            //0 가로, 1 세
            Group[][] map = new Group[2][N];

            //input
            for(int i=0; i<N; i++) {
                sc.nextLine();
                map[0][i] = new Group();
                for(int j=0; j<N; j++) {
                    int height = sc.nextInt();
                    map[0][i].add(height); // 가로
                    if(map[1][j] == null) map[1][j] = new Group();
                    map[1][j].add(height); // 세로
                }
            }

            int result = 0;
            for(int i=0; i<N; i++) {
                result += ableCheck(map[0][i], X) ? 1 : 0;
                result += ableCheck(map[1][i], X) ? 1 : 0;
            }
            System.out.println("#" + test_case + " " + result);
        }
    }

    static boolean ableCheck(Group g, int X) {
        Area before = g.areas.getFirst();
        for(int i=1; i<g.getCount(); i++) {
            Area current = g.areas.get(i);
            if(Math.abs(before.height - current.height) == 1) {
                Area small = before.height > current.height ? current : before;
                if(small.count >= X) small.count -= X;
                else return false;
            }else return false;
            before = current;
        }
        return true;
    }

    //QUIZ : num4013 특이한 자석
    //NOTE : 1시간 17분 걸림
    public static void num4013_main() {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int K = sc.nextInt();
            int[][] input = new int[4][8];
            int[] directArray = new int[4];
            for(int i=0; i<4; i++) {
                for(int j=0; j<8; j++) {
                    input[i][j] = sc.nextInt();
                }
            }
            for(int i=0; i<K; i++) {
                int mag = sc.nextInt() - 1;
                int direct = sc.nextInt();
                int[] moveD = new int[4];
                moveD[mag] = direct;

                //왼
                int j = mag;
                while(--j >= 0) {
                    int r = (8+2-directArray[j]) % 8;
                    int l = (8+6-directArray[j+1]) % 8;
                    int left = input[j][r]; int right = input[j+1][l];
                    if(left != right) {
                        moveD[j] = moveD[j+1] * -1;
                    }else break;
                }
                //오
                j = mag;
                while(++j < 4) {
                    int r = (8+2-directArray[j-1]) % 8;
                    int l = (8+6-directArray[j]) % 8;
                    int left = input[j-1][r]; int right = input[j][l];
                    if(left != right) {
                        moveD[j] = moveD[j-1] * -1;
                    }else break;
                }
                for(int k=0; k<4; k++)
                    directArray[k] += moveD[k];
            }

            int score = 0;
            for(int i=0; i<4; i++) {
                int arrow = (-directArray[i] + 8) % 8;
                if(input[i][arrow] == 1) {
                    score += Math.pow(2, i);
                }
            }
            System.out.println("#" + test_case + " " + score);
        }
    }
}
