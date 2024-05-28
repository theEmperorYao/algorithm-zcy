package class031;

// 返回n的二进制中有几个1
// 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离
// 测试链接 : https://leetcode.cn/problems/hamming-distance/
public class Code06_CountOnesBinarySystem {

    public static int hammingDistance(int x, int y) {
        return cntOnes(x ^ y);
    }

    // 返回n的二进制中有几个1
    // 这个实现脑洞太大了
    public static int cntOnes(int n) {
        // 10010010 01001001
        // 01010101 01010101
        // 00010000+01000001 = 01010001
        // 01010001 00010100
        // 00110011 00110011
        // 00010001+00010000 = 00100001
        // 00100001 00000010
        // 00001111 00001111
        // 00000001 00000010 = 00000011
        //
        // 0000000011111111
        //分别统计为1的段，为2的段，为4，8，,16的段上有几个1

        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);


        return n;
    }

}
