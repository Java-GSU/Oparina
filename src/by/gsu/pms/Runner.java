package by.gsu.pms;

import by.gsu.pms.BusinessTrip;
import by.gsu.pms.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.gsu.pms.Util.*;

public class Runner {

    public static String Rate;

    public Runner() {
    }

    public static int getRate() {
        return Integer.parseInt(Rate);
    }

    public static void main(String[] args) throws IOException {
        try {
            Scanner sc = new Scanner(new FileReader("src/in(1).txt"));
            String[] rate = sc.nextLine().split(" *= *");
            Rate = rate[1];
            System.out.println("RATE = " + convertMoney(Integer.parseInt(rate[1])));
            String[] ids = sc.nextLine().split(" *= *");
            String[] arr = ids[1].split(" *; *");
            int[] index = new int[arr.length];

            for(int i = 0; i < arr.length; ++i) {
                index[i] = Integer.parseInt(arr[i]);
            }

            BusinessTrip[] trips = new BusinessTrip[arr.length];

            for(int i = 0; i < trips.length; ++i) {
                trips[i] = new BusinessTrip();
            }

            int ind;
            int i;
            while(sc.hasNextLine()) {
                String[] array = sc.nextLine().trim().split(" *= *");
                if (isMatcher(array[0], "(account|transport|days)(\\d+)")) {
              //      if (isMatcher(array[1], args[0]))
//                         {
//                        array[1] = array[1].replace(args[0], args[1]);
//                    }

                    ind = Integer.parseInt(getGroup(array[0], "\\d+"));
                    i = Arrays.binarySearch(index, ind);
                    if (i >= 0) {
                        String el = getGroup(array[0], "account|transport|days").toUpperCase();
                        trips[i] = Util.getElement(trips[i], el, array[1]);
                    }
                }
            }

            Arrays.sort(trips);
            BusinessTrip[] var15 = trips;
            i = trips.length;

            for(ind = 0; ind < i; ++ind) {
                BusinessTrip trip = var15[ind];
                System.out.println(trip);
            }
        } catch (FileNotFoundException var11) {
            System.out.println("file not found");
        }

    }

    private static boolean isMatcher(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    private static String getGroup(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        String result = "";
        if (matcher.find()) {
            result = matcher.group();
        }

        return result;
    }


}



