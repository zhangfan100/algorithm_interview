package erchashu;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class 按层次从上到下打印二叉树 {

    public static Map<Integer, List<Integer>> result = new HashMap<>();

    public static void main(String[] args) {
        TreeNode data = new TreeNode(9,
                new TreeNode(5, null, null), new TreeNode(6,
                new TreeNode(4, null, new TreeNode(0,null,null)), new TreeNode(2, null,
                new TreeNode(1,null,null))));
        new 按层次从上到下打印二叉树().collectData(data,1);
        printD();

    }

    private static void printD() {
        boolean sequence = false;
        int level = 1;
        List<Integer> list = null;
        while ((list = result.get(level)) != null){
            ListIterator<Integer> iterator = list.listIterator();
            if (sequence = (!sequence)){
                // 顺序打
                while(iterator.hasNext()){
                    System.out.print(iterator.next()+",");
                }
                System.out.println();
            }else{
                while(iterator.hasNext()){
                    iterator.next();
                }
                while(iterator.hasPrevious()){
                    System.out.print(iterator.previous()+",");
                }
                System.out.println();
            }
            level++;
        }

    }

    public void collectData(TreeNode node, int level){
        if (node == null){
            return;
        }
        List<Integer> list = result.get(level);
        if (list == null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            result.put(level, temp);
        } else {
            list.add(node.val);
        }
        int t = level+1;
        if (node.left != null){
            collectData(node.left,t);
        }
        if (node.right != null){
            collectData(node.right,t);
        }
    }
}
