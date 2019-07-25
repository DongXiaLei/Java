package JavaDataStruct;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {
    private int size;                 //栈的大小
    private int top;                  //栈顶元素的下标
    private char [] stackArray;       //栈的容器

    //构造函数
    public Stack(int size){
        stackArray = new char [size];
        top = -1; //初始化栈的时候，栈内无元素，栈顶下标设为-1
        this.size = size;
    }

    //入栈，同时，栈顶元素的下标加一
    public void push(char elem){
        stackArray[++top] = elem; //插入栈顶
    }

    //出栈，删除栈顶元素，同时，栈顶元素的下标减一
    public char pop(){
        return stackArray[top--];
    }

    //查看栈顶元素，但不删除
    public char peek(){
        return stackArray[top];
    }

    //判空
    public boolean isEmpty(){
        return (top == -1);
    }

    //判满
    public boolean isFull(){
        return (top == size-1);
    }

    public static void main(String[] args) {

        System.out.println("输入需要检测的字符串：");
        String str = getString();
        BrecketChecker checker = new BrecketChecker(str);
        checker.check();
    }

    public static String getString(){
        String str = "";
        try{
            InputStreamReader reader =new InputStreamReader(System.in);
            BufferedReader bReader = new BufferedReader(reader);
            str = bReader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
class BrecketChecker {

    private String input;  //存储待检查的字符串

    //构造方法，接受待检查的字符串
    public BrecketChecker(String in){
        this.input = in;
    }

    //检查分隔符匹配的方法
    public void check(){
        int strLength = input.length();
        Stack stack = new Stack(strLength);

        for(int i=0;i<strLength;i++){

            char ch =input.charAt(i);  //一次获取串中的单个字符

            switch(ch){
                case '{' :
                case '[' :
                case '(' :
                    //如果为左分隔符，压入栈
                    stack.push(ch);
                    break;
                case '}' :
                case ']' :
                case ')' :
                    //如果为右分隔符，与栈顶元素进行匹配
                    if(!stack.isEmpty()){
                        char chx = stack.pop();

                        if((ch== '{' && chx != '}')||
                                (ch == '(' && chx != ')')||
                                (ch == '[' && chx != ']')
                        ){
                            System.out.println("匹配出错！字符："+ch+",下标："+i);
                        }
                    }else{
                        System.out.println("匹配出错！字符："+ch+",下标："+i);
                    }

                default :
                    break;
            }

        }

        if(!stack.isEmpty()){
            //匹配结束时如果栈中还有元素，证明右分隔符缺失
            System.out.println("有括号没有关闭！");
        }
    }

}

