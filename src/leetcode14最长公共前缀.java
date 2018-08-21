/**
 * Created by lenovo on 2018/8/14.
 */
public class leetcode14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        String mid = "";
        int len = 25535;
        for(String s : strs){
            if(s.length() < len){
                len = s.length();
            }
        }
        boolean flag = true;
        out:
        for(int i=0;i<len;i++){
            for(String s : strs){
                if(s.charAt(i) != strs[0].charAt(i)){
                    flag = false;
                    break out;
                }
            }
            mid+=strs[0].charAt(i);
        }
        System.out.println(mid);
        return mid;
    }


    public String longestCommonPrefix(String[] strs,int ans2) {
        //因为是公共的，所以只要拿一个出来比较就好了
        String mid;
        int count;
        if(strs.length == 0){
            return "";
        }
        else {
            count = strs.length;
        }
        mid = strs[0];
        for(int i=1;i<count;i++){
            while(!strs[i].startsWith(mid)){
                mid = mid.substring(0,mid.length() - 1);
                if(mid.length() == 0) return "";
            }
        }
        return mid;
    }
    public static void main(String[] args) {
        leetcode14最长公共前缀 lt = new leetcode14最长公共前缀();
        String[] str = {"dog","dacecar","dar"};
        lt.longestCommonPrefix(str);
    }
}
