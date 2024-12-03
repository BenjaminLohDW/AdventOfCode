import java.io.*;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        String fileStr = "test.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);

            int total = 0;

            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();

                total += checkMult(line, 0);
            }

            System.out.println(total);
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkMult(String line, int startingIndex) {
        int total = 0;

        // First part: Find the substring "mul("

        String mulStr = "mul(";

        int mulIndex = line.indexOf(mulStr, startingIndex);

        if (mulIndex != -1) {

            String firstNumStr = "";

            int numIndex = mulIndex + mulStr.length();

            char currentChar = line.charAt(numIndex);

            while (currentChar != ',') {
                if (Character.isDigit(currentChar)) {
                    firstNumStr += currentChar;
                    numIndex++;
                    currentChar = line.charAt(numIndex);
                } else {
                    total += checkMult(line, numIndex);
                    break;
                }
            }

            
            int firstNum = Integer.parseInt(firstNumStr);

            // Current at ',', so need to add 1 more to the index
            String secondNumStr = "";

            numIndex += 1;

            currentChar = line.charAt(numIndex);

            while (currentChar != ')') {
                if (Character.isDigit(currentChar)) {
                    firstNumStr += currentChar;
                    numIndex++;
                    currentChar = line.charAt(numIndex);
                } else {
                    total += checkMult(line, numIndex);
                    break;
                }
            }

            int secondNum = Integer.parseInt(secondNumStr);

            total += firstNum * secondNum;

            total += checkMult(line, numIndex);
        }
        return total;
    };
}
