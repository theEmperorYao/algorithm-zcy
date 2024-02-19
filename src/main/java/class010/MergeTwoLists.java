package class010;

// 将两个升序链表合并为一个新的 升序 链表并返回
// 新链表是通过拼接给定的两个链表的所有节点组成的
// 测试链接 : https://leetcode.cn/problems/merge-two-sorted-lists/
public class MergeTwoLists {

//    public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }


    static class ListNode {
        ListNode next;
        int val;
    }

    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    public static ListNode process(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode cur = head;


        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }

        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }

        return head.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.val = 1;
        node2.val = 5;
        node3.val = 6;
        node1.next = node2;
        node2.next = node3;

        ListNode node1_1 = new ListNode();
        ListNode node2_2 = new ListNode();
        ListNode node3_3 = new ListNode();
        node1_1.val = 1;
        node2_2.val = 2;
        node3_3.val = 5;
        node1_1.next = node2_2;
        node2_2.next = node3_3;

        ListNode process = process(node1, node1_1);

        while (process != null) {
            int value = process.val;
            System.out.println("value = " + value);
            process = process.next;
        }


    }


}
