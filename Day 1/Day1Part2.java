import java.io.*;
import java.util.*;

public class Day1Part2 {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        HashMap<Integer, Long> list2 = new HashMap<Integer, Long>();

        String fileStr = "input.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);
            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();

                // System.out.println(line);

                String[] tempArr = line.split("\\s+");

                // System.out.println(tempArr);

                list1.add(Integer.parseInt(tempArr[0]));

                int index = Integer.parseInt(tempArr[1]);

                list2.put(index, list2.getOrDefault(index, 0L) + 1);
            }

            // for (int i = 0; i < list1.size(); i++) {
            // System.out.println("This is list1: " + list1.get(i));
            // }

            // for (int i = 0; i < list2.size(); i++) {
            // System.out.println("This is list2: " + list2.get(i));
            // }

            Long total = 0L;

            for (int i = 0; i < list1.size(); i++) {
                Integer currentNum = list1.get(i);
                Long numAppearance = list2.getOrDefault(currentNum, 0L);
                total += numAppearance * currentNum;
            }

            System.out.println("Total difference is: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}