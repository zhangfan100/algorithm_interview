class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode head = new TreeNode(-1);   // 为了返回单向链表的头节点而多设的一个节点
    TreeNode perv = null;               // 指向当前节点的前一个节点

//    public TreeNode convertBiNode(TreeNode root) {
//        helper(root);
//        return head.right;
//    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (perv == null) {     // 第一个节点
            perv = root;        // 记录第一个节点
            head.right = root;  // 记录它，它将作为单链表的表头
        } else {                // 第一个节点之后的节点
            perv.right = root;  // 前一个节点的右指针指向当前节点
            perv = root;        // 更新perv指向
        }
        root.left = null;       // 当前节点的左指针设为null
        helper(root.right);
    }


    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        // 开始中序遍历
        inorder(root,head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root,TreeNode prev){
        if (root != null){
            prev = inorder(root.left,prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right,prev);
        }
        return prev;
    }


    public static void main(String[] args) {
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn5 = new TreeNode(5);
        TreeNode tn1 = new TreeNode(1);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn6 = new TreeNode(6);
        TreeNode tn0 = new TreeNode(0);

        tn4.left=tn2;
        tn4.right=tn5;

        tn2.left=tn1;
        tn2.right=tn3;

        tn5.right=tn6;

        tn1.left=tn0;

        TreeNode treeNode = new Solution().convertBiNode(tn4);

        System.out.println(tn4);
        System.out.println(treeNode);

    }
}
