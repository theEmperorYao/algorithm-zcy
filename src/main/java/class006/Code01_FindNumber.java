package class006;

import java.util.Arrays;
import java.util.Random;

public class Code01_FindNumber {

    public static void main(String[] args) {

        int times = 10000;
        int size = 100;
        for (int i = 0; i < times; i++) {
            int[] array = randomArray(size, new Random().nextInt(1, 100));
            Arrays.sort(array);
            if (exist(array, 99) != right(array, 99)) {
                System.out.println("error！！！");
            }

        }

        System.out.println("全部完成");


    }

    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (num < arr[mid]) {
                right = mid - 1;
            } else if (num > arr[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Random().nextInt(1, v + 1);
        }
        return arr;
    }

    public static boolean right(int[] sortedArr, int num) {
        return Arrays.stream(sortedArr).anyMatch(cur -> cur == num);
    }

}
