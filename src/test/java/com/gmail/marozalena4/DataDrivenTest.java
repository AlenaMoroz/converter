package com.gmail.marozalena4;

import com.gmail.marozalena4.service.impl.ConverterImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

public class DataDrivenTest {

    @Test
    public void shouldConvertNumberToString() {
        String fileName = System.getProperty("user.dir")
                + "/src/test/resources/numbersForTest.txt";
        ConverterImpl converter = new ConverterImpl();
        String[] test;
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            while (reader.ready()) {
                test = reader.readLine().split(", ");
                String string = converter.convertNumberToString(new BigInteger(test[0]));
                String standard = test[1];
                Assert.assertEquals("Incorrect", standard, string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
