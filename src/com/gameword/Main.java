package com.gameword;

import java.util.*;

/**
 * The program is word game.
 * Check current word first character
 * from last word last character
 *
 * @author cevher
 * @ref : https://www.javatpoint.com/simple-program-of-java
 * https://beginnersbook.com/2013/05/first-java-program/
 */
public class Main {

    // saved word list
    private static final List<String> wordList = new ArrayList<String>();

    // check numeric
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

    // The func that checks whether the entered word begins with the first letter of the last word.
    private static boolean startLastChar(String lastWord, String currentWord) {
        return currentWord.startsWith(lastWord.substring(lastWord.length() - 1));
    }

    // Controls characters such as period, comma in the entered value
    public static boolean isAlphanumeric(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println ("Welcome to Wordplay \n" +
                "Please Enter One Word \n" +
                "To exit, leave 'q' or space! ..");
        String lastWord = "";

        // The loop is established so that the program is in a continuous flow.
        while (true) {

            String currentWord = "";

            // If an error is received while making the entered word upper
            // the user is prompted to re-enter the data.
            try {
                // data is read from the user
                currentWord = in.nextLine().toUpperCase();
            } catch (Exception ex) {
                System.out.println ("The value you entered is incorrect. \n" +
                        "Please Try Again! \n" +
                        "Keyword:" + currentWord);
                continue;
            }

            // exit rules from the program are written.
            // If q, null, spaces are given, the program quits.
            if (currentWord.equals("q") || currentWord.equals("Q") || currentWord.equals(null) || currentWord.equals("")) {
                System.out.println("Exiting the game!...");
                System.out.println(wordList);
                System.exit(0);
            }

            // warning is given if the entered word is number
            if (isNumeric(currentWord)) {
                System.out.println ("The value you enter cannot be a number. \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);
                continue;
            }

            // characters such as periods, commas, etc. are not accepted.
            if (!isAlphanumeric(currentWord)) {
                System.out.println ("The word you entered can only contain letters (a-z)! ... \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);
                continue;
            }

            // the entered word must begin with the last letter of the previous word.
            //! On first entry this control will not work
            // because the previous word is absent.
            if (!(lastWord.equals(null) || lastWord.equals(""))) {
                if (!startLastChar(lastWord, currentWord)) {
                    System.out.println ("The word you enter must begin with the initial letter of the last word \n" +
                            "Please Try Again! \n" +
                            "Last Word You Entered:" + lastWord);
                    continue;
                }
            }

            // has the entered word been used before
            if (wordList.indexOf(currentWord) != -1) {
                System.out.println ("The word you entered was used before. \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);

                continue;
            }

            // the entered word must contain at least two letters.
            if (currentWord.length() < 2) {
                System.out.println ("The word you enter must have at least two letters! ... \n" +
                        "Please Try Again! \n" +
                        "Last Word You Entered:" + lastWord);
                continue;
            }

            lastWord = currentWord;
            wordList.add(currentWord);
        }
    }
}
