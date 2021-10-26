package erchashu;

import java.util.*;

public class 在二叉树中找到两个节点的最近公共祖先 {

    public static void main(String[] args) {

    }

    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        Map<Integer,Integer> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        parentMap.put(root.val,-1);
        queue.add(root);
        while (!parentMap.containsKey(o1) || !parentMap.containsKey(o2)){
            TreeNode node  = queue.poll();
            if (node .left!=null){
                queue.add(node .left);
                parentMap.put(node .left.val,node .val);
            }
            if (node .right!=null){
                queue.add(node .right);
                parentMap.put(node .right.val,node .val);
            }
        }

        Set<Integer> as = new HashSet<>();
        // 把o1的祖先都放在as里面
        while (parentMap.containsKey(o1)){
            o1 = parentMap.get(o1);
            as.add(o1);
        }
        // 从as里面找到最近一个o2的祖先 就是o1和o2的公共祖先
        while (!as.contains(o2))
            o2 = parentMap.get(o2);

        return o2;
    }

}
