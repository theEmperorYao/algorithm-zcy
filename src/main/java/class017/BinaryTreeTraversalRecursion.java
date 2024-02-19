package class017;


public class BinaryTreeTraversalRecursion {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;


        pre(treeNode1);
        System.out.println("==============");
        mid(treeNode1);
        System.out.println("==============");
        post(treeNode1);
    }

    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

    }

    public static void pre(TreeNode head) {

        if (head == null) {
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);

    }

    public static void mid(TreeNode head) {

        if (head == null) {
            return;
        }
        mid(head.left);
        System.out.println(head.value);
        mid(head.right);

    }

    public static void post(TreeNode head) {

        if (head == null) {
            return;
        }
        post(head.left);
        post(head.right);
        System.out.println(head.value);

    }


}
