package class002;

import java.util.Arrays;
import java.util.Random;

// 一开始有100个人，每个人都有100元
// 在每一轮都做如下的事情 :
// 每个人都必须拿出1元钱给除自己以外的其他人，给谁完全随机
// 如果某个人在这一轮的钱数为0，那么他可以不给，但是可以接收
// 发生很多很多轮之后，这100人的社会财富分布很均匀吗？
public class Experiment {

    public static void main(String[] args) {
        int n = 100;
        int times = 100000;
        experiment(n, times);

    }

    private static void experiment(int n, int times) {

        double[] wealth = new double[n];
        Arrays.fill(wealth, 100);

        boolean[] hasMoney = new boolean[n];
        for (int i = 0; i < times; i++) {

            Arrays.fill(hasMoney, false);
            for (int j = 0; j < n; j++) {
                if (wealth[j] > 0) {
                    hasMoney[j] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                if (hasMoney[j]) {
                    int random = new Random().nextInt(n);
                    while (random == j) {
                        random = new Random().nextInt(n);
                    }
                    wealth[random]++;
                    wealth[j]--;
                }

            }
        }
        Arrays.sort(wealth);

        for (int i = 0; i < n; i++) {
            System.out.print((int) wealth[i] + " ");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        double v = calculateGini(wealth);
        System.out.println("基尼系数为：" + v);
    }

    public static double calculateGini(double[] wealth) {
        double sumOfAbsoluteDifferences = 0;
        double sumOfWealth = 0;
        int n = wealth.length;
        for (double v : wealth) {
            sumOfWealth += v;
            for (double value : wealth) {
                sumOfAbsoluteDifferences += Math.abs(v - value);
            }
        }
        return sumOfAbsoluteDifferences / (2 * n * sumOfWealth);
    }

}
