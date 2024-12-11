package algorithms.searching;

public class CountOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,2,2,2,2,2,3,4,5,5,5,6,6,7,7,7,8,8,8,8,8,9,10};
        int first = firstOccuerrenceOfElement(arr, 0, arr.length - 1, 2);
        int last = lastOccurenceOfElement(arr, 0, arr.length - 1, 2);
        System.out.println("Count of element in the given sorted array is "+ (last - first + 1));
    }

    private static int firstOccuerrenceOfElement(int[] arr, int start, int end, int num) {
        int res = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == num){
                res = mid;
                end = mid - 1;
            } else if (num > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static int lastOccurenceOfElement(int[] arr, int start, int end, int num){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == num){
                res = mid;
                start = mid + 1;
            } else if (num > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
