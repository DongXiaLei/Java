public class Problem65 {
    public static void main(String [] args){
        System.out.println("Problem65");
        System.out.println(add2Nums(56,34));
    }
    public static int add2Nums(int num1,int num2){
        int carry =0; //进位
        int sum =0;
        do{
            sum = num1 ^ num2 ;
            carry = (num1 & num2 )<<1;
            num1 = sum;
            num2 = carry;
        }while (carry!=0);
        return sum;
    }
}
