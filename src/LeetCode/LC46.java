package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/22 15:39
 */
public class LC46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        for(Integer ele: nums){
            ls.add(ele);
        }
        perm(ans,ls,0);
        return ans;
    }
    private static void perm(List<List<Integer>>ans ,List<Integer> ls ,int index){
        if(index == ls.size()){
            ans.add(new ArrayList<>(ls));
        }
        for(int i= index ; i<ls.size();i++){
            Collections.swap(ls,index,i);
            perm(ans,ls,index+1);
            Collections.swap(ls,index,i);
        }
    }


    public static void main(String[] args){
        int [] nums = {1,2,3,4};
        permute(nums);
    }
}
