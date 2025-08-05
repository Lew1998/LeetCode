public class Median_of_Two_Sorted_Arrays_4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 2, 4, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int countNums1 = 0;
        int countNums2 = 0;

        int mergedArrayLength = nums1.length + nums2.length;
        int[] mergedArray = new int[mergedArrayLength];

        for (int i = 0; i < mergedArrayLength; i++) {

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

            if (countNums1 == nums1.length) {
                mergedArray[i] = nums2[countNums2];
                ++countNums2;
                continue;

            }

            if (countNums2 == nums2.length) {
                mergedArray[i] = nums1[countNums1];
                ++countNums1;
            }
        }

        if (mergedArrayLength % 2 != 0) {
            return mergedArray[mergedArrayLength / 2];
        } else {
            return (double) ((mergedArray[mergedArrayLength / 2 - 1]) + (mergedArray[mergedArrayLength / 2])) / 2;
        }
    }
}
