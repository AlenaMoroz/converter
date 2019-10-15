package com.gmail.marozalena4.service.impl;

import com.gmail.marozalena4.service.LibraryReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibraryReaderImpl implements LibraryReader {

    @Override
    public String[] getThousandthsOrMore(int level) {
        String fileName = System.getProperty("user.dir")
                + "/src/main/resources/FromOneThousand.txt";
        String[] forms = new String[3];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int i = 0;
            while (i != level) {
                forms = reader.readLine().split(", ");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forms;
    }
}
