import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/8/20.
 */
public class leetcode22括号生成 {
    public List<String> generateParenthesis(int n) {
        //利用回溯
        List<String> ans = new ArrayList<>();
        getBack(n,0,0,ans,"");
        return ans;
    }
    public void getBack(int n, int left,int right,List ans,String cur){
        if(cur.length() == n*2){
            ans.add(cur);
            return ;
        }
        //每一个都有一个分支，所以组合起来将是一棵树的样子
        if(left < n){
            getBack(n,left+1,right,ans,cur +'(');
            //这样做导致了一个后果就是cur在这里增加了一次，然后回溯的时候后面会再加一次
            //所以最好是cur+'('放在参数里面，不对该循环的cur进行更新
        }
        if(right < left){
            //要右边小于左边，不然将就会出现右括号在左边的情况
            getBack(n,left,right+1,ans,cur+')');
        }
    }
    //大概有点迷糊：闭合数
        public List<String> generateParenthesis(int n,int an2) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left: generateParenthesis(c,1))
                        for (String right: generateParenthesis(n-1-c,1))
                            ans.add("(" + left + ")" + right);
            }
            return ans;
        }

    public static void main(String[] args) {
        leetcode22括号生成 lt = new leetcode22括号生成();
        System.out.println(lt.generateParenthesis(2));
    }
}
