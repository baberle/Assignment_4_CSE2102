import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountE {

    public static void printEOccurance(String s) {
        // check that there is an input string
        if(s==null)throw new RuntimeException("entered null string");
        // call countChars to get count of each letter in an array
        int[] letterArr = countChars(s);
        // pint occurances of e, the 4th letter in the array
        System.out.println("Number of occurrences of e: " + letterArr[4]);
        return;
    }

    public static int[] countChars(String s) {
        // A = 65, Z = 90
        // a = 97, z = 122
        // initialize array to hold letter counts
        // index 0 is a and 25 is z
        int[] letterArr = new int[26];
        // loop through characters in string to count the letters
        for (int i = 0; i < s.length(); i++) {
            // get the ascii value of the character
            int ascii = (int) s.charAt(i);
            // if lowercase, subtract 97 to get correct array index for letter and add 1
            // if uppercase, subtract 65 to gert correct array index for letter and add 1
            // don't increase array value if not a letter
            if (ascii >= 97 & ascii <= 122) {
                ascii = ascii - 97;
                letterArr[ascii] = letterArr[ascii] + 1;
            } else if (ascii >= 65 & ascii <= 90) {
                ascii = ascii - 65;
                letterArr[ascii] = letterArr[ascii] + 1;
            }
        }
        // return the array of letter counts
        return letterArr;
    }

    public static void breakUpWeb(String s) {
        //System.out.println(s);
        // are there any other conditions I should check for?
        String[] stringArr = s.split("\\.");
        for (int i = 0; i < stringArr.length; i++) {
            if(i == 0) {
                String[] front = stringArr[i].split("//");
                int j = front.length - 1;
                System.out.println(front[j]);
            } else {
                System.out.println(stringArr[i]);
            }
        }
        return;
    }

    public static void removeDuplicates(String s) {
        // check that there is an input string
        if(s==null)throw new RuntimeException("entered null string");
        // initialize output string
        String out = "";
        // initialize previous character to check for duplicates
        char prevChar = 0;
        // loop through characters in string to check for duplicates
        for (int i = 0; i < s.length(); i++) {
            // get current character
            char at = s.charAt(i);
            // only add to output if not a duplicate of previous character
            if (prevChar != at) {
                out = out + at;
            }
            // current char is now previous char
            prevChar = at;
        }
        // print the edited string
        System.out.println(out);
        return;
    }

    public static void calculateFractions(String s) {
        // check that there is an input string
        if(s==null)throw new RuntimeException("entered null string");
        // call countChars to get count of each letter in an array
        int[] letterArr = countChars(s);
        // get the number of letters in the array to use in ratio
        double count = 0;
        for (int i = 0; i < letterArr.length; i++) count += letterArr[i];
        // loop through each letter in array to print data on it
        for (int i = 0; i < letterArr.length; i++) {
            // print the letter, number of the letter, and fraction of total
            System.out.print((char)(i+65) + " count: " + letterArr[i] + ".");
            System.out.println(" Fraction of total: " + (double)letterArr[i]/count);
        }
        return;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // get file from input argument, absolute path required
        File file = new File(args[0]);
        // create scanner to get each line from text file
        Scanner sc = new Scanner(file);
        // execute the first function to return the occurrence of each character
        System.out.println("----------------------------");
        System.out.println("Occurrence the letter e");
        System.out.println("----------------------------");
        // if the text file doesn't have a new line to read, throw exception
        if(!sc.hasNextLine())throw new RuntimeException("Invalid number of input arguments");
        printEOccurance(sc.nextLine());
        // execute the second function to break up a url by the '.' character
        System.out.println("----------------------------");
        System.out.println("break up URL");
        System.out.println("----------------------------");
        if(!sc.hasNextLine())throw new RuntimeException("Invalid number of input arguments");
        breakUpWeb(sc.nextLine());
        // execute the third function to return a string without consecutive duplicates
        System.out.println("----------------------------");
        System.out.println("remove duplicates from string");
        System.out.println("----------------------------");
        if(!sc.hasNextLine())throw new RuntimeException("Invalid number of input arguments");
        removeDuplicates(sc.nextLine());
        // execute the fourth function to return the percent occurrence of each character
        System.out.println("----------------------------");
        System.out.println("Percent occurrence of each character");
        System.out.println("----------------------------");
        if(!sc.hasNextLine())throw new RuntimeException("Invalid number of input arguments");
        calculateFractions(sc.nextLine());
    }
}
