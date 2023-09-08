package com.company.utils;

import com.company.model.CommonProject;
import com.company.model.Pair;
import com.company.model.Record;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class PairFinder {

    public Map<Pair, List<CommonProject>> findPairs(List<Record> records) {
        Map<Pair, List<CommonProject>> pairs = new HashMap<>();
        int counter = 0;
        for (Record record1 : records) {
            for (Record record2 : records.subList(counter+1, records.size())) {
                if(record1.getProjectId() == record2.getProjectId() && haveWorkedOnSameProject(record1, record2)) {
                    if(!pairExist(pairs, record1, record2)) {
                        pairs.put(new Pair(record1.getEmployeeId(), record2.getEmployeeId()),
                                new ArrayList<>());
                    }
                    Pair pair = new Pair(record1.getEmployeeId(), record2.getEmployeeId());
                    Pair secondPair = new Pair(record1.getEmployeeId(), record2.getEmployeeId());
                    List<CommonProject> projects = pairs.get(pair);
                    if(projects == null) {
                        projects = pairs.get(secondPair);
                        secondPair.updateTotalDuration(getDurationInDays(record1, record2));
                    } else {
                        pair.updateTotalDuration(getDurationInDays(record1, record2));
                    }
                    projects.add(new CommonProject(record1.getProjectId(), getDurationInDays(record1, record2)));
                }
            }
            counter++;
        }
        return pairs;
    }

    private boolean haveWorkedOnSameProject(Record record1, Record record2) {
        return record1.getDateFrom().isBefore(record2.getDateTo()) &&
                record1.getDateTo().isAfter(record2.getDateFrom());
    }

    private boolean pairExist(Map<Pair, List<CommonProject>> pairs, Record record1, Record record2) {
        return pairs.containsKey(new Pair(record1.getEmployeeId(), record2.getEmployeeId())) ||
                pairs.containsKey(new Pair(record2.getEmployeeId(), record1.getEmployeeId()));
    }

    private long getDurationInDays(Record record1, Record record2) {
        LocalDate startDate = record1.getDateFrom().isBefore(record2.getDateFrom()) ?
                record2.getDateFrom() : record1.getDateFrom();

        LocalDate endDate = record1.getDateTo().isBefore(record2.getDateTo()) ?
                record1.getDateTo() : record2.getDateTo();

        return startDate.until(endDate, ChronoUnit.DAYS);
    }
}
