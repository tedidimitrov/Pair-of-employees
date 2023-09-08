package com.company.utils;

import com.company.model.Record;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static com.company.utils.DateParser.parseDate;

public class CSVReader {

    public static List<Record> read() {
        String path = "resources/colleagues.csv";

        List<Record> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int employeeId = Integer.parseInt(values[0].trim());
                int projectId = Integer.parseInt(values[1].trim());
                LocalDate dateFrom = parseDate(values[2].trim());
                LocalDate dateTo = parseDate(values[3].trim());
                records.add(new Record(employeeId, projectId, dateFrom, dateTo));
            }
            return records;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the file!");
        }
    }
}
