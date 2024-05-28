package class027;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code03_MinimumOperationsToHalveArraySum {

    public static int halveArray1(int[] nums) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for (int num : nums) {
            priorityQueue.add((double) num);
            sum += num;
        }

        sum /= 2;
        int ans = 0;
        double cur = 0;
        while (!priorityQueue.isEmpty()) {
            Double half = priorityQueue.poll() / 2;
            priorityQueue.offer(half);
            System.out.println(half);
            cur += half;
            ans++;
            if (cur >= sum) {
                break;
            }

        }
        return ans;
    }

    public static int MAXXN = 100001;
    public static long[] heap = new long[MAXXN];
    public static int size;

    public static int halveArray2(int[] nums) {

        size = nums.length;
        long sum = 0;
        //构建堆
        for (int i = size - 1; i >= 0; i--) {
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum /= 2;

        int ans = 0;
        for (long minus = 0; minus < sum; ans++) {
            heap[0] /= 2;
            minus += heap[0];
            heapify(0);
        }

        return ans;


    }

    private static void heapify(int i) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = l + 1 < size && heap[l] < heap[l + 1] ? l + 1 : l;
            best = heap[best] < heap[i] ? i : best;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j) {
        long tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }


    public static void main(String[] args) {

        int[] nums = {1, 3, 4};
        int i = halveArray1(nums);
        int i1 = halveArray2(nums);
        System.out.println("i1 = " + i1);
        System.out.println("i = " + i);
    }
}
