import java.util.Arrays;

public class Problem61 {
    public static void main(String [] args){
        System.out.println("Problem61");
        int arrays[] ={0,2,4,6,8,1,0,9,1,10,0};
        System.out.println(isContinuous(arrays));
    }
    public static boolean isContinuous(int [] arrays){
        if(arrays.length<2)return true;
        Arrays.sort(arrays);
        int count0nums = 0,i;
        for(i=0;arrays[i]==0;i++){
            count0nums ++;
        }
        int countGaps = 0;
        for(;i<arrays.length-1;i++){
            if(arrays[i]== arrays[i+1])return false;
            if(arrays[i]<arrays[i+1]-1)
                countGaps += arrays[i+1]-arrays[i]-1;
        }
        return count0nums>=countGaps ? true :false;
    }
}
