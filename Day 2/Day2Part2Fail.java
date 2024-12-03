import java.io.*;
import java.util.*;

public class Day2Part2Fail {
    public static void main(String[] args) {
        String fileStr = "input.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);

            int safeReportsNum = 0;
            int totalReports = 0;

            while (fileIn.hasNext()) {
                totalReports++;

                // System.out.println("Current report number: " + totalReports);

                String line = fileIn.nextLine();

                String[] reportArr = line.split("\\s+");

                ArrayList<Integer> reportList = new ArrayList<Integer>();

                for (int i = 0; i < reportArr.length; i++) {
                    reportList.add(Integer.parseInt(reportArr[i]));
                }

                // System.out.println(reportList);

                boolean isIncreasing = false;
                boolean isDecreasing = false;
                boolean hasBuffer = true;
                int tempCounter = 0;
                int currentNum;
                int nextNum;
                int difference;

                while (!(isDecreasing && isIncreasing)) {
                    if (tempCounter == reportList.size() - 1) {
                        break;
                    } else {
                        currentNum = reportList.get(tempCounter);
                        // System.out.println("This is the current number: " + currentNum);
                        nextNum = reportList.get(tempCounter + 1);
                        // System.out.println("This is the next number: " + nextNum);

                        difference = nextNum - currentNum;
                        // System.out.println("This is the difference: " + Math.abs(difference));

                        if (Math.abs(difference) > 3 || Math.abs(difference) < 1) {
                            // System.out.println("Difference too big");
                            if (hasBuffer) {
                                hasBuffer = false;
                                // System.out.println("Getting rid of this number: " + reportList.get(tempCounter + 1));
                                reportList.remove(tempCounter + 1);
                                tempCounter--;
                            } else {
                                isDecreasing = true;
                                isIncreasing = true;
                            }
                        } else if (difference < 0) {
                            // System.out.println("difference < 0");
                            isDecreasing = true;
                        } else if (difference > 0) {
                            // System.out.println("difference > 0");
                            isIncreasing = true;
                        }

                        if (isDecreasing && isIncreasing && hasBuffer) {
                            // current difference negative, means rest of difference was positive
                            if (difference < 0) {
                                hasBuffer = false;
                                isDecreasing = false;
                                reportList.remove(tempCounter + 1);
                                tempCounter--;
                            // current difference positive, means rest of difference was negative
                            } else {
                                hasBuffer = false;
                                isIncreasing = false;
                                reportList.remove(tempCounter + 1);
                                tempCounter--;
                            }
                        }

                    }
                    tempCounter++;
                }

                // System.out.println("Is it increasing: " + isIncreasing);
                // System.out.println("Is it decreasing: " + isDecreasing);

                if (!(isDecreasing && isIncreasing)) {
                    // System.out.println("Adding report number " + totalReports + " to safe reports");
                    // System.out.println("add to safereports");
                    safeReportsNum++;
                }
            }

            // System.out.println(totalReports);

            System.out.println(safeReportsNum);

            fileIn.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}