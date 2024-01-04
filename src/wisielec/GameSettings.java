package wisielec;

import java.util.Scanner;

public class GameSettings {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public Difficulty chooseDifficulty() {
        System.out.println("Choose your difficulty level");
        System.out.println("1.Easy");
        System.out.println("2.Normal");
        System.out.println("3.Hard");
        Scanner scanner2 = new Scanner(System.in);
        int usersChoice = scanner2.nextInt();
        switch (usersChoice) {
            case 1 -> {
                return Difficulty.EASY;
            }
            case 2 -> {
                return Difficulty.MEDIUM;
            }
            case 3 -> {
                return Difficulty.HARD;
            }
        }
        return Difficulty.MEDIUM;
    }
}
