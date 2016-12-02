package sort;

import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 * 시간 복잡도 O(n^2) 버블 / 삽입 / 선택 정렬
 */
public class sort_practice {
    public static void main(String[] args){
        /* 입력 받기 */
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        int[] array = new int[cnt];
        int[] original = array;

        for(int i=0;i<cnt;i++)
            array[i] = stdin.nextInt();

        /* 2751번 */

        Easy easy = new Easy();
        easy.bubblesort(array);
        System.out.println("bubble sort 결과");
        easy.print_array(array);

        array=original;
        easy.select_sort(array);
        System.out.println("select sort 결과");
        easy.print_array(array);

        array=original;
        easy.insert_sort(array);
        System.out.println("insert sort 결과");
        easy.print_array(array);
    }
}

class Easy{
    void print_array(int[] array){
        for(int a:array)
            System.out.println(a);
    }

    void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void bubblesort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1])
                    swap(array,j,j+1);
            }
        }
    }

    void select_sort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int min = i;
            for(int j=i+1;j<array.length;j++){
                if(array[min]>array[j])
                    min=j;
            }
            swap(array,min,i);
        }
    }

    void insert_sort(int[] array){
        for(int i=1;i<array.length;i++){
            int key = array[i];
            int j = i-1;
            while (j>=0&&array[j]>key){
                swap(array,j,j+1);
                j--;
            }
            array[j+1]=key;
        }
    }
}
