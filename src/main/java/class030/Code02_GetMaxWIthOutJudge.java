package class030;

public class Code02_GetMaxWIthOutJudge {


    public static int flip(int n) {
        return n ^ 1;
    }

    //非负数返回1，负数返回0
    public static int sign(int n) {
        return flip(n >>> 31);
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        // 判断A和B，符号是不是不一样，如果不一样diffAB=1，如果一样diffAB=0
        int diffAB = sa ^ sb;
        // 判断A和B，符号是不是一样，如果一样sameAB=0，如果不一样same=1
        int sameAB = flip(diffAB);

        //满足返回a的条件，如果a和b的符号一样，c不为负数，或者 a和b的符号不一样，a是非负数
        int returnA = diffAB * sa + sameAB * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void main(String[] args) {
        int max = getMax(Integer.MIN_VALUE, -1000);
        System.out.println("max = " + max);
    }

}
