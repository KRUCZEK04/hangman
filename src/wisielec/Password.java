package wisielec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: Podzielić elementy ze string value na liste haseł
//TODO: W metodzie getPassword będziemy losować 1 HASŁO z tej listy
public class Password {
    private String value;
    private WordProvider wordProvider;

    public Password(String fileName) {
        wordProvider = new FileWordProvider();
        this.value = wordProvider.getPassword(fileName);
    }

    public String getValue() {
        return value;
    }



}

