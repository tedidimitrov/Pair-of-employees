package com.company.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateParser {

    public static LocalDate parseDate(String date) {
        if("NULL".equals(date)) {
            return LocalDate.now();
        }
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern("[MM/dd/yyyy]" + "[dd-MM-yyyy]" + "[yyyy-MM-dd]" +
                        "[M-d-yyyy]" + "[dd-MM-yy]" + "[ddMMyyyy"));
        DateTimeFormatter dateTimeFormatter = builder.toFormatter();
        return LocalDate.parse(date, dateTimeFormatter);
    }
}
