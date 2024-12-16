package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,1,4,0,6,3};
        SelectionSort sort1= new SelectionSort();
        sort1.selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void selection(int[] a) {
        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }
}
