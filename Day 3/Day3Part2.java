import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Day3Part2 {
    public static void main(String[] args) {
        String fileStr = "input.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);

            int total = 0;

            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();

                total += checkMult2(line);
            }

            System.out.println(total);
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkMult2(String line) {

        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Pattern pattern = Pattern.compile(regex);
        Pattern innerPattern = Pattern.compile("\\d+");
        boolean mulEnabled = true;
        int total = 0;

        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String match = matcher.group();

            if (match.startsWith("mul(")) {
                if (mulEnabled) {
                    // Matcher innerMatch = innerPattern.matcher(match);
                    Matcher innerMatch = innerPattern.matcher(match);

                    int[] nums = { 0, 0 };
                    int counter = 0;

                    while (innerMatch.find()) {
                        nums[counter] = Integer.parseInt(innerMatch.group());
                        counter++;
                    }

                    total += nums[0] * nums[1];
                }
            } else if (match.equals("do()")) {
                mulEnabled = true;
            } else if (match.equals("don't()")) {
                mulEnabled = false;
            }

            // if (match.equals("do()")) {
            //     mulEnabled = true;
            // } else if (match.equals("don't()")) {
            //     mulEnabled = false;
            // } else if (match.startsWith("mul(")) {
            //     // Matcher innerMatch = innerPattern.matcher(match);
            //     Matcher innerMatch = innerPattern.matcher(match);

            //     int[] nums = { 0, 0 };
            //     int counter = 0;

            //     while (innerMatch.find()) {
            //         nums[counter] = Integer.parseInt(innerMatch.group());
            //         counter++;
            //     }
                
            //     if (mulEnabled) {
            //         total += nums[0] * nums[1];
            //     }
            // }
        }
        return total;

    }
}
