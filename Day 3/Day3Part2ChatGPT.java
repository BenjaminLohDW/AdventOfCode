import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Day3Part2ChatGPT {
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

    public static int checkMult(String line) {
        int total = 0;

        // Regex to match "mul(x, y)" where x and y are integers
        String regex = "mul\\((\\d+),(\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        // Find all matches in the line
        while (matcher.find()) {
            try {
                // Extract numbers as integers
                int firstNum = Integer.parseInt(matcher.group(1));
                int secondNum = Integer.parseInt(matcher.group(2));

                // Add their product to the total
                total += firstNum * secondNum;
            } catch (NumberFormatException e) {
                // Handle unexpected number parsing errors
                System.err.println("Invalid number format in: " + matcher.group());
            }
        }

        return total;
    }

    public static int checkMult2(String line) {
        int total = 0;

        String startStr = "do()";
        String endStr = "don't()";

        int lowerBound = line.indexOf(startStr);
        int upperBound = line.indexOf(endStr);

        if (upperBound == -1) {
            // No "don't()" means process the whole line
            total += checkMult(line);
        } else {
            // If "do()" comes after "don't()" or doesn't exist, process up to "don't()"
            if (lowerBound > upperBound || lowerBound == -1) {
                total += checkMult(line.substring(0, upperBound));
                
                // If "do()" does exist, process the substring from "do()" onwards
                if (lowerBound != -1) {
                    total += checkMult2(line.substring(lowerBound + startStr.length()));
                }
            } else {
                // If "do()" comes before "don't()", process between bounds
                if (lowerBound != -1) {
                    total += checkMult2(line.substring(lowerBound + startStr.length()));
                }
            }
        }

        return total;
    }
}
