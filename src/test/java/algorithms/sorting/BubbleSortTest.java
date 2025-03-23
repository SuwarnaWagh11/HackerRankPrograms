package algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
/*Compare first 2 elements and if 1st is greater than 2nd then swap.
* First for loop which will iterate through each element till the last element
* Second for loop will start from 0 till length-i-1 so that it will swap and the sorted element will save at last place
* when the loop will iterate it should not check the recently sorted element which places in the last/second/third last position using length-i-1*/
public class BubbleSortTest {
    @Test
    public void test11() {
        int[] arr = {8,2,4,1,3};
        BubbleSortTest bubbleSort = new BubbleSortTest();
        bubbleSort.bubbleSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void bubbleSorting(int[] a) {
        for(int i = 0; i < a.length-1; i++){
            System.out.println(a.length-1 + "-- "+ (a.length-i-1));
            for(int j = 0; j < a.length-i-1; j++){
                if(a[j] > a[j+1]){
                    System.out.println(a[j] +" and "+ a[j+1]);
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
