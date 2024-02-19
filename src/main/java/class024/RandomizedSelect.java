package class024;

public class RandomizedSelect {

//    process()

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("kthLargest = " + kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

    public static int first, last;

    static int randomizedSelect(int[] arr, int i) {

        int ans = 0;

        for (int l = 0, r = arr.length - 1; l <= r; ) {
            int random = arr[l + (int) (Math.random() * (r - l + 1))];
            partition(arr, l, r, random);

            if (i < first) {
                r = first - 1;
            } else if (i > r) {
                l = last + 1;
            } else {
                ans = arr[i];
                break;
            }
        }

        return ans;

    }

    private static void partition(int[] arr, int l, int r, int random) {

        first = l;
        last = r;
        int i = l;
        while (i <= last) {

            if (arr[i] == random) {
                i++;
            } else if (arr[i] < random) {
                swap(arr, first++, i++);
            } else {
                swap(arr, i, last--);
            }

        }
    }

    private static void swap(int[] arr, int a, int i) {
        int temp = arr[a];
        arr[a] = arr[i];
        arr[i] = temp;
    }

}
