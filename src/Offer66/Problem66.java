package Offer66;

public class Problem66 {
    public static void main(String []args){
        System.out.println("Problem 66");
        int [] arrays = {1,2,3,4,5};
        makeMulitply(arrays);
    }
    public static void makeMulitply(int [] arrays){
        if(arrays.length==0)return;
        int [] ans = new int[arrays.length];
        ans[0] = 1;
        for(int i=1;i<ans.length;i++){
            ans[i] = ans[i-1]*arrays[i-1];
        }
        int tmp =1;
        for(int j = ans.length-2;j>=0;j--){
            tmp *= arrays[j+1];
            ans[j] = tmp*ans[j];
        }

        for(int ele:ans){
            System.out.println(ele);
        }
    }
}
