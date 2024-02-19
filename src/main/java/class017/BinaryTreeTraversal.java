package class017;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

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
        System.out.println("==============");
        post2(treeNode1);
        System.out.println("==============");
        List<Integer> integers = preorderTraversal2(treeNode1);
        System.out.println("integers = " + integers);
        List<Integer> integers1 = inorderTraversal(treeNode1);
        System.out.println("==============");
        System.out.println("integers1 = " + integers1);
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

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.value);
            if (pop.left != null) {
                stack.push(pop.right);
            }
            if (pop.right != null) {
                stack.push(pop.left);
            }
        }

    }

    public static void mid(TreeNode head) {

        // 1、将左树所有节点放在栈里面
        // 2、弹出栈顶，同时如果弹出的节点的有左树，重复1
        // 3、如果栈为空，结束

        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    public static void post(TreeNode head) {

        if (head == null) {
            return;
        }

        // 先序遍历是中左右，后序遍历是左右中，那么先中右左，然后用一个栈收集，最后统一打印，就是左中右


        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        Stack<TreeNode> collect = new Stack<>();
        while (!stack.isEmpty()) {

            TreeNode pop = stack.pop();
            collect.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!collect.isEmpty()) {
            TreeNode pop = collect.pop();
            System.out.println(pop.value);
        }
    }

    public static void post2(TreeNode head) {

        if (head == null) {
            return;
        }

        // 后序遍历是 左右中，用一个h来记录当前处理的位置，一开始是head，来判断当前有没有处理完左树和右树，处理完之后就可以处理自己的节点了。

        TreeNode h = head;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {

            TreeNode peek = stack.peek();
            // 判断处理完左树了吗,左树没有被处理完的标志是左树和右数都没有被处理，如果没有右数被处理的判断，会重复进入把分支认为左树没有被处理
            if (peek.left != null && h != peek.left && h != peek.right) {
                // 有左树，并且左树还没有被处理
                stack.push(peek.left);
            } else if (peek.right != null && h != peek.right) {
                // 有右树，并且右树还没有被处理
                stack.push(peek.right);
            } else {
                h = stack.pop();
                System.out.println(h.value);
            }


        }

    }

    static List<Integer> result = new ArrayList<>();


    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.value);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return result;

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.value);
                root = root.right;
            }
        }

        return result;

    }


}