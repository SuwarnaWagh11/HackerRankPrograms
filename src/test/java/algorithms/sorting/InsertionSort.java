package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8,2,4,1,3};
        InsertionSort sort1 = new InsertionSort();
        sort1.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void insertionSort(int[] a) {
        for(int i = 1; i < a.length; i++){
            int current = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > current){
                a[j+1]= a[j];
                j--;
            }
            a[j+1] = current;
        }
    }
}
