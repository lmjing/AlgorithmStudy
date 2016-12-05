package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mijeong on 2016. 12. 2..
 * 시간 복잡도 O(n^2) 버블 / 삽입 / 선택 정렬
 */
public class num2751 {
    public static void main(String[] args){
        /* 입력 받기 */
        Scanner stdin = new Scanner(System.in);
        int cnt = stdin.nextInt();
        int[] array = new int[cnt];
        int[] original = array;

        for(int i=0;i<cnt;i++)
            array[i] = stdin.nextInt();

        /* 2751번 */

        Hard hard = new Hard();
        hard.merge_sort(array,0,array.length-1);
        System.out.println("merge sort 결과");
        hard.print_array(array);
    }
}

class Hard{
    void print_array(int[] array){
        for(int a:array)
            System.out.println(a);
    }

    void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void merge_sort(int[] array,int start,int end){
        if(start<end){
            int center = (end+start)/2;
            merge_sort(array,start,center);
            merge_sort(array,center+1,end);

            merge(array,start,center+1,end);
        }
    }

    void merge(int[] array,int start,int center,int end){
        int[] a = new int[center-start];
        int[] b = new int[end-center+1];
        System.arraycopy(array, start, a, 0, a.length);
        System.arraycopy(array, center, b, 0, b.length);
        int i=0,j=0;
        for(int k=start;k<=end;k++){
            if(i==a.length){
                System.arraycopy(b, j, array, k, b.length-j);
                break;
            }else if(j==b.length){
                System.arraycopy(a, i, array, k, a.length-i);
                break;
            }else{
                if(a[i]>b[j]) array[k] = b[j++];
                else array[k] = a[i++];
            }
        }
    }

    void heap_sort(int[] arr){
        for(int i=0;i<arr.length;i++){
        }

    }
}

class Heap{
    int[] heap_arr;

    Heap(int length){
        heap_arr = new int[length];
    }

    void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void sort(int pointer,int data){
        int origin = pointer;
        heap_arr[pointer] = data;
        while (heap_arr[(pointer-1)/2]>data&&((pointer-1)/2)>0){
            swap(heap_arr,pointer,(pointer-1)/2);
            pointer = (pointer-1)/2;
        }
        while ((heap_arr[pointer*2+1]<heap_arr[pointer]||heap_arr[pointer*2+2]<heap_arr[pointer])&&pointer<origin){
            if(heap_arr[pointer*2+1]>heap_arr[pointer]) {
                swap(heap_arr,pointer,pointer*2+1);
                pointer = pointer*2+1;
            }else if(heap_arr[pointer*2+2]>heap_arr[pointer]){
                swap(heap_arr,pointer,pointer*2+2);
                pointer = pointer*2+2;
            }
        }
    }

    int print_heap(){
        int result = heap_arr[0];
        heap_arr[0] = -1;
        int idx = 0;
        return result;
    }
}