package class030;

// 数组中只有1种数出现次数少于m次，其他数都出现了m次
// 返回出现次数小于m次的那种数
// 测试链接 : https://leetcode.cn/problems/single-number-ii/
// 注意 : 测试题目只是通用方法的一个特例，课上讲了更通用的情况
public class Code06_OneKindNumberLessMtimes {

    public static int singleNumber(int[] nums) {
        return find(nums, 3);
    }

    // 更通用的方法
    // 已知数组中只有1种数出现次数少于m次，其他数都出现了m次
    // 返回出现次数小于m次的那种数
    public static int find(int[] arr, int m) {
        int[] cnts = new int[32];
        for (int k : arr) {
            for (int j = 0; j < 32; j++) {
                //统计每一位出现次数
                cnts[j] += k >> j & 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] % m != 0) {
                // 将某一位没有出现m次的累计到ans里
                ans |= 1 << i;
            }
        }
        return ans;

    }

}
