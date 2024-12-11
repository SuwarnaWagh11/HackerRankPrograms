package algorithms.searching;

public class LastOccurranceOfElement {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5,5,6,6,7,7,7,8,8,8,8,8,9,10};
        int res = lastOccerrence(a, 0, a.length, 8);
        System.out.println("Found last occurrance of element at index "+ res);//16
    }

    private static int lastOccerrence(int[] arr, int start, int end, int num) {
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
