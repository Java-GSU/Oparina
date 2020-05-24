import by.gsu.pms.MultipleSummation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Runner {
    private static void getSumNeighbors(ArrayList<MultipleSummation> nums) {
        int [] tmp;
        if (nums.length == 2) {
            System.out.println("Промежуточные значения сумм: " + Arrays.toString(nums));
            System.out.println("Окончательная сумма = " + (nums[0] + nums[1]));
            return;
        }
        System.out.println("Промежуточные значения сумм: " + Arrays.toString(nums));
        int highLimitIndexTmp;
        if (nums.length%2 == 0) {
            tmp = new int[nums.length/2];
            highLimitIndexTmp = tmp.length;
        }
        else {
            tmp = new int[nums.length/2 + 1];
            highLimitIndexTmp = tmp.length - 1;
            tmp[highLimitIndexTmp] = nums[nums.length - 1];
        }

        int j = 0;
        for (int i = 0; i < highLimitIndexTmp; i++) {
            tmp[i] = nums[j] + nums[j + 1];
            j+=2;
        }

        getSumNeighbors(tmp);
    }


  public static void main(String[] args) throws IOException {

        ArrayList<MultipleSummation> nums = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Number.csv"));

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {

            String[] params = currentLine.split(";");


            getSumNeighbors(nums);

        }
        bufferedReader.close();

        // Sort
        Collections.sort(nums);


        // Write
        File csvFile = new File("src/sorted_numbers.csv");
        try (PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFile))){
            for(MultipleSummation number : nums){
                csvWriter.println(number);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }



     //   private static int [] arr = {1,2,3,4,5,6,7,8};


        private static void getSumNeighbors(ArrayList<MultipleSummation> nums) {
            int [] tmp;
            if (nums.length == 2) {
                System.out.println("Промежуточные значения сумм: " + Arrays.toString(nums));
                System.out.println("Окончательная сумма = " + (nums[0] + nums[1]));
                return;
            }
            System.out.println("Промежуточные значения сумм: " + Arrays.toString(nums));
            int highLimitIndexTmp;
            if (nums.length%2 == 0) {
                tmp = new int[nums.length/2];
                highLimitIndexTmp = tmp.length;
            }
            else {
                tmp = new int[nums.length/2 + 1];
                highLimitIndexTmp = tmp.length - 1;
                tmp[highLimitIndexTmp] = nums[nums.length - 1];
            }

            int j = 0;
            for (int i = 0; i < highLimitIndexTmp; i++) {
                tmp[i] = nums[j] + nums[j + 1];
                j+=2;
            }

            getSumNeighbors(tmp);
        }
}

