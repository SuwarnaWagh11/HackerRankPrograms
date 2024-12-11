package algorithms.searching;

public class BinarySearchReverseOrder {
    public static void main(String[] args) {
        int[] arr = {12,11,10,9,8,7,6,5,4,3,2,1,0};
        int res = reverseBinarySearchMethod(arr, 0, arr.length - 1, 8);
        if(res == -1){
            System.out.println("Number not found");
        }else System.out.println("Number found at index "+res);
    }

    private static int reverseBinarySearchMethod(int[] arr, int start, int end, int number) {
        if(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == number){
                return mid;
            }
            if (arr[mid] < number){
                return reverseBinarySearchMethod(arr, start, mid - 1, number);
            }else return reverseBinarySearchMethod(arr, mid + 1, end, number);
        }
        return -1;
    }
}
