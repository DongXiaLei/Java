package LeetCode;

import java.util.*;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/13 15:53
 */
/*
* 5 3
1 0
2 1
0 2

* */
public class LC207 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=1) return;
        int m = in.nextInt();
        int[][] prerequisites = new int[m][2];
        for(int i=0;i<m;i++){
            prerequisites[i][0] = in.nextInt();
            prerequisites[i][1] = in.nextInt();
        }
        System.out.println(canFinish(n,prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        Map<Integer, Set<Integer>> map = new HashMap<>(); // 拓扑图
        for(int i=0;i<m;i++){
            if(map.containsKey(prerequisites[i][0])){
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }else {
                Set<Integer> set =new HashSet<>();
                set.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],set);
            }
        }
        Set<Integer> set = new HashSet<>();// 完成节点
        Queue<Integer> queue = new LinkedList<>(); // 入度为0的点
        for(int i=0;i<numCourses;i++){
            if(!map.containsKey(i)){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int i = queue.poll();
            set.add(i);
            for(int key:map.keySet()){
                map.get(key).remove(i);
                if(!set.contains(key) && map.get(key).size() == 0){
                    queue.add(key);
                }
            }
        }
        if( set.size() == numCourses){
            return true;
        }else return false;
    }
}
