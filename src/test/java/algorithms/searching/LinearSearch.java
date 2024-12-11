package algorithms.searching;

public class LinearSearch {

    public static void main(String[] args) {//best time complexity of linear search is O(1)
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int res = linearSearch(a,10);
        if(res == -1){
            System.out.println("Number not found");
        }else System.out.println("Number found at index "+res);
    }

    private static int linearSearch(int[] a, int num) {
        for(int i = 0; i < a.length; i++){
            if(a[i]==num){
                return i;
            }
        }
        return -1;
    }
}
