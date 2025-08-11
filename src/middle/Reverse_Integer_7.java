package middle;

public class Reverse_Integer_7 {
    public static void main(String[] args) {
        runTest(123, 321);              // обычный случай
        runTest(-123, -321);            // отрицательное число
        runTest(120, 21);               // с нулём на конце
        runTest(0, 0);                  // ноль
        runTest(1, 1);                  // однозначное число
        runTest(-1, -1);                // однозначное отрицательное
        runTest(1534236469, 0);         // переполнение при реверсе ( > 2^31-1 )
        runTest(-1534236469, 0);        // переполнение при реверсе ( < -2^31 )
        runTest(1463847412, 2147483641); // граница, но без переполнения
        runTest(-1463847412, -2147483641); // отрицательная граница, но без переполнения
    }


    public static int reverse(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        boolean isPisitive = false;
        if (stringBuilder.charAt(0) == '-') {
            stringBuilder.deleteCharAt(0);
            stringBuilder.append('-');
            stringBuilder.reverse();
        } else {
            isPisitive = true;
            stringBuilder.reverse();
        }
        long tempL = Long.parseLong(stringBuilder.toString());
        if (isPisitive) {
            if (tempL > Integer.MAX_VALUE){
                return 0;
            }
        } else {
            if (tempL < Integer.MIN_VALUE){
                return 0;
            }
        }
        return Integer.parseInt(stringBuilder.toString());
    }


    private static void runTest(int input, int expected) {
        int result;
        try {
            result = reverse(input);
        } catch (Exception e) {
            System.out.printf("❌ Exception for input %d: %s%n", input, e);
            return;
        }
        boolean pass = result == expected;
        System.out.printf("%s Input: %d%n  Expected: %d%n  Actual:   %d%n%n",
                pass ? "✅ PASS" : "❌ FAIL", input, expected, result);
    }
}

// TODO по скорости можно улучшить с 2ms до 0 - 1 (
