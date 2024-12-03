import java.io.*;
import java.util.*;

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

    public static int checkMult(String line) {
        int total = 0;

        // First part: Find the substring "mul("

        String mulStr = "mul(";

        int currentIndex = line.indexOf(mulStr);

        if (currentIndex != -1) {

            String firstNumStr = "";

            currentIndex += mulStr.length();

            char currentChar = line.charAt(currentIndex);

            while (currentChar != ',') {
                if (Character.isDigit(currentChar)) {
                    firstNumStr += currentChar;
                    currentIndex++;
                    currentChar = line.charAt(currentIndex);
                } else {
                    firstNumStr = "";
                    break;
                }
            }

            if (firstNumStr != "") {
                int firstNum = Integer.parseInt(firstNumStr);

                // Current at ',', so need to add 1 more to the index
                String secondNumStr = "";

                currentIndex += 1;

                currentChar = line.charAt(currentIndex);

                while (currentChar != ')') {
                    if (Character.isDigit(currentChar)) {
                        secondNumStr += currentChar;
                        currentIndex++;
                        currentChar = line.charAt(currentIndex);
                    } else {
                        secondNumStr = "";
                        break;
                    }
                }

                if (secondNumStr != "") {
                    int secondNum = Integer.parseInt(secondNumStr);

                    total += firstNum * secondNum;
                }

                total += checkMult(line.substring(currentIndex));

            } else {
                total += checkMult(line.substring(currentIndex));
            }
        }
        return total;
    };

    public static int checkMult2(String line) {
        int total = 0;

        String startStr = "do()";

        String endStr = "don't()";

        int lowerBound = line.indexOf(startStr);
        int upperBound = line.indexOf(endStr);

        // There is no substring called "don't()", meaning we execute all mul() in the whole line
        if (upperBound == -1) {
            total += checkMult(line);

        // Check position of "don't()" relative to "do()", whether it's before or after
        } else {

            // If "do()" comes after "don't()", we execute all muls until "don't()", then recursively check the substring after "do()" for more muls
            if (lowerBound > upperBound) {

                total += checkMult(line.substring(0, upperBound));
                total += checkMult2(line.substring(lowerBound + startStr.length()));

            // If "do()" comes before "don't()", we need to check more things
            } else {

                // If "do()"" doesn't exist at all, we only check for muls until the "don't()", and forget about the rest of the string 
                if (lowerBound == -1) {
                    total += checkMult(line.substring(0, upperBound));

                // else, we ignore this "do()" and just make a substring so we can find the next "do()" 
                } else {
                    total += checkMult2(line.substring(lowerBound + startStr.length()));
                }
            }
        }

        return total;
    }
}
