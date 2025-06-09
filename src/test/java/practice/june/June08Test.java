package practice.june;



import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class June08Test {

    /* Problem stmt: try shifting arr by 1 position
       save first element in temp
       iterate thr' arr till last element
       put temp at-last
       at last try shifting arr by any no. of position
    */
    @Test
    public void testForRotateArray(){
        int[] arr = {5,3,6,2,4,8};
        rotated(arr, 3);

    }

    private void rotated(int[] arr, int n) {
        while(n > 0){
            int temp = arr[0];
            for(int i = 0; i < arr.length -1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length -1] = temp;
            n--;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
