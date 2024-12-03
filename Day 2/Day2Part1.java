import java.io.*;
import java.util.*;

public class Day2Part1 {
    public static void main(String[] args) {
        String fileStr = "input.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);

            int safeReportsNum = 0;
            int totalReports = 0;

            while (fileIn.hasNext()) {

                totalReports++;

                String line = fileIn.nextLine();

                String[] reportArr = line.split("\\s+");

                ArrayList<Integer> reportList = new ArrayList<Integer>();

                for (int i = 0; i < reportArr.length; i++) {
                    reportList.add(Integer.parseInt(reportArr[i]));
                }

                // System.out.println(reportList);

                boolean isIncreasing = false;
                boolean isDecreasing = false;
                int tempCounter = 0;
                int currentNum;
                int nextNum;
                int difference;

                while (!(isDecreasing && isIncreasing)) {
                    if (tempCounter == reportList.size()-1) {
                        break;
                    } else {
                        currentNum = reportList.get(tempCounter);
                        nextNum = reportList.get(tempCounter + 1);
                        difference = nextNum - currentNum;
                        // System.out.println("This is the difference: " + Math.abs(difference));

                        if (Math.abs(difference) > 3 || Math.abs(difference) < 1) {
                            // System.out.println("Difference too big");
                            isDecreasing = true;
                            isIncreasing = true;
                        } else if (difference < 0) {
                            // System.out.println("difference < 0");
                            isDecreasing = true;
                        } else if (difference > 0) {
                            // System.out.println("difference > 0");
                            isIncreasing = true;
                        }

                    }
                    tempCounter++;
                }

                // System.out.println("Is it increasing: " + isIncreasing);
                // System.out.println("Is it decreasing: " + isDecreasing);

                if (!(isDecreasing && isIncreasing)) {
                    // System.out.println("add to safereports");
                    safeReportsNum++;
                }
            }

            System.out.println(totalReports);

            System.out.println(safeReportsNum);

            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}