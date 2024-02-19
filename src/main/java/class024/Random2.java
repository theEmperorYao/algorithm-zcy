package class024;

public class Random2 {

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 2);
        System.out.println("kthLargest = " + kthLargest);
    }


    static int first, last;

    public static int findKthLargest(int[] arr, int k) {
        return randomized(arr, arr.length - k);
    }

    public static int randomized(int[] arr, int k) {

        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r; ) {
            int random = l + (int) ((r - l + 1) * Math.random());
            partition(arr, l, r, arr[random]);
            System.out.println(k);
            if (k < first) {
                r = first - 1;
            } else if (k > last) {
                l = last + 1;
            } else {
                ans = arr[k];
                break;
            }
        }
        return ans;
    }

    public static void partition(int[] arr, int l, int r, int random) {

        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == random) {
                i++;
            } else if (arr[i] < random) {
                swap(arr, i++, first++);
            } else {
                swap(arr, i, last--);
            }
        }
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
