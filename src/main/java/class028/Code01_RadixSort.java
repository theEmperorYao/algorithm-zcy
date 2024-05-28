package class028;

import java.util.Arrays;

public class Code01_RadixSort {

    static int BASE = 10;
    static int MAXN = 100001;
    //辅助数组
    static int[] help = new int[MAXN];
    // 目标数组
    static int[] arr = new int[MAXN];
    //统计词频
    static int[] cnts = new int[BASE];


    public void sort(int[] arr) {

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] -= min;
            max = Math.max(max, arr[i]);
        }

        radixSort(arr, bits(max));

        for (int i = 0; i < arr.length; i++) {
            arr[i] += min;
        }


    }


    public static void radixSort(int[] arr, int bits) {


        for (int offset = 1; bits > 0; offset *= BASE, bits--) {

            Arrays.fill(cnts, 0);
            Arrays.fill(help, 0);
            // 1、统计每一位的词频
            for (int value : arr) {
                //数字提取某一位
                cnts[(value / offset) % BASE]++;
            }
            //递增
            for (int i = 1; i < cnts.length; i++) {
                cnts[i] += cnts[i - 1];
            }

            //2、倒序读取数组，放在help数组指定位置，并--

            // 102 203 901
            // [1,2,3]

            for (int i = arr.length - 1; i >= 0; i--) {
                int index = (arr[i] / offset) % BASE;
                help[--cnts[index]] = arr[i];
            }

            // 拷贝回来
            System.arraycopy(help, 0, arr, 0, arr.length);


        }
    }

    public static int bits(int number) {
        int bit = 0;
        while (number > 0) {
            number /= BASE;
            bit++;
        }
        return bit;
    }

    public static void main(String[] args) {
        arr = new int[]{5, 2, 3, 1};

        int asInt = Arrays.stream(arr).max().getAsInt();

        int bits = bits(asInt);

        radixSort(arr, bits);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
