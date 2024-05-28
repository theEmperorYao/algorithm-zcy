package class030;

public class Code05_DoubleNumber {

    public static int[] singleNumber(int[] nums) {
        int eor1 = 0;
        for (int num : nums) {
            eor1 ^= num;
        }

        // eor1:a^b
        // Brian Kernighan算法
        // 找到 a^b 取出二进制里面第一个1

        int rightOne = eor1 & (-eor1);
        int eor2 = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                eor2 ^= num;
            }
        }
        return new int[]{eor2, eor2 ^ eor1};

    }
}
