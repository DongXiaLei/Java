package ViewTest;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/12 9:43
 */

/*
拓扑排序
* 给定n m
* n为n个任务 分别命名为 1-n
w[n] 是每个任务完成所需要时间
* m为m个关系 a b 意为 a必须在b之前完成
* 问完成所有任务的最小时间
* 5 5
5 4 3 2 1
1 2
1 3
2 3
4 5
5 2
* */
public class ViewpinDuo3 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int m =in.nextInt();
        if(n<=1)return;
        int[] w = new int[n+1]; // weight[n+1]
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i =1;i<=n;i++){
            w[i] = in.nextInt();
        }
        for(int i=0;i<m;i++){
            int r1 = in.nextInt();
            int r2 = in.nextInt();
            if(map.containsKey(r2)){
                Set<Integer> set = map.get(r2);
                set.add(r1);
                map.put(r2,set);
            }else {
                Set<Integer> set = new HashSet<>();
                set.add(r1);
                map.put(r2,set);
            }
        }
        System.out.println(findMinRoute(w,map));
    }
    public static int findMinRoute(int[] w,Map<Integer,Set<Integer>> map){
        int n = w.length-1;
        int ans =0,maxTmp=0;
        List<Integer> list = new ArrayList<>();//保存可以执行的节点
        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                list.add(i);
            }
        }
        while (!list.isEmpty()){
            // 删除最小的元素 其他的每个都减去最小的
            int minInd = list.get(0);
            for(int index:list){
                if(w[index]<w[minInd])minInd =index;
            }
            list.remove(list.indexOf(minInd));
            ans += w[minInd];
            for(int ind:list){
                w[ind] = w[ind] - w[minInd];
            }
            //每次循环删除已经遍历过的节点
            for(int key:map.keySet()){
                if(map.get(key).contains(minInd)){
                    map.get(key).remove(minInd);
                }
            }
            //从map中删除入度为0的节点
            Iterator<Map.Entry<Integer,Set<Integer>>> it = map.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Integer,Set<Integer> >  entry = it.next();
                int key = entry.getKey();
                if(map.get(key).size()==0){
                    it.remove();
                    list.add(key);
                }
            }
        }
        return ans;
    }
}
/**  1.HashMap 类映射不保证顺序；某些映射可明确保证其顺序: TreeMap 类
 *   2.在遍历Map过程中,不能用map.put(key,newVal),map.remove(key)来修改和删除元素，
 *   会引发 并发修改异常,可以通过迭代器的remove()：
 *   从迭代器指向的 collection 中移除当前迭代元素
 *   来达到删除访问中的元素的目的。
 *   */
/*
*  Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> entry=it.next();
            int key=entry.getKey();
            if(key%2==1){
                System.out.println("delete this: "+key+" = "+key);
                //map.put(key, "奇数");   //ConcurrentModificationException
                //map.remove(key);      //ConcurrentModificationException
                it.remove();        //OK
            }
        }
* */