import java.util.Arrays;

class leetcode3{
    public int lengthOfLongestSubstring(String s) {
        int[] nums = new int[300];
        Arrays.fill(nums,-1);
        int max=0;
        int midmax =0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(nums[s.charAt(i)] == -1){
                nums[s.charAt(i)] = i;
                midmax++;
            }
            else{
                max = Math.max(max,midmax);
                start = Math.max(nums[s.charAt(i)]+1 , start);
                nums[s.charAt(i)] = i;//要重新算起了
                midmax = i - start+1 ;

            }
        }
        max = Math.max(max,midmax);
        return max;
    }
    public static void main(String[] args){
        int max;
        String s = "pwwkew";
        leetcode3 let = new leetcode3();
        max = let.lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}