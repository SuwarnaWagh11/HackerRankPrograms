package LeetCode.Easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Initialize Hashmap -> iterate through the array -> find out the difference = target - nums[i] -> check is map containsKey differnce
if no -> put the current value & its index in map. map.put(nums[i], i)
if yes -> return the new int[] with already found diff values index and current index i.e. map.get(diff), i
*/
public class A001_TwoSum_Test {
    @Test
    public void test118() {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(nums));
        int target = 9;
        int[] indices = twosum(nums, target);
        System.out.println(Arrays.toString(indices));

        int[] indices1 = twoSumWithHashMap(nums, target);
        System.out.println(Arrays.toString(indices1));
    }

    private static int[] twoSumWithHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static int[] twosum(int[] nums, int target){
        int end = nums.length;
        for(int i = 0; i < end - 1; i++){
            for(int j = i + 1; j < end; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
