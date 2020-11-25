package Scrabble;

import java.io.File;
import java.util.*;

/**
 * Scrabble.ScrabbleScorer.java takes in a Scrabble word from the user, validates it for Scrabble, then returns its score if it's valid.
 * @version 11/19/2020
 * @author 22tanaka
 */
public class ScrabbleScorer {

    private ArrayList<String> dictionary = new ArrayList<>();
    private String letters;
    private String[] points;

    /**
     *
     */
    public ScrabbleScorer() {
    }

    /**
     *
     */
    public void buildDictionary() {
        Scanner scrabbleWords = null;
        try {
            scrabbleWords = new Scanner(new File("datafiles/SCRABBLE_WORDS_STOLEN_FROM_THE_INTERNET.txt"));
            while (scrabbleWords.hasNext())
                dictionary.add(scrabbleWords.nextLine());
            Collections.sort(dictionary);

            letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String tempPoints = "1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10";
            points = tempPoints.split(",");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Checks if the user-inputted word is a valid Scrabble word
     *
     * @param word, the user-inputted word
     * @return the validity of String word as a Scrabble word
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) > 0;
    }

    /**
     * @param word, the user-inputted word
     * @return the score of String word
     */
    public int getWordScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += Integer.parseInt(points[letters.indexOf(word.charAt(i))]);
        }
        return score;
    }

    /**
     * Main method for class ISBNValidator
     *
     * @param args, command line arguments, if needed
     */
    public static void main(String[] args) {
        Scanner inWord = new Scanner(System.in);
        ScrabbleScorer app = new ScrabbleScorer();
        app.buildDictionary();

        System.out.println("* Welcome to the Scrabble Word Scorer app *");

        while (true) {
            try {
                System.out.print("Enter a word to score or 0 to quit: ");
                String word = inWord.nextLine().toUpperCase();
                if (word.toLowerCase().equals("0")) {
                    System.out.println("Exiting the program thanks for playing");
                    break;
                } else if (app.isValidWord(word))
                    System.out.println(word.toLowerCase() + " = " + app.getWordScore(word) + " points");
                else
                    System.out.println(word.toLowerCase() + " is not a valid word in the dictionary");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}