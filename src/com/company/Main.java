package com.company;

import com.company.model.CommonProject;
import com.company.model.Pair;
import com.company.model.Record;
import com.company.utils.CSVReader;
import com.company.utils.PairFinder;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Record> records = CSVReader.read();
        Map<Pair, List<CommonProject >> pairs = new PairFinder().findPairs(records);
        System.out.println(pairs.size());
    }
}
