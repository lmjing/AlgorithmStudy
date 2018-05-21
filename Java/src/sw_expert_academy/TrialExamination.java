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

    //QUIZ : num4012 요리사
    //NOTE : 1시간 15분 걸림
    static class Num4012 {
        static int min;
        static int N;
        static int allFoodTaste;
        static int[][] synergy;
        public static void main() {
            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int test_case = 1; test_case <= T; test_case++) {
                min = 99999999;
                N = sc.nextInt();
                synergy = new int[N][N];
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        synergy[i][j] = sc.nextInt();
                        allFoodTaste += synergy[i][j];
                    }
                }

                int half = N/2;
                StringBuilder foods = new StringBuilder("0");
                int[] foodCheck = new int[N];
                makeFood(0, half-1, foods);
                System.out.println("#" + test_case + " " + min);
            }
        }

        static void makeFood(int i, int rest, StringBuilder foods) {
            if(rest == 0) {
                // 음식 구하기
                boolean [] foodCheck = new boolean[N];
                String[] foodsString = foods.toString().split(" ");
                for(int j=0; j<N/2; j++) {
                    int food = Integer.parseInt(foodsString[j]);
                    foodCheck[food] = true;
                }
                int Ataste = 0;
                int Btaste = 0;
                for(int j=0; j<N; j++) {
                    for(int k=0; k<N; k++) {
                        // 같은 그룹일 경우에
                        if(!(foodCheck[j] ^ foodCheck[k])) {
                            if(foodCheck[j]) Ataste += synergy[j][k];
                            else Btaste += synergy[j][k];
                        }
                    }
                }
                int diff = Math.abs(Ataste - Btaste);
                min = diff < min ? diff : min;
                return;
            }

            //조합의 경우 다 구하기
            for(int j=i+1; j<N; j++) {
                StringBuilder newFoods = new StringBuilder(foods);
                makeFood(j, rest-1, newFoods.append(" " + j));
            }
        }
    }

    //QUIZ : num4008 숫자 만들기
    //NOTE : 1시간 걸림 - 더 빨리 할 수 있었는데 다음 순열 만드는법을 헷갈림
    static class Num4008 {
        static int max;
        static int min;

        public static void main() {
            Scanner sc = new Scanner(System.in);
            int T;
            T=sc.nextInt();

            for(int test_case = 1; test_case <= T; test_case++) {
                int N = sc.nextInt();
                int[] operators = new int[N-1];
                int[] nums = new int[N];

                int idx = 0;
                for(int i=0; i<4; i++) {
                    int n = sc.nextInt();
                    for(int j=0; j<n; j++) operators[idx++] = i;
                }
                for(int i=0; i<N; i++) nums[i] = sc.nextInt();

                max = -100000001;
                min = 100000001;
                do {
                    int result = nums[0];
                    for(int i=0; i<N-1; i++) {
                        result = cal(operators[i], result, nums[i+1]);
                    }
                    max = max < result ? result : max;
                    min = min > result ? result : min;
                }while(next_per(operators));
                System.out.println("#" + test_case + " " + (max-min));
            }
        }

        static int cal(int oper, int i, int j) {
            switch(oper) {
                case 0: return i+j;
                case 1: return i-j;
                case 2: return i*j;
                case 3: return i/j;
                default: return 0;
            }
        }

        static boolean next_per(int[] per) {
            int i = per.length-1;
            while(i>0 && per[i-1] >= per[i]) i--;
            if(i == 0) return false;

            int j = per.length-1;
            while(j>=0 && per[i-1] >= per[j]) j--;
            swap(per, i-1, j);
            for(int k=per.length-1; k>i; i++, k--) {
                swap(per, k, i);
            }

            return true;
        }

        static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
