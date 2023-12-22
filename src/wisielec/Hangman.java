package wisielec;
import java.util.Scanner;
public class Hangman {
    private int points;

    private Password password;
    private boolean isGuessed = false;
    private int lives;
    private char[] currentState;

    public Hangman(Difficulty difficulty) {
        String fileName = "";
        switch (difficulty){
            case EASY -> {this.lives = 10;
            fileName = "Keys.txt";}
            case MEDIUM -> {this.lives = 6;
            fileName ="KeysMedium.txt";}
            case HARD -> {this.lives = 3;
            fileName ="KeysHard.txt";}
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


    public void play() {

        showHiddenPassword();
        while (lives > 0 && !isGameWon()) {
            isLetterThere();
            if (isGuessed) {
                System.out.println("You guessed a letter!");
            } else {
                System.out.println(getHangmanDrawing(lives));
                lives--;
                System.out.println("Try again! You have " + lives + " lives left");
            }
        }
        if (isGameWon()) {
            System.out.println("Congratulations you won!");
        } else System.out.println("You lost!");
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






