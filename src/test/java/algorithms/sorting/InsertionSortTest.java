package algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
/* We are finding the correct position for the element amd inserting them
* take current element (at 1st position)and we will compare it with 0th position element
* how: use for loop to iterate each element starting from 1 till length
* store it in variable - current
* we need to start checking/comparing from 0th element for which we will use j variable by initializing j = i - 1
* and use while loop where j i>= 0 and a[j] > current if yes move it a[j+1] and j--
* store current in a[j+1]*/
public class InsertionSortTest {
    @Test
    public void test11() {
        int[] arr = {8,2,4,1,3};
        InsertionSortTest sort1 = new InsertionSortTest();
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
