package class025;

public class HeapSort {

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();
        int[] arr = {3, 1, 3, 2, 6, 17, 41, 541, 41};
        heapSort.heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public void heapSort(int[] arr) {

//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }


        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        int size = arr.length;

        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }


    }


    /**
     *
     * i位置的数 变小了，又想维持大根堆，
     * 向下调整大根堆
     *
     * @param arr
     * @param i
     * @param size
     */
    public void heapify(int[] arr, int i, int size) {

        int l;
        while ((l = i * 2 + 1) < size) {
            int max = l + 1 < size && arr[l] < arr[l + 1] ? l + 1 : l;
            max = arr[max] > arr[i] ? max : i;
            if (max == i) {
                break;
            }
            swap(arr, max, i);
            i = max;
        }

    }

    /**
     * i 位置的数，向上调整大根堆
     *
     * @param arr
     * @param i
     */
    public void heapInsert(int[] arr, int i) {

        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }


    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
