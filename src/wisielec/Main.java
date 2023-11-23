package wisielec;

public class Main {
    //TODO:	1. Walidacja błędów
    //	    2. Hasła losowane z pliku
    //      2.5 Rysowanie wisielca
    //	    3. Kategorie haseł
    //	    4. Poziom trudności ( mniej żyć, trudniejsze hasła)
    // 	    5. Tabela wyników(punkty na podstawie czasu i poprawnych strzałów)


    public static void main(String[] args) {
        Hangman hangman = new Hangman("KRUCZEKKK");
        hangman.play();


//        for (; ; ) {
//            hangman.showHiddenPassword();
//            hangman.isLetterThere();
//            System.out.println();
//
//        }
    }
}
