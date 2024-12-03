import java.io.*;
import java.util.*;

public class Day3Part1 {
    public static void main(String[] args) {
        String fileStr = "input.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);

            int total = 0;

            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();

                total += checkMult(line);
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
}
