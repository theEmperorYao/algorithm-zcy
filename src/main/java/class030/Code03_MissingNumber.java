package class030;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Code03_MissingNumber {

    public static int missingNumber(int[] nums) {

        int eorAll = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++) {
            eorAll ^= i;
            eorHas ^= nums[i];
        }

        eorAll ^= nums.length;
        return eorAll ^= eorHas;

    }
}
