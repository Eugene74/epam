package stream;

/*
вы вести уникальные имена с большой буквы
                [IVAN, NASTIA]
 */

import java.util.Arrays;
import java.util.List;

public class UniqNameToUpperCase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ivan", "", "    ", null, "ivan", "nastya");
        System.out.println("--------imperative-----------");
        for (String s : names) {
            if (testUniqueNames(s)) {
                System.out.println(s.toUpperCase());
            }
        }

        System.out.println("--------stream-----------");
        for (String s : names) {
            if (checkStringForAllLetterUsingStream(s)) {
                System.out.println(s.toUpperCase());
            }
        }
    }

    private static boolean testUniqueNames(String name) {
        boolean isLetter = false;
        if (name != null && name.length() > 0) {
            for (int i = 0; i < name.length(); i++) {
                if ((name.charAt(i) >= 65 && name.charAt(i) <= 90)
                        || (name.charAt(i) >= 97 && name.charAt(i) <= 122)) {
                    isLetter = true;
                } else {
                    return false;
                }
            }
        }
        return isLetter;
    }

    public static boolean checkStringForAllLetterUsingStream(String input) {
        long tmp;
        if (input != null && input.length() != 0) {
            tmp = input.chars()
                    .filter(ch -> ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
                    .count();
        } else {
            return false;
        }
        return input.length() == tmp;
    }
}
