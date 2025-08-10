package easy;

public class Longest_Common_Prefix_14 {
    public static void main(String[] args) {
        runTest(new String[]{"flower", "flow", "flight"}, "fl");
        runTest(new String[]{"dog", "racecar", "car"}, "");
        runTest(new String[]{"interspecies", "interstellar", "interstate"}, "inters");
        runTest(new String[]{"throne", "throne"}, "throne");
        runTest(new String[]{"throne", "dungeon"}, "");
        runTest(new String[]{"prefix", ""}, "");
        runTest(new String[]{"alone"}, "alone");
        runTest(new String[]{"", ""}, "");
        runTest(new String[]{"Case", "cAsE"}, "");
        runTest(new String[]{"flow", "flower"}, "flow");
        runTest(new String[]{"флот", "флора", "флотилия"}, "фло");
        runTest(new String[]{"😀abc", "😀abx", "😀ab"}, "😀ab");
        runTest(new String[]{"space bar", "space shuttle", "space"}, "space");
        runTest(new String[]{"a", "a", "a"}, "a");

        // Короткий вывод для длинных строк
        String longA = "a".repeat(100_000);
        String longB = "a".repeat(99_999) + "b";
        runTestCompact(new String[]{longA, longB}, "a".repeat(99_999));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = strs[0].length();
        for (String s : strs) {
            if (s.length() < minLength) {
                minLength = s.length();
            }
        }

        for (int i = 0; i < minLength; i++) {
            char commonLetter = strs[0].charAt(i);
            for (String s : strs) {
                if (commonLetter != s.charAt(i)) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(commonLetter);
        }
        return commonPrefix.toString();
    }
    private static void runTest(String[] input, String expected) {
        String result = longestCommonPrefix(input);
        boolean pass = expected.equals(result);
        System.out.printf("%s Input: %s%n  Expected: \"%s\"%n  Actual:   \"%s\"%n%n",
                pass ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(input),
                expected,
                result);
    }

    private static void runTestCompact(String[] input, String expected) {
        String result = longestCommonPrefix(input);
        boolean pass = expected.equals(result);
        System.out.printf("%s [Compact Test] Inputs lengths: [%d, %d], Expected length: %d, Actual length: %d%n%n",
                pass ? "✅ PASS" : "❌ FAIL",
                input[0].length(),
                input[1].length(),
                expected.length(),
                result.length());
    }
}
