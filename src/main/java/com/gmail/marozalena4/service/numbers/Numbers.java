package com.gmail.marozalena4.service.numbers;

import java.util.Arrays;
import java.util.List;

public class Numbers {

    private List<String> hundredths = Arrays.asList("", "сто", "двесте", "триста", "четыреста", "пятьсот", "шестьсот",
            "семьсот", "восемьсот", "девятьсот");
    private List<String> tenthsMoreThenNineteen = Arrays.asList("", "десять", "двадцать", "тридцать", "сорок",
            "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто");
    private List<String> tenths = Arrays.asList("", "десять", "одиннадцать", "двенадцать", "тринадцать",
            "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать");
    private String[][] units = {{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}};

    public List<String> getHundredths() {
        return hundredths;
    }

    public List<String> getTenthsMoreThenNineteen() {
        return tenthsMoreThenNineteen;
    }

    public List<String> getTenths() {
        return tenths;
    }

    public String[][] getUnits() {
        return units;
    }
}
