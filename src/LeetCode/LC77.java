package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/26 12:57
 */
public class LC77 {

    public static void main(String []args){
        combine(4,1);
    }
    public static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> combine(int n,int k){
        if(k>n)return null;
        List<Integer> ls =new ArrayList<>();
        for(int i=1;i<=n;i++){
            combineCore(n,i,1,ls); //
        }
        return ans;
    }
    private static void combineCore(int n,int k,int begin,List<Integer> ls){
        if(ls.size()==k){
            ans.add(new ArrayList<>(ls));
        }else {
            for(int t = begin;t<=n;t++){
                ls.add(t);
                combineCore(n,k,++begin,ls);
                ls.remove(ls.size()-1);
            }
        }
    }
}
