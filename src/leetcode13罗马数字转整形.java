/**
 * Created by lenovo on 2018/8/14.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：(1)遍历:将每一个字符拿出来进行判断
 * （2)要一次拿出两个字符进行判断，这样才可以确定是否是特殊情况
 */
public class leetcode13罗马数字转整形 {
    //public char[] ch = {'I','V','X','L','C','D','M'};

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //从尾部开始,然后和前一个数字比较，
        // 如果大于前一个数字，就变成特殊数字
        //就是当前数字减去前一个数字，并且i--
        int ans = 0;
        int mid = 0;
        int pre = 0 ;
        for(int i=s.length() -1 ;i>=0;i--){
            mid = map.get(s.charAt(i));
            if(i != 0){
                pre = map.get(s.charAt(i-1));
                if(mid > pre){
                    ans += mid - pre;
                    i--;
                }
                else ans += mid;
            }
            else ans += mid;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {

        leetcode13罗马数字转整形 lt = new leetcode13罗马数字转整形();
        lt.romanToInt("MCMXCIV");
    }
}
