package strings;

public class Strings {
    private static final int DEFAULT_RADIX = 10;

    public static int toInteger(String s) {
        return toInteger(s, DEFAULT_RADIX);
    }

    public static int toInteger(String s, int radix) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null string");
        }
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException("radix must be between 2 and 36");
        }
        int result = 0;
        boolean negative = false;
        int i = 0;
        int len = s.length();
        if (len > 0) {
            int firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                } else if (firstChar != '+') {
                    throw new NumberFormatException("cannot be");
                }
                if (len == 1) {
                    throw new NumberFormatException("cannot be");
                }
                i++;
            }
            while (i < len) {
                int digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw new NumberFormatException("digit < 0");
                }
                result *= radix;
                result += digit;
            }
        }
        return negative ? -result : result;
    }
}
