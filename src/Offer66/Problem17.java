package Offer66;

public class Problem17 {
    public static void main(String[] args) {
        System.out.println("Problem 17");
        printMaxN(10);
    }
    public static void printMaxN(int n){
        if(n<=0)
            return;
        char[] numbers  =new char[n+1];
        for(int i=0;i<10;i++){
            numbers[0] = (char)(i + '0');
            reCurCore(numbers,n,0);
        }
    }
    public static void reCurCore(char[] numbers ,int n ,int index){
        if(index == n -1){
            printCore(numbers);
            return;
        }
        for(int i=0;i<10;i++){
            numbers[index+1] = (char)(i+'0');
            reCurCore(numbers,n,index+1);
        }
    }
    public static void printCore(char[] numbers){
        boolean flag = false;
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]!='0'){
                flag = true;
            }
            if(flag)
                System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
