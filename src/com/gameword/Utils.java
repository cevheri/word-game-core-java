package com.gameword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Util for main application
 *
 * @author cevheri.bozoglan
 */
public class Utils {
    /**
     * saved list set because this list is unique
     */
    public static final Set<String> WORD_LIST = new HashSet<>();

    /**
     * check numeric
     *
     * @param str check string
     * @return true or false
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * The func that checks whether the entered word begins with the first letter of the last word.
     *
     * @param lastWord    entering Last word
     * @param currentWord cmd input current word
     * @return return true or false
     */
    public static boolean startLastChar(String lastWord, String currentWord) {
        return currentWord.startsWith(lastWord.substring(lastWord.length() - 1));
    }

    /**
     * Controls characters such as period, comma in the entered value
     *
     * @param str in string
     * @return true or false
     */
    public static boolean isAlphanumeric(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
