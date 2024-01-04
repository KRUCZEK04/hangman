package wisielec;

public class PointsCalculator {
    private long points;

    public int calculatePointsWon(long time, int badGuesses, String chosenDifficulty) {
        if (chosenDifficulty.equals("Easy")) {
            points = (200 - 5 * badGuesses) - time;
        } else if (chosenDifficulty.equals("Medium")) {
            points = (300 - 5 * badGuesses) - time;
        } else {
            points = (400 - 5 * badGuesses) - time;
        }
        return Math.toIntExact(points);
    }

    public int calculatePointLost(int goodGuesses, long time, int badGuesses, String chosenDifficulty) {
        if (chosenDifficulty.equals("Easy")) {
            points = ((20 * goodGuesses) - (5 * badGuesses)) - time;
        } else if (chosenDifficulty.equals("Medium")) {
            points = ((30 * goodGuesses) - (5 * badGuesses)) - time;
        } else {
            points = ((40 * goodGuesses) - (5 * badGuesses)) - time;
        }
        return Math.toIntExact(points);

    }
}
