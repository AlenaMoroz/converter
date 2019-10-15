package com.gmail.marozalena4.service;

public interface FileReader {

    String[] getThousandthsOrMore(int number);

    String getHundredths(int number);

    String getTenthsMoreThenTwenty(int number);

    String getTenths(int number);

    String getUnits(int number, int kind);
}
