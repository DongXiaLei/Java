package ViewTest;

import java.util.*;

public class ViewBeikeB4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int [][] relations = new int[m][2];
        for(int i=0;i<m;i++){
            int begin = in.nextInt();
            int end = in.nextInt();
            relations[i][0] = begin;
            relations[i][1] = end;
        }
        for(int i=0;i<m;i++){
            int begin = relations[i][0] ;
            int end = relations[i][1] ;
            if(!map.containsKey(begin)){
                List<Integer> ls = new ArrayList<>();
                ls.add(end);
                map.put(begin,ls);
            }else {
                List<Integer> ls = map.get(begin);
                ls.add(end);
                map.put(begin,ls);
            }

            if(!map.containsKey(end)){
                List<Integer> ls = new ArrayList<>();
                ls.add(begin);
                map.put(end,ls);
            }else {
                List<Integer> ls = map.get(end);
                ls.add(begin);
                map.put(end,ls);
            }

        }
        System.out.println(maxNumsOfBelievd(map,n));

    }
    public static int maxNumsOfBelievd(Map<Integer,List<Integer>> map, int n){
        int ans =0;
        for(Integer key:map.keySet()){
            Set<Integer> believe = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> ls = map.get(key);
            believe.add(key);
            for(Integer ele:ls){
                queue.add(ele);
            }
            while (!queue.isEmpty()){
                int k = queue.poll();
                List<Integer> tmp = map.get(k);
                if(!believe.contains(k)){
                    int innums =0; // tmp中的数在set中的个数
                    for(Integer ele: tmp){
                        if(believe.contains(ele)){
                            innums++;
                        }
                    }
                    if(innums>=(tmp.size()>>1)){
                        believe.add(k);
                    }
                }
                for(Integer ele:tmp){
                    queue.add(ele);
                }
            }
            if(believe.size()>ans) ans = believe.size();
        }
        return ans;
    }
}
