package class027;

import java.io.*;
import java.util.Arrays;

public class Code02_MaxCover {

    public static int MAXN = 10001;

    public static int[][] line = new int[MAXN][2];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                line[i][0] = (int) in.nval;
                in.nextToken();
                line[i][1] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }

    // 小根堆，堆顶0位置
    public static int[] heap = new int[MAXN];

    // 堆的大小
    public static int size;

    public static int compute() {
        size = 0;
        Arrays.sort(line, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < line.length; i++) {
            int left = line[i][0];
            int right = line[i][1];
            while (size > 0 && heap[0] <= left) {
                pop();
            }
            add(right);
            ans = Math.max(size, ans);
        }

        return ans;
    }

    public static void add(int x) {
        heap[size] = x;
        int i = size++;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }

    }

    public static void pop() {
        swap(0, --size);
        int i = 0, l = 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best, i);
            i = best;
            l = i * 2 + 1;
        }

    }

    private static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


}
