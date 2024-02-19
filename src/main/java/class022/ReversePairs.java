package class022;

public class ReversePairs {

    static int[] help = new int[50001];

    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        System.out.println("maxValue = " + maxValue);

//        int[] arr = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        int[] arr = {1, 3, 2, 3, 1};
        int process = process(arr, 0, arr.length - 1);
        System.out.println("process = " + process);
    }


    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int m = (r - l) / 2 + l;
        return process(arr, l, m) + process(arr, m + 1, r) + smallSum(arr, l, r);

    }

    public static int smallSum(int[] arr, int l, int r) {

        // 4 6 7 7 ， 2，5，7，9
        //   i             j
        int m = (r - l) / 2 + l;
        int ans = 0;
        for (int i = l, j = m + 1, sum = 0; i <= m; i++) {

            while (j <= r && arr[i] > (long) arr[j] * 2) {
//                sum++;
                j++;
            }
            // sum 4
            ans += (j - (m + 1));
        }
        merge(arr, l, m, r);
        return ans;

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


}
