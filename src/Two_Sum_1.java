import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        Arrays.stream(Objects.requireNonNull(twoSum(new int[]{11, 7, 15, 2}, 9))).forEach(System.out::println);
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
