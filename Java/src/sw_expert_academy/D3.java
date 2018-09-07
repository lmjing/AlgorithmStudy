package sw_expert_academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D3 {
    public static void num2386() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (list.contains(num))
                    list.remove(Integer.valueOf(num));
                else
                    list.add(num);
            }
            System.out.println("#" + t + " " + list.size());
        }
    }

    // 거듭제곱
    public static void square_question() {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<10; i++) {
            int t = Integer.parseInt(sc.nextLine());
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            System.out.println("#" + t + " " + square(n,m));
        }
    }
    
    static int square(int n, int m) {
        if(m==1) return n;
        return n * square(n, m-1);
    }

    //Magnetic
    public static void num1220() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=1; i<11; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[][] map = new char[n][n];
            StringBuilder[] col = new StringBuilder[n];
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    if(col[k] == null) col[k] = new StringBuilder();
                    String temp = st.nextToken();
                    if(!temp.equals("0"))col[k].append(temp);
                }
            }

            int sum = 0;
            for(int j=0; j<n; j++) {
                StringBuilder str = col[j];
                int len = str.length();

                int ni = 0; int mi = len-1;
                while(ni<len && str.charAt(ni) == '2') ni++;
                while(mi>=0 && str.charAt(mi) == '1') mi--;
                if(ni >= mi) continue;

                int count = 0;
                char before = str.charAt(ni);
                for(int k=ni+1; k<=mi; k++) {
                    if(str.charAt(k) == '2' && before != '2') count++;
                    before = str.charAt(k);
                }
                sum += count;
            }
            System.out.println("#" + i + " " + sum);
        }
    }

    //GNS
    // NOTE: 세상에 너무 쉬운 문제였는데 이걸 오래 걸림 반성해라. 그리고 #1, #2 답 사이에 \n넣으니깐 에러였음 output은 \n있었는데 멘붕

    // BEFORE: 무조건 정렬해야한다는 생각으로 qsort 직접 구현함.
    // AFTER: 생각해보니깐 0~10수이니깐 count 세서 index로 접근하면 끝날일이였음
    public static void num1221() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        String[] numbers = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
        HashMap<String, Integer> numberMap = new HashMap<>();
        for(int i=0; i<10; i++) {
            numberMap.put(numbers[i], i);
        }

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            String testCase = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] count = new int[10];
            for(int j=0; j<n; j++) {
                count[numberMap.get(st.nextToken())]++;
            }
            System.out.println("#"+(i+1));
            for(int j=0; j<10; j++) {
                String s = numbers[j];
                for(int jj=0; jj<count[j]; jj++)
                    System.out.print(s + " ");
            }
        }
    }

    // TODO: 성공한지 안한지 모름 관련 문제 있을경우 TEST 해보기
    private static void qsort(int left, int right, int[] arr) {
        if(left >= right) return;

        int pivot = left;
        int l = left+1; int r = right;

        while(l<r) {
            while(l <= right && arr[pivot] > arr[l]) l++;
            while(r >= l && arr[pivot] <= arr[r]) r--;
            if(l<r) swap(l, r, arr);
        }
        if(arr[r] < arr[pivot]) swap(r, pivot, arr);

        qsort(left, r-1, arr);
        qsort(r+1, right, arr);
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
