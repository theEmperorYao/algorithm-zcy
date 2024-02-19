package class023;

public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {3, 6, 6, 42, 6, 96, 66, 63, 37};

        quick2(ints, 0, ints.length - 1);

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

    }

    public static void quick2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int random = arr[l + (int) (Math.random() * (r - l + 1))];
        int[] ints = partition2(arr, l, r, random);
        int left = ints[0];
        int right = ints[1];

        quick2(arr, l, left - 1);
        quick2(arr, right + 1, r);
    }

    private static int[] partition2(int[] arr, int l, int r, int random) {

        // 给定数组的左右边界 和一个随机数
        // 从左往右遍历，小于随机数的放左边，大于随机数的放右边，等于随机数的不动
        // 返回等于随机数的左右边界


        int a = l;
        int b = r;
        int i = l;
        while (i <= b) {
            if (arr[i] < random) {
                swap(arr, a++, i++);
            } else if (arr[i] > random) {
                swap(arr, b--, i);
            } else {
                i++;
            }
        }
        return new int[]{a, b};


    }


    public static void quick(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int random = arr[l + (int) (Math.random() * (r - l + 1))];
        int m = partition(arr, l, r, random);
        quick(arr, l, m - 1);
        quick(arr, m + 1, r);


    }

    // 划分数组 <=x放左边，>x放右边，并且确保划分完成后<=x区域的最后一个数字是x
    private static int partition(int[] arr, int l, int r, int random) {

        int a = l;
        int result = 0;

        for (int i = l; i <= r; i++) {
            if (arr[i] <= random) {
                swap(arr, a, i);
                if (arr[a] == random) {
                    result = a;
                }
                a++;
            }

        }
        // 保证最后一位是选的随机数，而不是只满足小于它的数
        swap(arr, result, a - 1);
        return a - 1;
    }

    private static void swap(int[] arr, int a, int i) {
        int temp = arr[a];
        arr[a] = arr[i];
        arr[i] = temp;
    }
}
