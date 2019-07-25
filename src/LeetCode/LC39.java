package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/22 10:49
 */
public class LC39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        int sum = 0 ;
        addElement(ans,ls,candidates,0,0,target);
        return ans;
    }
    private static void addElement(List<List<Integer>> ans,List<Integer> ls,int[] candidates ,int sum, int index, int target){
        if(sum > target)return;
        if(sum == target) ans.add(ls);
        for(int i= index ;i < candidates.length ;i++){
            List<Integer> lsTmp = new ArrayList<>(ls);
            lsTmp.add(candidates[i]);
            addElement(ans,lsTmp,candidates,sum+candidates[i],i,target);
        }
    }
    public static void main(String [] args){
        int [] candidates = {2,3,5,8};
        int target = 8;
        combinationSum(candidates,target);
    }
}
