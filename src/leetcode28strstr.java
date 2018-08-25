/**
 * Created by lenovo on 2018/8/25.
 */
public class leetcode28strstr {
    public int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        else {
            return haystack.indexOf(needle);
        }
    }

}
