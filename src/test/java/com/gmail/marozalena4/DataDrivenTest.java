package com.gmail.marozalena4;

import com.gmail.marozalena4.service.impl.ConverterImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DataDrivenTest {

    @Test
    public void shouldConvertNumberToString() {
        ConverterImpl converter = new ConverterImpl();
        Map<Long, String> pairs = init();
        for (Map.Entry<Long, String> pair : pairs.entrySet()) {
            String string = converter.convertNumberToString(pair.getKey());
            String standard = pair.getValue();
            Assert.assertEquals("Incorrect", standard, string);
        }
    }

    @Parameterized.Parameters
    public static Map<Long, String> init() {
        Map<Long, String> map = new HashMap<>();
        map.put(13568654L, "тринадцать миллионов пятьсот шестьдесят восемь тысяч шестьсот пятьдесят четыре");
        map.put(1567397L, "один миллион пятьсот шестьдесят семь тысяч триста девяносто семь");
        map.put(15470874650L, "пятнадцать миллиардов четыреста семьдесят миллионов восемьсот семьдесят четыре тысячи шестьсот пятьдесят");
        return map;
    }

}
