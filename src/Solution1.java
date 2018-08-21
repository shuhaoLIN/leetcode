/**
 * Created by lenovo on 2018/7/31.
 */
import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution1{


    public int[] twoSum(int[] nums, int target) {
        int[] result =new int[2];
        Map<Integer ,Integer> map = new HashMap<Integer ,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int compare = target - nums[i];
            if(map.containsKey(compare) && map.get(compare) != i){
                result[0] = i;
                result[1] = map.get(compare);
                break;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        Solution1 s = new Solution1();
        s.twoSum(nums,target);
    }
}
