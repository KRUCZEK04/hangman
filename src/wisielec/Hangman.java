package wisielec;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private int goodGuesses;
    private int badGuess;
    private Password password;
    private boolean isGuessed = false;
    private int lives;
    private char[] currentState;
    private long gameTime;

    @Override
    public String toString() {
        return "Hangman{" +
                "gameTime=" + gameTime +
                ", playerName='" + playerName + '\'' +
                ", points=" + points +
                ", localDate=" + localDate +
                '}';
    }


    private long timeStart;
    private String chosenDifficulty;
    private PointsCalculator pointsCalculator = new PointsCalculator();
    private String playerName;
    private int points;
    private LocalDate localDate;

    public Hangman(Difficulty difficulty) {
        String fileName = "";
        switch (difficulty) {
            case EASY -> {
                this.lives = 10;
                fileName = "Keys.txt";
                this.chosenDifficulty = "Easy";
            }
            case MEDIUM -> {
                this.lives = 6;
                fileName = "KeysMedium.txt";
                this.chosenDifficulty = "Medium";
            }
            case HARD -> {
                this.lives = 3;
                fileName = "KeysHard.txt";
                this.chosenDifficulty = "Hard";
            }
        }
        this.password = new Password(fileName);
        this.currentState = new char[password.getValue().length()];

    }

    public void showHiddenPassword() {
        for (int i = 0; i < password.getValue().length(); i++) {
            System.out.print("_");
            currentState[i] = '_';
        }
    }


    public void play() throws IOException {
        System.out.println("Enter your players name");
        Scanner scanner = new Scanner(System.in);
        this.playerName = scanner.nextLine();
        timeStart = System.currentTimeMillis();
        showHiddenPassword();
        while (lives > 0 && !isGameWon()) {
            isLetterThere();
            if (isGuessed) {
                System.out.println("You guessed a letter!");
                goodGuesses++;
            } else {
                System.out.println(getHangmanDrawing(lives));
                lives--;
                badGuess++;
                System.out.println("Try again! You have " + lives + " lives left");
            }
        }
        this.gameTime = (System.currentTimeMillis() - timeStart) / 1000;
        this.localDate = LocalDate.now();
        FileSaver fileSaver = new FileSaver();
        if (isGameWon()) {
            saveResultsToFile(fileSaver);
        } else {
            System.out.println("You lost!");
            this.points = pointsCalculator.calculatePointLost(goodGuesses, gameTime,badGuess, chosenDifficulty);
            ResultsTable resultsTable2 = new ResultsTable(playerName, points, localDate, gameTime);
            fileSaver.saveToFile(resultsTable2);
        }
    }

    private void saveResultsToFile(FileSaver fileSaver) throws IOException {
        this.points = pointsCalculator.calculatePointsWon(gameTime, badGuess, chosenDifficulty);
        ResultsTable resultsTable = new ResultsTable(playerName, points, localDate, gameTime);
        fileSaver.saveToFile(resultsTable);
        System.out.println("Congratulations you won!");
    }

    public void isLetterThere() {
        isGuessed = false;
        String guess = giveALetter().toLowerCase();
        char[] charArray = password.getValue().toLowerCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == guess.charAt(0)) {
                currentState[i] = guess.charAt(0);
                isGuessed = true;
            }
        }
        showState();
        System.out.println();
    }

    public boolean isGameWon() {
        return new String(currentState).toLowerCase().equals(password.getValue().toLowerCase());
    }

    public void showState() {
        for (int i = 0; i < password.getValue().length(); i++) {
            System.out.print(currentState[i]);
        }
    }

    private String giveALetter() {
        System.out.println("\nEnter your guessed letter");
        Scanner scanner = new Scanner(System.in);
        String guessdLetter = scanner.nextLine();
        if (guessdLetter == "") {
            System.out.println("You cant leave your answer empty!");
            return scanner.nextLine();
        } else {
            return guessdLetter;
        }
    }

    public String getHangmanDrawing(int incorrectGuessCount) {
        switch (incorrectGuessCount) {
            case 6:
                return "  _______\n |       |\n O       |\n         |\n         |\n         |\n_________|";
            case 5:
                return "  _______\n |       |\n O       |\n |       |\n         |\n         |\n_________|";
            case 4:
                return "  _______\n |       |\n O       |\n/|       |\n         |\n         |\n_________|";
            case 3:
                return "  _______\n |       |\n O       |\n/|\\      |\n         |\n         |\n_________|";
            case 2:
                return "  _______\n |       |\n O       |\n/|\\      |\n/        |\n         |\n_________|";
            case 1:
                return "  _______\n |       |\n O       |\n/|\\      |\n/ \\      |\n         |\n_________|";
            default:
                return "";
        }
    }

}






