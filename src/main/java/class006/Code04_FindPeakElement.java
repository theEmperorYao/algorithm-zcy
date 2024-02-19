package class006;

// 峰值元素是指其值严格大于左右相邻值的元素
// 给你一个整数数组 nums，已知任何两个相邻的值都不相等
// 找到峰值元素并返回其索引
// 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
// 你可以假设 nums[-1] = nums[n] = 无穷小
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
public class Code04_FindPeakElement {

    public static void main(String[] args) {


        int process = process(new int[]{1, 2, 3, 1});
        System.out.println("process = " + process);

    }

    public static int process(int[] nums) {

        if (nums == null || nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int left = 1, right = nums.length - 2, mid, ans = -1;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }

}
