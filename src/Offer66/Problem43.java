package Offer66;

public class Problem43 {
    public static void main(String[] args){
        System.out.println("Problme 43");
        countDigitOne(534);
        countDigitOne2(534);
    }
    public static int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10){
            ones += ( n / m + 8) / 10 * m ;
            if(n/m % 10 == 1){
                ones += n % m + 1;
            }
        }
        System.out.println(ones);
        return ones;
    }
    public static int countDigitOne2(int n)
    {
        if(n<1) {
            return 0;
        }
        int count = 0;
        int base = 1;
        int round = n;
        while(round>0) {
            int weight = round%10;
            round/=10;
            count += round*base;
            if(weight==1) {
                count+=(n%base)+1;
            }
            else if(weight>1) {
                count+=base;
            }
            base*=10;
        }
        System.out.println(count);
        return count;
    }


}
