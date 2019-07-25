package LeetCode;



import java.util.Stack;
/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/21 11:05
 */
public class LC20 {
    public static boolean isValid(String s) {
        if(s.length()==0)return true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int i;
        for( i=0;i<chars.length;i++){
            if(chars[i]=='(' || chars[i]=='{'||chars[i] == '['){
                stack.push(chars[i]);
            }else {
                if(chars[i]==')' || chars[i]==']'||chars[i] == '}'){
                    if(chars[i]==')'){
                        if(!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }else if(chars[i]==']'){
                        if(!stack.isEmpty() && stack.peek() == '['){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }else {
                        if(!stack.isEmpty() && stack.peek() == '{'){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }
                }else return false;
            }
        }
        if(stack.isEmpty() && i == chars.length){
            return true;
        }
        return false;
    }
    public static void main(String [] args){
        String string = "()[]{}";
        System.out.println(isValid(string));
    }
}
