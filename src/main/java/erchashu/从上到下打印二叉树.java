package erchashu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 *         9
 *        / \
 *       5   6
 *          / \
 *         4   2
 *          \    \
 *           0    1
 * <p>
 * 打印
 * [9,5]
 * [9,6,4]
 * [9,6,2,1]
 */
public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        TreeNode data = new TreeNode(9,
                new TreeNode(5, null, null), new TreeNode(6,
                new TreeNode(4, null, new TreeNode(0,null,null)), new TreeNode(2, null,
                                          new TreeNode(1,null,null))));
        List<DateType> result = new ArrayList<DateType>();
        new 从上到下打印二叉树().printData(data, result);
        printTnode(result);
    }

    private static void printTnode(List<DateType> result) {
        ListIterator<DateType> iterator = result.listIterator();
        // 作用是 遍历到最后去
        while (iterator.hasNext())
            iterator.next();
        while (iterator.hasPrevious()) {
            DateType next = iterator.previous();
            if (next.type == DateType.LEAF) {
                Iterator<DateType> it = result.iterator();
                // 打印
                while (it.hasNext()) {
                    DateType innerData = it.next();
                    if (innerData.data == next.data) {
                        System.out.println(innerData.data);
                        break;
                    }
                    if (innerData.type == DateType.NOTLEAF) {
                        System.out.print(innerData.data + ",");
                    }
                }
            }
        }
    }

    public void printData(TreeNode node, List<DateType> data) {
        if (node != null) {
            if (node.left != null && node.right != null) {
                data.add(new DateType(DateType.NOTLEAF, node.val));
                printData(node.left, data);
                printData(node.right, data);
            } else if (node.left != null) {
                data.add(new DateType(DateType.NOTLEAF, node.val));
                printData(node.left, data);
            } else if (node.right != null) {
                data.add(new DateType(DateType.NOTLEAF, node.val));
                printData(node.right, data);
            } else {
                // leaf
                data.add(new DateType(DateType.LEAF, node.val));
            }
        }
    }

    static class DateType {
        int type; //1 表示叶子   2 表示非叶子
        int data;

        static int LEAF = 1;
        static int NOTLEAF = 2;

        public DateType(int type, int data) {
            this.type = type;
            this.data = data;
        }
    }
}
