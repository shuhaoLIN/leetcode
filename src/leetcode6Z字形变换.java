/**
 * Created by lenovo on 2018/8/21.
 */


public class leetcode6Z字形变换 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        String mid = "";
        int len = s.length();
        int beishu = 0;
        for(int i=0;i<numRows;i++){
            if(i == 0){
                while(beishu * (2 * numRows - 2) < len){
                    mid += s.charAt(beishu * (2 * numRows - 2));
                    beishu++;
                }
                beishu = 0;
            }
            else if(0 <= i && i < numRows -1){
                while(beishu * (2*numRows -2) + i < len){
                    mid += s.charAt(beishu * (2*numRows -2) + i);
                    if((beishu+1) * (2*numRows -2) - i < len){
                        mid += s.charAt((beishu+1) * (2*numRows -2) - i);
                    }
                    beishu++;
                }
                beishu = 0;
            }
            else {
                while(beishu* (2*numRows -2) + numRows -1 < len) {
                    mid += s.charAt(beishu * (2 * numRows - 2) + numRows - 1);
                    beishu ++;
                }
                beishu = 0;
            }
        }
        return  mid;
    }

    //答案里面31ms的代码
    public String convert(String s, int numRows,int an2) {
        char[] c = s.toCharArray();
        char[] newChars = new char[c.length];
        int pos = 0;

        int step = Math.max(2 * numRows - 2, 1);
        for (int i = 0; i < numRows; i++) {

            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < c.length; j += step) {
                    newChars[pos++] = c[j];
                }
            }
            else if (numRows % 2 == 1 && i == numRows / 2) {
                for (int j = i; j < c.length; j += step / 2) {
                    newChars[pos++] = c[j];
                }
            } else {
                for (int j = i, k = 0; j < c.length; k++) {
                    newChars[pos++] = c[j];
                    if (k % 2 == 0) {
                        j += step - i * 2;
                    } else {
                        j += i * 2;
                    }
                }
            }
        }
        return String.copyValueOf(newChars);
    }
    public static void main(String[] args) {
        leetcode6Z字形变换 lt = new leetcode6Z字形变换();
        System.out.println(lt.convert("PAYPALISHIRING",3));
    }
}
