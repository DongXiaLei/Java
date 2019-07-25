public class Problem62 {
    public static void main(String[] args){
        System.out.println(LastRemaining(5,3));
    }
    public static int LastRemaining(int n ,int k){
        if(n<1 ||k<1) return -1;
        int ans = 0;
        for(int i = 2;i<=n;i++){
            ans = (ans+k)%i;
        }
        return ans;
    }
}
