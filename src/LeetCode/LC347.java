package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 20:54
 */
public class LC347 {
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3,3,3,3};
        topKFrequent(nums,2);
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length<=0)return null;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) +1);
            }else {
                map.put(nums[i],1);
            }
        }
       // Comparator<Map.Entry<Integer,Integer>> comparator = Comparator.comparing(Map.Entry::getValue);默认升序
        Comparator<Map.Entry<Integer,Integer>> comparator = (Entry1,Entry2)->{
            return Entry2.getValue().compareTo(Entry1.getValue());
        };
        /*
        用sort函数方法 时间复杂度 nlogn
        * List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,comparator);

        for(Map.Entry<Integer,Integer> entry:list){
            System.out.println(entry.getKey()+" "+entry.getValue());
            ans.add(entry.getKey());
            k--;
            if(k==0)break;

        }
        * */
        // 大根堆  建堆时间 n 后来调整堆 logn 堆排序 nlogn  本题 klogn k<n
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(comparator);
        for(Map.Entry entry:map.entrySet()){
            heap.add(entry);
        }
        for(int i=0;i<k;i++){
            ans.add(heap.poll().getKey());
        }
        return ans;
    }
}
