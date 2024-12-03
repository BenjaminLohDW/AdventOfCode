import java.io.*;
import java.util.*;

public class Day2Part2 {
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

                if (checkReport2(reportList)) {
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

    public static boolean checkReport(ArrayList<Integer> reportList) {
        ArrayList<Integer> differences = new ArrayList<Integer>();

        for (int i = 0; i < reportList.size() -1; i++){
            differences.add(reportList.get(i) - reportList.get(i + 1));
        }

        List<Integer> ascRange = Arrays.asList(1, 2, 3);
        List<Integer> descRange = Arrays.asList(-3, -2, -1);

        return ascRange.containsAll(differences) || descRange.containsAll(differences);
    }

    public static boolean checkReport2(ArrayList<Integer> reportList) {
        if (!checkReport(reportList)) {
            for (int j = 0; j < reportList.size(); j++) {
                ArrayList<Integer> subList = new ArrayList<>(reportList);

                subList.remove(j);
    
                if (checkReport(subList)) {
                    return true;
                };
            };
            return false;
        } else {
            return true;
        }
    }
    // public static boolean checkReport(ArrayList<Integer> reportList, boolean buffer) {
        

    //     // System.out.println(reportList);

    //     boolean isIncreasing = false;
    //     boolean isDecreasing = false;
    //     boolean hasBuffer = buffer;
    //     int tempCounter = 0;
    //     int currentNum;
    //     int nextNum;
    //     int difference;

    //     while (!(isDecreasing && isIncreasing)) {
    //         if (tempCounter == reportList.size() - 1) {
    //             break;
    //         } else {
    //             currentNum = reportList.get(tempCounter);
    //             // System.out.println("This is the current number: " + currentNum);
    //             nextNum = reportList.get(tempCounter + 1);
    //             // System.out.println("This is the next number: " + nextNum);

    //             difference = nextNum - currentNum;
    //             // System.out.println("This is the difference: " + Math.abs(difference));

    //             if (Math.abs(difference) > 3 || Math.abs(difference) < 1) {
    //                 // System.out.println("Difference too big");
    //                 if (hasBuffer) {
    //                     ArrayList<Integer> reportListCopy1 = new ArrayList<Integer>(reportList);
    //                     ArrayList<Integer> reportListCopy2 = new ArrayList<Integer>(reportList);

    //                     reportListCopy1.remove(tempCounter);

    //                         System.out.println("Current report looks like this: " + reportListCopy1);

    //                     if (checkReport(reportListCopy1, false)) {
    //                         System.out.println("Sucess for copy 1, solved big difference");
    //                         break;
    //                     } else {
    //                         reportListCopy2.remove(tempCounter + 1);
    //                         // System.out.println("Current report looks like this: " + reportListCopy2);
    //                         if (checkReport(reportListCopy2, false)) {
    //                             System.out.println("Sucess for copy 2, solved big difference");
    //                             break;
    //                         }
    //                     };
    //                     // System.out.println("Getting rid of this number: " +
    //                     // reportList.get(tempCounter + 1));
    //                 }
    //                 isDecreasing = true;
    //                 isIncreasing = true;

    //             } else if (difference < 0) {
    //                 // System.out.println("difference < 0");
    //                 isDecreasing = true;
    //             } else if (difference > 0) {
    //                 // System.out.println("difference > 0");
    //                 isIncreasing = true;
    //             }

    //             if (isDecreasing && isIncreasing && hasBuffer) {
    //                 // current difference negative, means rest of difference was positive
    //                 ArrayList<Integer> reportListCopy1 = new ArrayList<Integer>(reportList);
    //                 ArrayList<Integer> reportListCopy2 = new ArrayList<Integer>(reportList);

    //                 reportListCopy1.remove(tempCounter);

    //                 System.out.println("Current report looks like this: " + reportListCopy1);

    //                 if (checkReport(reportListCopy1, false)) {
    //                     System.out.println("Sucess for copy 1, solved interchanging difference");
    //                     isDecreasing = false;
    //                     isIncreasing = false;
    //                     break;
    //                 } else {
    //                     reportListCopy2.remove(tempCounter + 1);

    //                     System.out.println("Current report looks like this: " + reportListCopy2);

    //                     if (checkReport(reportListCopy2, false)) {
    //                         System.out.println("Sucess for copy 2, solved interchanging difference");
    //                         isDecreasing = false;
    //                         isIncreasing = false;
    //                         break;
    //                     }
    //                 };
    //             }

    //         }
    //         tempCounter++;
    //     }

    //     // System.out.println("Is it increasing: " + isIncreasing);
    //     // System.out.println("Is it decreasing: " + isDecreasing);

    //     if (!(isDecreasing && isIncreasing)) {
    //         // System.out.println("Adding report number " + totalReports + " to safe
    //         // reports");
    //         // System.out.println("add to safereports");
    //         return true;
    //     }
    //     return false;
    // }


}