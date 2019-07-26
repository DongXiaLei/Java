package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/26 14:52
 */
public class LC78 {
    public static void main(String []args){
        int[] nums ={1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums){
        if(nums.length==0)return null;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls =new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            subsetsCore(nums,i,0,ls,ans); //
        }
        return ans;
    }
    private static void subsetsCore(int[] nums,int k,int begin,List<Integer> ls,List<List<Integer>> ans){
        if(ls.size()==k){
            ans.add(new ArrayList<>(ls));
        }else {
            for(int t = begin;t<nums.length;t++){
                ls.add(nums[t]);
                subsetsCore(nums,k,++begin,ls,ans);
                ls.remove(ls.size()-1);
            }
        }
    }
}
