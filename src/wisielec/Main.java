package wisielec;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // 	    5. Tabela wyników(punkty na podstawie czasu i poprawnych strzałów)
    public static void main(String[] args) throws IOException {

       GameSettings gameSettings = new GameSettings();
        Difficulty difficulty = gameSettings.chooseDifficulty();
        Hangman hangman = new Hangman(difficulty);
             hangman.play();


//        for (; ; ) {
//            hangman.showHiddenPassword();
//            hangman.isLetterThere();
//            System.out.println();
//
//        }
    }
}
