package com.reader;

import com.reader.service.CsvReader;
import com.reader.stream.CsvProcessor;

public class Main {
    public static void main(String[] args) {
        String path = "/input-data.csv";
        CsvReader csvReader = new CsvReader(path);
        CsvProcessor csvProcessor = new CsvProcessor(csvReader);
        csvProcessor.read();
    }
}