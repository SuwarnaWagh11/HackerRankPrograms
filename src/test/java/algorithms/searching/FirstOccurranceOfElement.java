package algorithms.searching;

public class FirstOccurranceOfElement {
    public static void main(String[] args) {
        int[] a = {11,15,16,18,18,18,19,19,111};
        int res1 = firstOccurrence(a, 0, a.length,18);
        System.out.println("first occurrence of the element is at index "+ res1);
     }

    private static int firstOccurrence(int[] arr, int start, int end, int num) {
        int res = -1;
        while(start <= end){
             int mid = start + (end - start) / 2;
             if(arr[mid] == num){
                 res = mid;
                 end = mid - 1;
             } else if (arr[mid] > num) {
                 end = mid - 1;
             } else {
                 start = mid + 1;
             }
        }
        return res;
    }

}
