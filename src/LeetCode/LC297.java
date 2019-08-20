package LeetCode;

import java.util.*;

import java.util.Queue;

/**
 * @author Xialei Dong
 * @version 1.0
 * @date 2019/8/15 10:40
 */
public class LC297 {
    public static void main(String[] args){
        char [] nums = {'1','2','3'};
        String s = new String(nums,0,nums.length);
        System.out.println(s);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        TreeNode p = root.right.left;
        TreeNode q = root.right.right;

        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        TreeNode newRoot = codec.deserialize(codec.serialize(root));
        return;
    }

}
// Serialization
class Codec {
    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

}
/*
*
* class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
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

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        if(strings.length == 0)return null;
        int [] nums = new int[strings.length];
        // translate to int
        for(int i=0;i<strings.length;i++){
            if(strings[i].equals("null")){
                nums[i] = Integer.MIN_VALUE;
            }else{
                nums[i] = Integer.parseInt(strings[i]);
            }
        }
        TreeNode[] node = new TreeNode[nums.length];
        for(int i=0;i<nums.length;i++){
               if(nums[i]!=Integer.MIN_VALUE){
                   node[i] = new TreeNode(nums[i]);
               }else {
                   node[i] =null;
               }
        }
        TreeNode root = node[0];
        for(int i=0;i<nums.length/2;i++){
            if(node[i]!=null){
                node[i].left = node[i*2+1];
                node[i].right = node[i*2+2];
            }
        }
        return root;
    }
    public int getDepth(TreeNode root,int depth){
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
}
* */
