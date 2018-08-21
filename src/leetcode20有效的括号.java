import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lenovo on 2018/8/14.
 */
public class leetcode20有效的括号 {
//    public boolean isValid(String s) {
//        if(s.length() == 0){
//            return true;
//        }
//        else {
//            String mid = "";
//            mid += s.charAt(0);
//            char ch;
//            char pre;
//            for(int i=1;i<s.length();i++){
//                ch = s.charAt(i);
//                pre = pop(mid);
//                if(ch == ')'){
//                    if(pre == '('){
//                        continue;
//                    }
//                }
//                else if(ch == ']'){
//                    if(pre == '[')
//                        continue;
//                }
//                else if(ch == '}'){
//                    if(pre == '{')
//                        continue;
//                }
//                else push(mid,ch);
//            }
//            if(mid == "")
//                return true;
//            else return false;
//        }
//
//    }
//    public char pop(String s){
//            char ch = s.charAt(s.length() - 1);
//            if(s.length() == 1){
//                s = "";
//            }
//            else s = s.substring(0,s.length()-2);
//            return ch;
//    }
//    public void push(String s,char ch){
//        s = s + ch;
//    }
    public boolean isValid(String s) {
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put('(',')');
        hm.put('[',']');
        hm.put('{','}');
        Stack<Character> S = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                //如果是（，[,{则进栈
                S.push(s.charAt(i));
            }
            else if(S.empty() || hm.get(S.pop()) != s.charAt(i)){
                //如果是），】，}则将栈内的元素pop出来并且在hash中获得其value进行检查，
                //如果不是当前字符，则是不对应。
                return false;
            }
        }
        return S.empty();
    }
    public String get(String mid){
        mid = mid+'a';
        return mid;
    }
    public static void main(String[] args) {
        leetcode20有效的括号 lt = new leetcode20有效的括号();
        System.out.println(lt.isValid("()"));
        String mid = "bbbb";
        String mid2 = lt.get(mid);
        System.out.println(mid + "   "+mid2);
    }
}
