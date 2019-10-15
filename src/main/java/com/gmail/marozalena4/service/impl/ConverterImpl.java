package com.gmail.marozalena4.service.impl;

import com.gmail.marozalena4.service.Converter;
import com.gmail.marozalena4.service.LibraryReader;
import com.gmail.marozalena4.service.numbers.Numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConverterImpl implements Converter {
    /**
     * Конвертер числа из цифровой записи в строковую
     */
    private LibraryReader libraryReader;
    private Numbers numbers;

    public ConverterImpl() {
        this.libraryReader = new LibraryReaderImpl();
        this.numbers = new Numbers();
    }

    @Override
    public String convertNumberToString(BigInteger number) {
        StringBuilder sb = new StringBuilder();
        if (number.compareTo(BigInteger.valueOf(0)) == 0) {
            return "ноль";
        }
        if (number.compareTo(BigInteger.valueOf(0)) < 0) {
            return "Отрицательное число. Попробуйте еще раз";
        }
        List<Integer> segments = getSegments(number);
        int level = segments.size();
        for (Integer segment : segments) {
            if (segment == 0 && level > 1) {
                level--;
                continue;
            }
            if (segment > 99) {
                sb.append(" ")
                        .append(numbers.getHundredths()
                                .get(segment / 100));
                segment = segment % 100;
            }
            if (segment > 20) {
                sb.append(" ")
                        .append(numbers.getTenthsMoreThenNineteen()
                                .get(segment / 10));
                if (segment % 10 != 0) {
                    sb.append(" ").append(getUnit(level, segment));
                }
            } else {
                if (segment > 9) {
                    sb.append(" ").append(numbers.getTenths().get(segment - 9));
                } else {
                    sb.append(" ").append(getUnit(level, segment));
                }
            }
            if (level > 1) {
                level--;
                try {
                    sb.append(" ").append(getForm(segment, libraryReader.getThousandthsOrMore(level)));
                } catch (NullPointerException e) {
                    System.out.println("В библиотеке нет такого числа");
                }
            }
        }
        return sb.delete(0, 1).toString();
    }

    private List<Integer> getSegments(BigInteger number) {
        List<Integer> segments = new ArrayList<>();
        while (number.compareTo(BigInteger.valueOf(999)) >= 0) {
            BigInteger seg = number.divide(BigInteger.valueOf(1000));
            segments.add(number.subtract(seg.multiply(BigInteger.valueOf(1000))).intValue());
            number = seg;
        }
        segments.add(number.intValue());
        Collections.reverse(segments);
        return segments;
    }

    private String getUnit(int level, Integer segment) {
        if (level == 2) {
            return numbers.getUnits()[1][segment % 10];
        }
        return numbers.getUnits()[0][segment % 10];
    }

    private String getForm(long segment, String[] forms) {
        if (segment > 10 && segment < 20) {
            return forms[2];
        }
        if (segment % 10 > 1 && segment % 10 < 5) {
            return forms[1];
        }
        if (segment % 10 == 1) {
            return forms[0];
        }
        return forms[2];
    }

}

