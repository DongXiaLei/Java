package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/7/23 18:22
 */
public class LC56 {
    public static int[][] merge(int[][] intervals) {
        //先排序
        sort(intervals,new int[]{0});
        List< List<Integer>>  ans = new ArrayList<>();
        if (intervals==null){
            return null;
        }
        int row= intervals.length;
        int left=0,right =0,tmp =0;
        for(int i =0;i<row;){
            left = intervals[i][0];right = intervals[i][1];
            int j =0;
            for(j = i+1 ;j<row;j++){
                if(intervals[j][0]<=right){
                    if(intervals[j][1]>right){
                        right = intervals[j][1];
                    }
                }else {
                    break;
                }
            }
            if(j == i +1 ) i++;
            else i = j;
            List<Integer> tmpAns = new ArrayList<>();
            tmpAns.add(left);tmpAns.add(right);
            ans.add(tmpAns);
        }
        row = ans.size();
        int[][] anss = new int[row][2];
        Iterator<List<Integer>> it = ans.iterator();
        int i =0,j=0;
        while (it.hasNext()){
            List<Integer> ls = it.next();
            Iterator itt  = ls.iterator();
            while (itt.hasNext()){
                anss[i][j++] = (Integer) itt.next();
            }
            i++;j = 0;
        }
        return anss;
    }
    public static void sort(int[][] ob, final int[] order) {
        Arrays.sort(ob, new Comparator() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (one[k] > two[k]) {
                        return 1;
                    } else if (one[k] < two[k]) {
                        return -1;
                    } else {
                        continue;
                    }
                }
                return 0;
            }
        });
    }
    public static void main(String[] args){
        int[][] nums = {{1,3},{0,3}};
        merge(nums);


    }
}
