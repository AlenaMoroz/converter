package com.gmail.marozalena4.service.impl;

import com.gmail.marozalena4.service.FileReader;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderImpl implements FileReader {

    @Override
    public String[] getThousandthsOrMore(int level) {
        String fileName = System.getProperty("user.dir")
                + "/src/main/resources/FromOneThousand.txt";
        String[] forms = new String[3];
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
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

    @Override
    public String getHundredths(int number) {
        String fileName = System.getProperty("user.dir")
                + "/src/main/resources/OneHundredToNineHundred.txt";
        String string = "";
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            int i = 0;
            while (i != number) {
                string = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    @Override
    public String getTenthsMoreThenTwenty(int number) {
        String fileName = System.getProperty("user.dir")
                + "/src/main/resources/TenToNinety.txt";
        String string = "";
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            int i = 0;
            while (i != number) {
                string = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    @Override
    public String getTenths(int number) {
        String fileName = System.getProperty("user.dir")
                + "/src/main/resources/TenToNineteen.txt";
        String string = "";
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            int i = 0;
            while (i != number) {
                string = reader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    @Override
    public String getUnits(int number, int kind) {
        String fileName = System.getProperty("user.dir")
                + "/src/main/resources/OneToNine.txt";
        String [] row = new String[2];
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            int i = 0;
            row = reader.readLine().split(", ");
            while (i != kind) {
                row = reader.readLine().split(", ");
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row[number-1];
    }
}
