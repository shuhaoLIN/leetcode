/**
 * Created by lenovo on 2018/8/8.
 */
public class leetcode7 {
    public int reverses(int x){
        int mid = 1;
        boolean flag;
        if(x < 0 ){
            flag = true;
            x = -x;
        }
        else flag = false;
        //这个的作用是用于标记是否为负数，我是想着处理过程全按照正数进行
        while(mid != 0){
            mid = x / 10;
        }
        return 1;
    }
    public int reverses(int x,int a){
        if(x == 0){
            return 0;
        }
        boolean flag;
        if(x < 0 ){
            flag = true;
            x = -x;
        }
        else flag = false;
        //这个的作用是用于标记是否为负数，我是想着处理过程全按照正数进行
        String s = String.valueOf(x);
        System.out.println(s+"jjjj");
        s = new StringBuilder(s).reverse().toString();
        System.out.println(s+"llll");
        //s = s.replace('0',' ');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                s = s.substring(i);
            }
            else break;
        }
       // s = s.trim();
        System.out.println(s+"kkkk");

        int nums ;
        try{
            nums = Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return 0;
        }
        if(flag == true ){
            nums = -nums;
        }
        System.out.println(nums);
        return nums;
    }
    public static void main(String[] args) {
        leetcode7 lt  = new leetcode7();
        //lt.reverses(1534236469,1);
        String s = "9646324351";
        long num = Long.parseLong(s);
        lt.reverses(-120,1);
        lt.reverses(0,1);
        lt.reverses(902100,1);
        //String s = "aaaa";
        //s.replace("a","");
        //System.out.println(s);

    }
}
