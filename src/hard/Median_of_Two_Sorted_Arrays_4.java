package hard;

/**
 * Класс {@code hard.Median_of_Two_Sorted_Arrays_4} реализует решение задачи №4 на LeetCode —
 * нахождение медианы двух отсортированных массивов.
 * <p>
 * Примеры использования представлены в методе {@code main}, где выводится:
 * <ul>
 *     <li>Ожидаемый результат (Right answer)</li>
 *     <li>Фактически полученный результат (Received response)</li>
 * </ul>
 * <p>
 * Медиана — это центральное значение в упорядоченном наборе чисел. Если общее количество элементов нечётное,
 * медиана — это центральный элемент. Если чётное — это среднее значение двух центральных элементов.
 */
public class Median_of_Two_Sorted_Arrays_4 {

    /**
     * Метод демонстрирует вызовы {@link #findMedianSortedArrays(int[], int[])} с тестовыми данными.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("Right answer: 2.0 Received response: " + findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println("Right answer: 2.5 Received response: " + findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println("Right answer: 1.0 Received response: " + findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println("Right answer: 2.0 Received response: " + findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 2, 4, 4}));
        System.out.println("Right answer: 2.5 Received response: " + findMedianSortedArrays(new int[]{}, new int[]{2, 3}));
    }


    /**
     * Возвращает медиану двух отсортированных целочисленных массивов.
     * Метод использует классический подход слияния двух отсортированных массивов
     * до середины, после чего вычисляется медиана.
     *
     * @param nums1 первый отсортированный массив
     * @param nums2 второй отсортированный массив
     * @return медианное значение объединённого массива из двух входных
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }


        int countNums1 = 0;
        int countNums2 = 0;

        int mergedArrayLength = nums1.length + nums2.length;
        int[] mergedArray = new int[mergedArrayLength / 2 + 1];


        int indexMiddleElement = 0;
        boolean natural = false;

        if (mergedArrayLength % 2 != 0) {
            indexMiddleElement = mergedArrayLength / 2;
        }

        if (mergedArrayLength % 2 == 0) {
            indexMiddleElement = mergedArrayLength / 2 - 1;
            natural = true;
        }

        for (int i = 0; i < mergedArrayLength; i++) {
            if (mergedArrayLength == 1) {
                return nums1.length != 0 ? nums1[0] : nums2[0];
            }

            if (!natural && (i > indexMiddleElement)) {
                return mergedArray[i - 1];
            }

            if (natural && (i > indexMiddleElement + 1)) {
                return (double) ((mergedArray[mergedArrayLength / 2 - 1]) + (mergedArray[mergedArrayLength / 2])) / 2;

            }

            if (countNums1 < nums1.length && countNums2 < nums2.length) {
                if (nums1[countNums1] < nums2[countNums2]) {
                    mergedArray[i] = nums1[countNums1];
                    ++countNums1;
                    continue;
                }
                if (nums1[countNums1] > nums2[countNums2]) {
                    mergedArray[i] = nums2[countNums2];
                    ++countNums2;
                    continue;
                }
                if (nums1[countNums1] == nums2[countNums2]) {
                    mergedArray[i] = nums1[countNums1];
                    ++countNums1;
                    continue;
                }

            }

            if (countNums1 == nums1.length || nums1.length == 0) {
                mergedArray[i] = nums2[countNums2];
                ++countNums2;
                continue;

            }

            if (countNums2 == nums2.length || nums2.length == 0) {
                mergedArray[i] = nums1[countNums1];
                ++countNums1;
            }
        }

        return (double) ((mergedArray[mergedArrayLength / 2 - 1]) + (mergedArray[mergedArrayLength / 2])) / 2;
    }
}
