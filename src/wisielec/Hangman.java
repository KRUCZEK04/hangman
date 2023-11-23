package wisielec;
//TODO: Hasło do zgadnięcia: obiekt który będzie wpisywany przy starcie programu albo tablice z hasłami (random) - to później.
//TODO: Wisielec będzie się rysował w konsoli (od dołu do góry)
//TODO: Musimy wpisywać i odgadywać litery (____) --> (___A_)
//TODO: Program działa w pętli do momentu jeśli odgadniemy hasło || zostanie ukończony wisielec (skończą nam się życia)

import java.util.Scanner;

//TODO: Obiekty: Password, Hangman, PasswordGueser, LifeChecker
public class Hangman {

    private Password password;
    private boolean isGuessed = false;
    private int lives;
    private char[] currentState;

    public Hangman(String password) {
        this.password = new Password(password);
        this.currentState = new char[password.length()];
        this.lives = 6;
    }

    public void showHiddenPassword() {
        for (int i = 0; i < password.getPassword().length(); i++) {
            System.out.print("_");
            currentState[i] = '_';
        }
    }

    public void play() {
        showHiddenPassword();
        while (lives>0 && !isGameWon() ){
            isLetterThere();
            if (isGuessed) {
                System.out.println("You guessed a letter!");
            } else {
                lives--;
                System.out.println("Try again! You have " + lives + " lives left");
            }
        }
        if (isGameWon()){
            System.out.println("Congratulations you won!");
        }
        else System.out.println("You lost!");
    }

    public void isLetterThere() {
        isGuessed = false;
        String guess = giveALetter();
        char[] charArray = password.getPassword().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == guess.charAt(0)) {
                currentState[i] = guess.charAt(0);
                isGuessed = true;
            }
        }
        showState();
        System.out.println();
    }
    public boolean isGameWon(){
        return new String(currentState).equals(password);
    }

    public void showState() {
        for (int i = 0; i < password.getPassword().length(); i++) {
            System.out.print(currentState[i]);
        }
    }

    private String giveALetter() {
        System.out.println("\nEnter your guessed letter");
        Scanner scanner = new Scanner(System.in);
        String guessdLetter = scanner.nextLine();
        if (guessdLetter==""){
            System.out.println("You cant leave your answer empty!");
            return scanner.nextLine();
        }
        else {
        return guessdLetter;}
    }
}






