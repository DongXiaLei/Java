package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 14:25
 */
public class LC22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String string = new String("(");
        find(list,string,2*n-1,1);
        // n为剩余要添加的括号数 num 为左括号大于右括号数量
        return  list;
    }
    public static void find(List list,String s,int n,int num){
        if(n== 0 ){
            list.add(s);
            return;
        }
        if(n>=num+2 && num>=1){ //可以添加左括号或者右括号
            find(list,s+"(",n-1,num+1);
            find(list,s+")",n-1,num-1);
        }else if(num==0){ //只可以添加 左括号
            find(list,s+"(",n-1,num+1);
        }else {
            // 只可以添加右括号
            find(list,s+")",n-1,num+1);
        }
    }
    public static void main(String[] args){
        generateParenthesis(3);
    }
}
