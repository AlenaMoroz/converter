package com.gmail.marozalena4;

import com.gmail.marozalena4.service.Converter;
import com.gmail.marozalena4.service.impl.ConverterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Converter converter = new ConverterImpl();
        String line = reader.readLine();
        while (!line.equals("end")) {
            Long number = Long.parseLong(line);
            String numberInString = converter.convertNumberToString(number);
            System.out.println(numberInString);
            line = reader.readLine();
        }
    }
}
