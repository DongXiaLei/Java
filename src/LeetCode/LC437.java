package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/18 11:00
 */
public class LC437 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(pathSum2(root,20));
    }
    public static int pathSum1(TreeNode root, int sum) {
        String string = serialize(root);
        String[] strings = string.split(",");
        int ans =0;
        for(int i = strings.length-1;i>=0;i--){
            int tmpSum =0;
            for(int j = i;j>=0;){
                if(!strings[j].equals("null")){
                    tmpSum += Integer.parseInt(strings[j]);
                    if(tmpSum == sum){
                        ans ++;
                    }
                    if(j%2==1){
                        j = (j-1)>>1;
                    }else {
                        j = (j-2)>>1;
                    }
                }else {
                    break;
                }
            }
        }
        return ans;
    }
    public static String serialize(TreeNode root) {
        if(root==null)return new String("null");
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        int depth = getDepth(root,1);
        int count = (int)Math.pow(2,depth)-1;//深度为depth最多节点数 防止最后加入过多的空节点
        queue.add(root);
        while (count>0 && !queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
            }else {
                queue.add(null);
                queue.add(null);
            }
            if(node!=null){
                stringBuffer.append(String.valueOf(node.val)+',');
            }else {
                stringBuffer.append("null,");
            }
            count--;
        }
        return stringBuffer.toString().substring(0,stringBuffer.length()-1);
    }
    public static int getDepth(TreeNode root,int depth){
        // 默认depth = 1
        if(root==null){
            return depth;
        }
        if(root.left!=null || root.right!=null){
            depth++;
        }
        int left = getDepth(root.left,depth);
        int right = getDepth(root.right,depth);
        return  Math.max(left,right);
    }
    public static int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root,sum) + pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public static int helper(TreeNode root, int sum){
        if(root == null) return 0;
        sum -= root.val;
        return (sum == 0  ? 1:0) + helper(root.left,sum)+helper(root.right,sum);
    }
    public static int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return helper2(root, map, sum, 0);
    }

    public static int helper2(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum){
        int res = 0;
        if(root == null) return 0;

        pathSum += root.val;
        res += map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res = helper2(root.left, map, sum, pathSum) + helper2(root.right, map, sum, pathSum) + res;
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }






}
