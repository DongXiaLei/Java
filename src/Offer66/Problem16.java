package Offer66;

public class Problem16 {
    public static void main(String[] args){
        System.out.println(Math.pow(2,4));
        System.out.println(Power(0,0));
        System.out.println(Power(4,3));
    }
    public static double Power(double base ,int exp){  //时间复杂度 n
        boolean flag = false;
        if(base == 0.0 && exp <= 0 )
            return 0.0;
        if( base != 0.0 &&exp == 0)
            return 1.0;
        if(exp < 0){
            flag = true;
            exp = - exp;
        }
        double ans = 1.0;
        ans = PowerRecur(base,exp);
        /*
        * for(int i =1;i<=exp;i++){
            ans = ans * base ;
        }
        * */
        if(flag) ans = 1 / ans ;
        return ans;
    }
    public static double PowerRecur(double base, int exp){  //logn
        if(exp == 0)
            return 1;
        if(exp ==1)
            return base;
        double ans = PowerRecur(base,exp>>1);
        ans *= ans ;
        if((exp & 1) == 1){
            ans = ans * base;
        }
        return ans;
    }
}
