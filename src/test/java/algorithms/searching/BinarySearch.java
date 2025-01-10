package algorithms.searching;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        List<Integer> arr = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13).collect(Collectors.toList());
        int res = iterativeMethodBinarySearchSearch(a, 20, 0, a.length-1);
        int res1 = recursiveMethodBinarySearch(a, 20, 0, a.length-1);
        int res2 = Collections.binarySearch(arr, 20);
        if (res == -1){
            System.out.println("Number not found in the array");
        }else System.out.println("found the number at index ["+ res +"]");

        if (res1 == -1){
            System.out.println("Number not found in the array");
        }else System.out.println("found the number at index ["+ res1 +"]");

        if (res2 < 0){
            System.out.println("Number not found in the array");
        }else System.out.println("found the number at index ["+ res2 +"]");
    }

    public static int iterativeMethodBinarySearchSearch(int arr[], int numberToFind, int start, int end){
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == numberToFind){
                return mid;
            } else if (arr[mid] > numberToFind) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return -1;
    }

    /*  Time Complexity: O(log N)
        Space Complexity: O(1). If we consider the recursive call stack, the auxiliary space will be O(log N)
    */
    public static int recursiveMethodBinarySearch(int arr[], int numToFind, int start, int end){
        if(end >= start){
            int mid = start + (end - start) / 2;
            if(arr[mid] == numToFind){
                return mid;
            } else if (arr[mid] > numToFind) {
                return recursiveMethodBinarySearch(arr, numToFind, start, mid - 1);
            } else {
                return recursiveMethodBinarySearch(arr, numToFind, mid + 1, end);
            }
        }
        return -1;
    }
}
