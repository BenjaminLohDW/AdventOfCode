import java.io.*;
import java.util.*;

//HEAVILY INSPIRED BY SOMEONE ELSE'S SOLUTION I FOUND ON SUBREDDIT

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


}