package wisielec;

public class Main {
    // 	    5. Tabela wyników(punkty na podstawie czasu i poprawnych strzałów)
    public static void main(String[] args) {

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
