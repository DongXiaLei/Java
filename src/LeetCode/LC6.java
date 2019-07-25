package LeetCode;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/18 21:43
 */
public class LC6 {
    public static void main(String [] args){
        String string = "LEETCODEISHIRING";
        int numRows = 4;
        convert(string,numRows);


    }
    public static String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuffer ans = new StringBuffer();
        if(numRows==2){
            return s;
        }
        int length = s.length();
        char[] chars = s.toCharArray();
        for(int row = 1 ;row<=numRows;row++){
            int index = row-1;
            while(index<length){
                if(row ==1 || row == numRows){
                    if(index<length){
                        ans.append(chars[index]);
                        index += 2*numRows-2;
                    }
                    else break;
                }
                else {
                    if(index<length){
                        ans.append(chars[index]);
                        index += 2*numRows-2*row;
                        if(index<length){
                            ans.append(chars[index]);
                            index += 2*row-2;
                        }
                    }
                    else break;
                }
            }
        }
    return new String(ans);
    }
}
