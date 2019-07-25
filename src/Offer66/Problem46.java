package Offer66;

public class Problem46 {
    public static void main(String[] args){
        System.out.println("Problem 46");
        System.out.println(getTranslationNum(123123));
    }
    public static int getTranslationNum(int number){
        if(number<0)return 0;
        String string = String.valueOf(number);
        return getTranslationNum(string);
    }
    public static int getTranslationNum(String string){
        int length = string.length();
        int [] counts = new int[length];

        int count =0;
        for(int i=length-1;i>=0;i--){
            count=0;
            if(i<length-1){
                count = counts[i+1];
            }else {
                count =1;
            }
            if(i<length-1){
                int digit1 = string.charAt(i) - '0';
                int digit2 = string.charAt(i+1) - '0';
                int convert = digit1*10 +digit2;
                if(convert>=10&&convert<=25){
                    if(i<length-2)
                        count += counts[i+2];  //if convert is true f(i) = f(i+1)+f(i+2)
                    else count += 1 ;
                }                               // else f(i) = f(i+1)
            }
            counts[i] = count ;
        }
        return counts[0];
    }
}
