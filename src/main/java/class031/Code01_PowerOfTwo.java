package class031;

public class Code01_PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (-n)) == n;


    }
}
