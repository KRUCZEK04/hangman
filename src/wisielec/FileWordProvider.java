package wisielec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FileWordProvider implements WordProvider {

    @Override
    public String getPassword(String fileName) {
        List<String> passwords = readPasswords(fileName);
        Random random = new Random();
        int index = random.nextInt(0,50);
        String randomPassword = passwords.get(index);
        return randomPassword.trim();
    }
    public List<String> readPasswords(String fileName) {
        String filePath = "C:\\Users\\Adam Kruk\\IdeaProjects\\tomek git\\hangman\\src\\wisielec\\" + fileName;
        List<String> passwords = new ArrayList<>();
        String test = "";
        try {
            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                test += line;
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        String[] split = test.split(",");
        passwords = Arrays.asList(split);
        return passwords;}
}
