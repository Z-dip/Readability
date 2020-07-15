package readability;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = args[0];
        //System.out.println(fileName);
        String text = new String(Files.readAllBytes(Paths.get(fileName)));
        System.out.println("The text is:");
        System.out.println(text);
        System.out.println();

        int Words = Words(text);
        int Sentences = Sentences(text);
        int Characters = Characters(text);
        double Score = Score(Characters, Words, Sentences);
        double result = Math.ceil(Score);
        String Understanding = Understanding(result);

        System.out.println("Words: " + Words);
        System.out.println("Sentences: " + Sentences);
        System.out.println("Characters: " + Characters);
        System.out.println("The score is: " + Score);
        System.out.println("This text should be understood by " + Understanding +  " year olds.");
    }

    public static String Understanding(double result) {

        switch ((int) result) {
            case 1:
                return "5-6";
            case 2:
                return "6-7";
            case 3:
                return "7-9";
            case 4:
                return "9-10";
            case 5:
                return "10-11";
            case 6:
                return "11-12";
            case 7:
                return "12-13";
            case 8:
                return "13-14";
            case 9:
                return "14-15";
            case 10:
                return "15-16";
            case 11:
                return "16-17";
            case 12:
                return "17-18";
            case 13:
                return "18-24";
            case 14:
                return "24+";
            default:
                return "";
        }
    }

    public static int Words(String text) {
        return text.split(" ").length;
    }
    public static int Sentences(String text) {
        return text.split("\\.|\\?|!").length;
    }
    public static int Characters(String text) {
        return text.replaceAll("\\s+","").length();
    }
    public static double Score (int Characters, int Words, int Sentences) {
        return 4.71 * ((double)Characters / (double)Words) + 0.5 * ((double)Words / (double)Sentences) - 21.43;
    }
}
