package strings;

import static java.lang.System.out;

public class StringsTest {
    public static void main(String[] args) {
        out.println(Strings.toInteger("11001110010101", 2));
        out.println(Strings.toInteger("32142"));
        int[] a = new int[0];
        System.out.println(a.length);
    }
}
