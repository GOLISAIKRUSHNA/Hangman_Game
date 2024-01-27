import java.util.Scanner;

public class HangmanGame {

    private static final String[] WORDS = {"java", "programming", "computer", "algorithm", "software"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord();
        char[] guessedWord = new char[wordToGuess.length()];
        int tries = 0;

        // Initialize guessedWord with underscores
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word:");
        displayWord(guessedWord);

        while (tries < MAX_TRIES) {
            System.out.println("\nEnter a letter: ");
            char guess = scanner.next().charAt(0);

            if (isLetterInWord(guess, wordToGuess, guessedWord)) {
                System.out.println("Correct guess!");
            } else {
                tries++;
                System.out.println("Incorrect guess! You have " + (MAX_TRIES - tries) + " tries left.");
            }

            displayWord(guessedWord);

            if (isWordGuessed(guessedWord)) {
                System.out.println("Congratulations! You've guessed the word.");
                break;
            }
        }

        if (tries == MAX_TRIES) {
            System.out.println("Sorry, you've run out of tries. The word was: " + wordToGuess);
        }
    }

    private static String getRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }

    private static void displayWord(char[] guessedWord) {
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private static boolean isLetterInWord(char letter, String wordToGuess, char[] guessedWord) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                guessedWord[i] = letter;
                found = true;
            }
        }
        return found;
    }

    private static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}
