package class027;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Code01_MergeKSortedLists {

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }


    }

    public static void main(String[] args) {
//        mergeKList(new ArrayList<>());
    }


    public static ListNode mergeKList(ListNode[] lists) {

        var priorityQueue = Stream.of(lists).filter(Objects::nonNull)
                .collect(Collectors.toCollection(() -> new PriorityQueue<>((Comparator.comparingInt(o -> o.val)))));

        if (priorityQueue.isEmpty()) {
            return null;
        }

        var h = new ListNode(0);
        var cur = h;
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
            Optional.ofNullable(cur.next).ifPresent(priorityQueue::offer);
        }

        return h.next;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }

        if (priorityQueue.isEmpty()) {
            return null;
        }

        ListNode h;
        ListNode pre;
        ListNode poll = priorityQueue.poll();
        pre = poll;
        h = poll;
        if (poll.next != null) {
            priorityQueue.offer(poll.next);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                priorityQueue.offer(cur.next);
            }
        }

        return h;
    }


}
