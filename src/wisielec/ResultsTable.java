package wisielec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;

public class ResultsTable {
    private String playerName;

    private int points;

    private LocalDate todayDate;
    private long gameTime;

    public ResultsTable(String playerName, int points, LocalDate todayDate, long gameTime) {
        this.playerName = playerName;
        this.points = points;
        this.todayDate = todayDate;
        this.gameTime = gameTime;
    }

    @Override
    public String toString() {
        return "ResultsTable{" +
                "playerName='" + playerName + '\'' +
                ", points=" + points +
                ", todayDate=" + todayDate +
                ", gameTime=" + gameTime +
                '}';
    }


}
