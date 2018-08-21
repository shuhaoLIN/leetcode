/**
 * Created by lenovo on 2018/8/17.
 * 1.遍历所有可能
 * 2.dp动态规划
 * 3.Manacher算法
 */
public class leetcode5最长回文子串 {
    public String longestPalindrome(String s) {
        return "";
    }
    //2 dp
    //思路:  dp[i][j]= ① 1  i== j
    //                    ② s[i] == s[j]  j-i == 1
    //                  ③ s[i] == s[j] && dp[i+1][j-1] == 1
    public String longestPalindrome(String s,int an1) {
        int len = s.length();
        if(len == 0){ return "";}  //一定要记住这个东西
        int[][] dp = new int[len][len];
        int begin = 0;
        int end = 0;
        int max = 0;
        for(int j =0 ;j<len;j++){
            for(int i=0;i<=j;i++){
                if(i == j){
                    dp[i][j] = 1;
                    if(max < 1){
                        begin = end = i;
                        max = 1;
                    }
                }
                else if((i+1) == j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        if(max < 2){
                            begin = i;
                            end = j;
                            max = 2;
                        }
                    }
                }
                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    if(max < j-i+1){
                        begin = i;
                        end = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return s.substring(begin,end+1);
    }

    //O(n)时间复杂度方法——Manacher算法
    //1.思想：

    //1）将原字符串S的每个字符间都插入一个永远不会在S中出现的字符（本例中用“#”表示），在S的首尾也插入该字符，使得到的新字符串S_new长度为2*S.length()+1，保证Len的长度为奇数(下例中空格不表示字符，仅美观作用)；
    //例：S：       a  a  b  a  b  b  a
   // S_new:        #  a  #  a  #  b  #  a  #  b  #  b  #  a  #
    //2）根据S_new求出以每个字符为中心的最长回文子串的最右端字符距离该字符的距离，存入Len数组中，即S_new[i]—S_new[r]为S_new[i]的最长回文子串的右段（S_new[2i-r]—S_new[r]为以S_new[i]为中心的最长回文子串），Len[i] = r - i + 1;
    //S_new:        #  a  #  a  #  b  #  a  #  b  #  b  #  a  #
    //Len:            1  2  3  2  1   4  1  4  1  2  5   2  1  2  1
    //Len数组性质：Len[i] - 1即为以Len[i]为中心的最长回文子串在S中的长度。在S_new中，以S_new[i]为中心的最长回文子串长度为2Len[i] - 1，由于在S_new中是在每个字符两侧都有新字符“#”，观察可知“#”的数量一定是比原字符多1的，即有Len[i]个，因此真实的回文子串长度为Len[i] - 1，最长回文子串长度为Math.max(Len) - 1。
    //3）Len数组求解（线性复杂度（O(n)））：
    //a.遍历S_new数组，i为当前遍历到的位置，即求解以S_new[i]为中心的最长回文子串的Len[i];
    //b.设置两个参数：sub_midd = Len.indexOf(Math.max(Len)表示在i之前所得到的Len数组中的最大值所在位置、sub_side = sub_midd + Len[sub_midd] - 1表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置。起始sub_midd和sub_side设为0，从S_new中的第一个字母开始计算，每次计算后都需要更新sub_midd和sub_side；
    //c.当i < sub_side时，取i关于sub_midd的对称点j（j = 2sub_midd - i，由于i <= sub_side，因此2sub_midd - sub_side <= j <= sub_midd);当Len[j] < sub_side - i时，即以S_new[j]为中心的最长回文子串是在以S_new[sub_midd]为中心的最长回文子串的内部，再由于i、j关于sub_midd对称，可知Len[i] = Len[j];
    //当Len[j] >= sub.side - i时说明以S_new[i]为中心的回文串可能延伸到sub_side之外，而大于sub_side的部分还没有进行匹配，所以要从sub_side+1位置开始进行匹配，直到匹配失败以后，从而更新sub_side和对应的sub_midd以及Len[i]；
    //d.当i > sub_side时，则说明以S_new[i]为中心的最长回文子串还没开始匹配寻找，因此需要一个一个进行匹配寻找，结束后更新sub_side和对应的sub_midd以及Len[i]。
    public String longestPalindrome(String s,int an1,int an2) {
        //1.构造奇数字符串
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for(int i =0 ;i<s.length();i++){
            newStr.append(s.charAt(i));
            newStr.append('#');
        }
        //2.p数组记录回文字符串长度的一半
        int len = newStr.length();
        int[] p = new int[len];
        int max = -1; // 前面最大的回文串最右的位置
        int maxid = -1; //最大回文串中心的id
        for(int i = 0;i<len;i++) {
            int r = 1;
            if (i < max) {
                r = Math.min(max - i, p[2 * maxid - i]);
                //p[maxid]+maxid 就是max p[2*maxid - i]就是i对应的j
            }
            while (i-r >=0 && i+r <len && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }

            if (i + r - 1 > max) {
                maxid = i;
                max = i + r - 1;
            }
            p[i] = r;
        }
        max = 0;
        maxid =-1;
       for(int i=0;i<len;i++){
           if(p[i] > max ){
               max = p[i];
               maxid = i;
           }
       }
//       #1#2#1#
//        max = 4 maxid = 3; begin = 3-4+1 end = 3+4
//        121
//        max = 4/2=2 maxid = 3/2=1  begin = 1-2+1  end = 1+2
//                #2#1#1#2# max = 5 maxid = 4 begin = 4-5+1 end = 4+5
//                2112  max = 5/2 =2 maxid = 4/2 = 2 begin = 2-2  end
//       s = newStr.substring(maxid - max +1 ,maxid+max).replace("#");
//        return s.replaceAll("#")
        if(newStr.charAt(maxid) == '#')
        return s.substring(maxid/2 - max/2,max/2 + maxid/2);
        else return s.substring(maxid/2 - max/2 + 1,max/2 + maxid/2);
    }
    //中心扩展法：时间O(n) 空间O(1)

    public static void main(String[] args) {
        leetcode5最长回文子串 lt = new leetcode5最长回文子串();
        System.out.println(lt.longestPalindrome("ccc",1,2));
        System.out.println(lt.longestPalindrome("babad",1,2));
        System.out.println(lt.longestPalindrome("abcdbbfcba",1,2));
    }
}
