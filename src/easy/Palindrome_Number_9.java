package easy;

public class Palindrome_Number_9 {
    public static void main(String[] args) {
//        // Примеры из условия
        runTest(121, true);
        runTest(-121, false);
        runTest(10, false);

        // Базовые случаи
        runTest(0, true);
        runTest(7, true);
        runTest(11, true);
        runTest(12, false);

        // Чётная/нечётная длина
        runTest(1221, true);
        runTest(1231, false);
        runTest(12321, true);
        runTest(1001, true);
        runTest(1002, false);

        // Нули в конце
        runTest(100, false);
        runTest(21120, false);

        // Нули внутри
        runTest(10201, true);

        // Границы int
        runTest(Integer.MIN_VALUE, false);
        runTest(Integer.MAX_VALUE, false);

        // Крупные значения в допустимом диапазоне
        runTest(2147447412, true);  // палиндром близко к MAX_VALUE
        runTest(2147447413, false); // рядом, но не палиндром
        runTest(2000000002, true);
        runTest(1000000001, true);
        runTest(1000000000, false);
        runTest(123454321, true);

        // Однозначные числа
        for (int i = 0; i <= 9; i++) runTest(i, true);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x > 0 && x < 10) {
            return true;
        }

        String orig = String.valueOf(x);

        byte lastLetterIndex = (byte) (orig.length() - 1);
        for (byte i = 0; i < orig.length() / 2; i++) {
            if (orig.charAt(i) != orig.charAt(lastLetterIndex)) {
                return false;
            }
            --lastLetterIndex;

        }

        return true;
    }


    private static void runTest(int input, boolean expected) {
        boolean result;
        try {
            result = isPalindrome(input);
        } catch (Throwable t) {
            System.out.printf("❌ ERROR Input: %d%n  Expected: %s%n  Error: %s%n%n",
                    input, expected, t);
            return;
        }
        boolean pass = (result == expected);
        System.out.printf("%s Input: %d%n  Expected: %s%n  Actual:   %s%n%n",
                pass ? "✅ PASS" : "❌ FAIL",
                input, expected, result);
    }
}