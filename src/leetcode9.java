/**
 * Created by lenovo on 2018/8/12.
 */

import java.util.Arrays;

/**
 * 判断是否为回文数
 * 1.负数肯定不是
 * 2.个位数肯定是
 * 3.（1）换为字符串（2）不换为字符串
 */
public class leetcode9 {
    public boolean isPalindrome(int x,int an1) {
        if(x < 0){
            return false;
        }
        else if(x < 10){
            return true;
        }
        else{
            //从11开始了
            String mid = x+"";
            for(int i=0;i<mid.length()/2;i++){
                if(mid.charAt(i) != mid.charAt(mid.length() - i -1)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isPalindrome(int x,int an1,int an2) {
        if(x < 0){
            return false;
        }
        else if(x < 10){
            return true;
        }
        else{
            //从11开始了
            String mid = x+"";
            String head = mid.substring(0,mid.length()/2);
            String tail = new String();
            if((mid.length()%2) == 0){
                tail = mid.substring(mid.length()/2);
            }
            else tail = mid.substring(mid.length()/2+1);
            tail =new  StringBuilder(tail).reverse().toString();
            System.out.println(head +"  "+ tail);
            if(head.equals(tail)){
                return true;
            }
            else return false;
        }
    }
    public boolean isPalindrome(int x) {
        // 特殊情况
        //当小于零，尾数为0，都不可能是回文数（除了0）

        if(x < 0 || (x%10 == 0 && x != 0)) {
            return false;
        }
        else{
            //从11开始了
            int reverseNum  = 0;
            while(x > reverseNum){
                reverseNum = reverseNum * 10 + x % 10;
                x /= 10;
            }
//            System.out.println(reverseNum + "  " +x);
            //当数字长度为奇数时，中间位会存在于reverseNum中，
            //只需将其排除掉就好
            return x == reverseNum || x == reverseNum/10;
        }
    }


    //还可以将其重新倒转复制给一个临时值，再比较一下就好
    public boolean isPalindrome(int x,int an1,int an2,int an3) {
        // 特殊情况
        //当小于零，尾数为0，都不可能是回文数（除了0）

        if(x < 0 || (x%10 == 0 && x != 0)) {
            return false;
        }
        else{
            //从11开始了
            int reverseNum  = 0;
            int mid = x;
            while(x > 0){
                reverseNum = reverseNum * 10 + x % 10;
                x /= 10;
            }//不过有可能会出现超界了。
//            System.out.println(reverseNum + "  " +x);
            //当数字长度为奇数时，中间位会存在于reverseNum中，
            //只需将其排除掉就好
            return x == reverseNum || x == reverseNum/10;
        }
    }
    public static void main(String[] args) {
        leetcode9 lc = new leetcode9();
        System.out.println(lc.isPalindrome(10));

    }
}
