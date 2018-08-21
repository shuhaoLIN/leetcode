/**
 * Created by lenovo on 2018/8/14.
 */
public class leetcode4两个排序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        //int min = nums1.length < nums2.length ? nums1.length : nums2.length;
        int[] result = new int[len];
        int i=0,j=0;
        for(;i<nums1.length && j<nums2.length;){
            if(nums1[i] < nums2[j]){
                result[i+j] = nums1[i];
                i++;
            }
            else {
                result[i+j] = nums2[j];
                j++;
            }
        }
        if(i == nums1.length){
            for(;j<nums2.length;j++){
                result[i+j] = nums2[j];
            }
        }
        else {
            for(;i<nums1.length;i++){
                result[i+j] = nums1[i];
            }
        }
        if((len % 2) == 0){
            //双数
            return (double)((double)result[len/2] + (double)result[len/2 -1])/2;
        }
        else{
            //单数
            return (double)result[len/2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {0};
        leetcode4两个排序数组的中位数 lt = new leetcode4两个排序数组的中位数();
        System.out.println(lt.findMedianSortedArrays(nums1,nums2));
    }
}
