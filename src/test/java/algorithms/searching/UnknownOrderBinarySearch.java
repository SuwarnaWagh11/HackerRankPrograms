package algorithms.searching;

import java.util.Arrays;

public class UnknownOrderBinarySearch {
    public static void main(String[] args) {
        int[] a = {1,4,2,3,7,11,9,10,5,6,8,20};
        Arrays.sort(a);
        int res = unknownOrderBinarySearch(a, 0, a.length - 1, 1);
        if(res == -1){
            System.out.println("Number not found");
        }else System.out.println("Number found at "+ res);
    }

    private static int unknownOrderBinarySearch(int[] a, int start, int end, int num) {
        if(start <= end){
            int mid = start +(end - start) / 2;
            if(a[mid] == num){
                return mid;
            }
            if (a[mid] < num){
                return unknownOrderBinarySearch(a, mid +1, end, num);
            }else return unknownOrderBinarySearch(a, start, mid - 1, num);
        }
        return -1;
    }
}
