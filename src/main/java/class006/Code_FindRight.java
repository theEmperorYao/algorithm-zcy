package class006;

import java.util.Arrays;
import java.util.Random;

public class Code_FindRight {

    public static void main(String[] args) {


        int n = 100;

        int scope = 10000;

        for (int i = 0; i < 1000000; i++) {
            int[] array = randomArray(n, scope);
            int random = new Random().nextInt(1, scope);
            int right = right(array, random);
            int process = process(array, random);
            if (right != process) {
                int i1 = array[right];
                System.out.println("i1 = " + i1);
                int i2 = array[process];
                System.out.println("i2 = " + i2);
                System.out.println("error！！！");
            }
        }
        System.out.println("全部完成!!!");

    }

    public static int[] randomArray(int n, int scope) {
        int[] arr = new int[new Random().nextInt(n)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(1, scope + 1);
        }
        Arrays.sort(arr);
        return arr;
    }


    public static int process(int[] arr, int num) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;
        int result = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 这里之所以将= 也划分进来，是有可能重复的数，然后继续像左去找
            if (arr[mid] > num) {
                right = mid - 1;
            } else if (arr[mid] <= num) {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }

    //    <=num 最右的位置
    public static int right(int[] arr, int num) {


        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                result = i;
            }
        }
        return result;
    }

}
