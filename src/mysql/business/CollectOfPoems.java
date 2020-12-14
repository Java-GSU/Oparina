package mysql.business;

import java.util.*;

public class CollectOfPoems {
    public static List<String> listPoems;
    public static char interestChar;


    CollectOfPoems(String text, char interestChar) {
        listPoems = Arrays.asList(text.split("(\\*+)"));
        CollectOfPoems.interestChar = interestChar;

    }

    public static String printMaxPoem() {
        String poemSelected = "";

        for (String poem : listPoems) {

            if ((getCountInetrestChar(poem) > 2)) {
                poemSelected = poem;
            }
        }
        return poemSelected;
    }

    public static String printMinPoem() {
        String poemSelected = "";

        for (String poem : listPoems) {

            if ((getCountInetrestChar(poem) == 1)) {
                poemSelected = poem;
            }
        }
        return poemSelected;
    }

    private static int getCountInetrestChar(String content) {

        int charArray = (int) content.chars().filter(x -> x == interestChar).count();

        return charArray;
    }
}