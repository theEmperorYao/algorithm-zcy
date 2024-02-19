package class003;

public class BinarySystem {
    public static void main(String[] args) {

        // 负数转为正数二进制 先看正数二进制，减去1，取反
        // 0000 0000 0000 0000 0000 0000 0000 0101
        // 1111 1111 1111 1111 1111 1111 1111 1011

        // 如何用二进制表示整数的，用int类型举例
        int a = 0b00000000000000000000000000000101;
        printBinaryNum(-a);
        System.out.println(-a);

        int b = -100;
        int b1 = ~b + 1;
        System.out.println("b1 = " + b1);


        printBinaryNum(4);

        int c = 0b10000000000000000000000000000100;
        printBinaryNum(c >> 1);

    }

    // 打印一个int类型的数字，32位进制的状态
    // 左侧是高位，右侧是低位

    public static void printBinaryNum(int num) {

        for (int i = 31; i >= 0; i--) {
            System.out.print(((num & (1 << i)) == 0 ? "0" : "1") + " ");
        }
        System.out.println();

    }
}
