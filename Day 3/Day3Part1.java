import java.io.*;
import java.util.*;

public class Day3Part1 {
    public static void main(String[] args) {
        String fileStr = "test.txt";

        File input = new File(fileStr);

        try {
            Scanner fileIn = new Scanner(input);

            int total = 0;

            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();

                total += checkMult(line);
            }

            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int checkMult(String line) {
        int total = 0;
        return total;
    };
}
