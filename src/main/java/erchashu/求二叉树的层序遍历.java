package erchashu;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 求二叉树的层序遍历 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.data);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            rs.add(temp);
        }
        return rs;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,null,null),new TreeNode(4,null,null)),null);
        treeNode = new TreeNode(3,null,null);
        ArrayList<ArrayList<Integer>> arrayLists = new 求二叉树的层序遍历().levelOrder(treeNode);
        arrayLists.forEach(one->{
            one.forEach(in->{
                System.out.print(in+",");
            });
            System.out.println();
        });
    }

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

}
