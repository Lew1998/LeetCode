import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс {@code Two_Sum_1} реализует решение задачи "Two Sum" (№1 на LeetCode),
 * в которой требуется найти индексы двух чисел из массива, сумма которых равна заданному числу.
 * <p>
 * Пример:
 * Вход: nums = [11, 7, 15, 2], target = 9
 * Выход: [1, 3], так как nums[1] + nums[3] = 7 + 2 = 9
 */
public class Two_Sum_1 {
    public static void main(String[] args) {
        test(new int[]{11, 7, 15, 2}, 9, new int[]{1, 3});
        test(new int[]{3, 2, 4}, 6, new int[]{1, 2});
        test(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1});
        test(new int[]{3, 3}, 6, new int[]{0, 1});
    }

    private static void test(int[] nums, int target, int[] expected) {
        int[] result = twoSum(nums, target);
        System.out.println("вход: " + Arrays.toString(nums) + ", цель: " + target);
        System.out.println("ожидание: " + Arrays.toString(expected) + ", реальность: " + Arrays.toString(result));
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numAndIndexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int temp1 = nums[i];
            Integer indexSecondNumber = numAndIndexMap.get(target - temp1);

            if ((indexSecondNumber != null) && (!indexSecondNumber.equals(i))) {
                return new int[]{i, indexSecondNumber};
            }
        }
        return null;
    }
}
