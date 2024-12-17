package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,2,4,1,3};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void bubbleSorting(int[] a) {
        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j < a.length-i-1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
