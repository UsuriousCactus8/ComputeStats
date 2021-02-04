package com.company;
import java.io.File;                    // Import the File class
import java.io.FileNotFoundException;   //Import class to handle exceptions
import java.util.Scanner;               //Import Scanner class to read text files.

public class ComputeStats
{

    public static void main(String[] args)
    {
        //Initialise variables.
        int lineCount = 0;
        int lineWordCount; int totalWordCount = 0;
        int totalLetterCount= 0;
        double averageNumberOfLetterPerWord;
        int[] frequencyAnalysisArray = new int[26];
        char mostCommonLetter;
        File fileObj;
        Scanner fileReader = null;

        try //See if it can find the file.
        {
            fileObj = new File(args[0]); // If you want to hardcode the path, change what's inside the brackets to "filename and path" for example "E:\\Users\\Bob\\Documents\\test.txt"
            fileReader = new Scanner(fileObj);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file specified was not located.");
            e.printStackTrace();
            System.exit(0); //File was not found, exit the program.
        }

        while (fileReader.hasNextLine())
            {

                lineCount++;    //This will calculate the number of lines by keeping a counter of how many times it goes to a new line.

                String data = fileReader.nextLine().toUpperCase(); //to uppercase to make the frequency analysis easier, as we're using ASCII mapping.
                if(!data.isBlank()) {
                    //Split the string to get the words, then count them.
                    String[] splitData = data.split("\\s+"); // \\s+ is the syntax for whitespace as desired from specification
                    lineWordCount = splitData.length;
                    totalWordCount = totalWordCount + lineWordCount;
                    //System.out.println(data); //This is if you want it to display the text

                    /**
                     Count all the letters (THIS HAS BEEN REPLACED, LETTERS ARE NOW COUNTED BELOW AS PART OF FREQUENCY ANALYSIS
                     lineLetterCount = data.replaceAll("\\s+", "").length();;
                     totalLetterCount = totalLetterCount + lineLetterCount;
                     **/

                    //Perform frequency analysis
                    for (char c : data.toCharArray()) {
                        int indexFinder = ((int) c) - 65; //turning the char into an Int gives it's ASCII value (which for the alphabet is 65=-90), the -65 is to match the index 0-25
                        if (indexFinder >= 0 && indexFinder <= 25 /**ASCII range for capital letters**/) {
                            frequencyAnalysisArray[indexFinder]++;
                            totalLetterCount++;
                        }
                    }
                }
            }

            int highestIndex = 0; // Initialise variable to keep a running total of what the max is.
            //Go through the array of and find which letter is used most
            for (int i = 0; i < frequencyAnalysisArray.length; i++)
            {
                if (frequencyAnalysisArray[i] > frequencyAnalysisArray[highestIndex])
                {
                    highestIndex = i;
                }
            }

            //Now calculate the average using total word count and total letter count
            averageNumberOfLetterPerWord = (double)totalLetterCount / (double)totalWordCount; //cast to double to keep accurate decimal

        //Display the results
        System.out.println( "\nLine Count: " + lineCount +
                            "\nWord Count: " + totalWordCount +
                            "\nAverage Letter Per Word: " + Math.round(averageNumberOfLetterPerWord));

        System.out.println("Most Common Letter(s): ");
        //In case there are multiple most common letters, run through this loop to show them all.
        for (int i = 0; i < frequencyAnalysisArray.length; i++)
        {
            if(frequencyAnalysisArray[i] == frequencyAnalysisArray[highestIndex])
            {
                mostCommonLetter = (char)(i + 65);
                System.out.print(mostCommonLetter + " ");
            }

        }
    }
}
