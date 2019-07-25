package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 18:29
 */
public class LC32 {
    public static int longestValidParentheses(String s) {
        char [] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new TreeSet<>();
        int i;
        for(i=0;i<chars.length;i++){
            if(chars[i]=='(')break;
        }
        int ans =0;
        while (i<chars.length){
            if(chars[i]=='('){
                stack.push(i);
            }else if(chars[i]==')'&&!stack.isEmpty() && chars[stack.peek()]=='('){
                set.add(stack.pop());set.add(i);
            }
            i++;
        }
        List<Integer> ls = new ArrayList<>(set);
        int[] l =new int[set.size()];i=0;
        for(Integer ele :ls){
            l[i++] = ele;
        }
        int tmp=1;
        for(i=1;i<set.size();i++){
            if(l[i]== l[i-1]+1)tmp++;
            else tmp= 1;
            if(ans<tmp)ans =tmp;
        }
       return ans;
    }
    public static void main(String[] args){
        String string = "))))())()()(()";
        longestValidParentheses(string);
    }
}
