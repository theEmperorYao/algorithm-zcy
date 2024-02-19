package class021;


public class MergeSort {


    static int[] help = new int[50];

    public static void mergeSort2(int[] arr) {


        // 思路是每次扩一倍，如果超过总长度，就为总长度。
        // 1,2,4,8,16
//        定义步长
        int n = arr.length - 1;
        for (int l, m, r, step = 1; step < n; step <<= 1) {
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 > n - 1) {
                    break;
                }
                r = Math.min(l + 2 * step - 1, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }

        }

    }


    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {

        int p1 = l;
        int p2 = m + 1;
        int i = l;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = l; j <= r; j++) {
            arr[j] = help[j];
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 31, 43, 1, 53, 31, 5, 371, 39, 1, 1, 53, 31347};

//        mergeSort(arr);

        mergeSort2(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

}
