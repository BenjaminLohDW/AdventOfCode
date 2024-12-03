import java.io.*;
import java.util.*;

public class Day1Part1 {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

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
                list2.add(Integer.parseInt(tempArr[1]));
            }

            // for (int i = 0; i < list1.size(); i++) {
            // System.out.println("This is list1: " + list1.get(i));
            // }

            // for (int i = 0; i < list2.size(); i++) {
            // System.out.println("This is list2: " + list2.get(i));
            // }

            Collections.sort(list1);
            Collections.sort(list2);

            int total = 0;

            for (int i = 0; i < list1.size(); i++) {
                total += Math.abs(list1.get(i) - list2.get(i));
            }

            System.out.println("Total difference is: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}