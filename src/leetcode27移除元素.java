/**
 * Created by lenovo on 2018/8/23.
 */
public class leetcode27移除元素 {
    //答案中的6ms
    public int removeElement(int[] nums, int val,int ans2) {
        if (nums == null) {
            return -1;
        }
        int length = nums.length;
        int index = nums.length - 1;

        for (int i = 0; i < length; ) {
            if (nums[i] == val) {
                while (index > i && nums[index] == val) {
                    index --;
                    length --;
                }
                if (index != i) {
                    nums[i] = nums[index];
                    nums[index] = val;
                    index --;
                }
                length --;
            } else {
                i ++;
            }
        }
        return length;
    }
    //答案中的5ms
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;
        int len = 0, i=0,j=nums.length-1;
        while(i<=j){
            if(nums[i] != val){
                i++;
                len++;
            }else{
                nums[i] = nums[j];
                j--;
            }
        }
        return len;
    }
}
