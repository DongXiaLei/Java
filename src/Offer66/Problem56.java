package Offer66;

public class Problem56 {
    public static void main(String[] args){
        System.out.println("Problem 56");
        int[] arrays1 = { 1,2,3,4,5,1,2,3,4};
        findFirstAppearOnce1Nums(arrays1);
        int[] arrays2 = { 1,2,3,4,5,6,1,2,3,4};
        findFirstAppearOnce2Nums(arrays2);
        int[] arrays3 = { 1,2,3,4,5,1007,1,2,3,4,5,1,2,3,4,5};
        findfindFirstAppearOnce1Nums3(arrays3);
    }
    public static void findFirstAppearOnce2Nums(int[] arrays){
        //只有两个数字出现一次 其他都出现两次
        if(arrays.length<2)
            return;
        int index =0 ;
        for(int i=0;i<arrays.length;i++){  //1，对数组所有数求异或
            index = arrays[i] ^ index;
        }
        int indexOf1 = firstIndexOf1(index);
        int num1 =0 ,num2 =0;
        for(int i=0;i<arrays.length;i++){
            if(isIndex1(arrays[i],indexOf1)){
                num1 ^= arrays[i];
            }else {
                num2 ^= arrays[i];
            }
        }
        System.out.println(num1+" "+num2);
    }
    private static int firstIndexOf1(int num){  //2,对1的结果求出来最右边第一个不为0的数
        int ans = 0;
        while ((num & 1)==0 && ans<Integer.SIZE){
            num = num>>1;
            ans ++;
        }
        return ans;
    }
    private static boolean isIndex1(int data,int indexOf1) {    //3, 判断每个数字的 indexOf1 为是否为1
        for(int i=0;i<indexOf1;i++){
            data = data>>1;
        }
        return (data&1) == 1 ;
    }
    public static int findFirstAppearOnce1Nums(int[] arrays){
        //只有一个数字出现一次 其他都出现两次
        if(arrays.length<0)return -1;
        if(arrays.length==1)return arrays[0];
        int ans= 0;
        for(int i=0;i<arrays.length;i++){
            ans  ^= arrays[i];
        }
        System.out.println(ans);
        return ans;
    }
    public static int findfindFirstAppearOnce1Nums3(int [] arrays){
        if(arrays.length==0)return -1;
        int[] bitSum = new int[32];
        int ans =0 ;
        for(int i = 0;i<arrays.length;i++){
            int bitMask = 1;
            for(int j =0;j<32;j++){
                if((bitMask& arrays[i])!=0){
                    bitSum[j] += 1;
                }
                bitMask= bitMask << 1 ;
            }
        }
        int break1 = 0,i;
        for(i=31;i>=0;i--){
            if(bitSum[i]!=0){
                break;
            }
        }
        int base = 1;
        for(int j =0;j<=i;j++){
            ans += bitSum[j]%3*base;
            base = base <<1 ;
        }
        System.out.println(ans);
        return ans;
    }
}
