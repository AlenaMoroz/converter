package com.gmail.marozalena4.service.impl;

import com.gmail.marozalena4.service.Converter;
import com.gmail.marozalena4.service.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConverterImpl implements Converter {
    /**
     * Конвертер числа из цифровой записи в строковую
     */
    @Override
    public String convertNumberToString(Long number) {
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = new FileReaderImpl();
        if (number == 0) {
            return "ноль";
        }
        if (number < 0) {
            return "Отрицательное число. Попробуйте еще раз";
        }
        List<Long> segments = getSegments(number);
        int level = segments.size();
        for (Long segment : segments) {
            if (segment == 0 && level > 1) {
                level--;
                continue;
            }
            if (segment > 99) {
                sb.append(" ").append(fileReader.getHundredths(
                        (int) (segment / 100)));
                segment = segment % 100;
            }
            if (segment > 20) {
                sb.append(" ").append(fileReader.getTenthsMoreThenTwenty(
                        (int) (segment / 10)));
                if (level == 2 && segment % 10 != 0) {
                    sb.append(" ").append(fileReader.getUnits((int) (segment % 10), 1));
                } else if (segment % 10 != 0) {
                    sb.append(" ").append(fileReader.getUnits((int) (segment % 10), 0));
                }
            } else {
                if (segment > 9) {
                    sb.append(" ").append(fileReader.getTenths((int) (segment - 9)));
                } else {
                    if (level == 2 && segment % 10 != 0) {
                        sb.append(" ").append(fileReader.getUnits((int) (segment % 10), 1));
                    } else if (segment % 10 != 0) {
                        sb.append(" ").append(fileReader.getUnits((int) (segment % 10), 0));
                    }
                }
            }
            if (level > 1) {
                level--;
                try {
                    sb.append(" ").append(getForm(segment, fileReader.getThousandthsOrMore(level)));
                } catch (NullPointerException e) {
                    System.out.println("В библиотеке нет такого числа");
                }
            }
        }
        return sb.delete(0,1).toString();
    }

    private List<Long> getSegments(Long number) {
        List<Long> segments = new ArrayList<>();
        while (number > 999) {
            long seg = number / 1000;
            segments.add(number - (seg * 1000));
            number = seg;
        }
        segments.add(number);
        Collections.reverse(segments);
        return segments;
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

