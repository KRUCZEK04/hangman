package wisielec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {
    public void saveToFile(ResultsTable resultsTable) throws IOException {
        String fileName = "Results.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
        bufferedWriter.append(' ');
        bufferedWriter.append(resultsTable.toString());
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
