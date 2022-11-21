package com.reader.stream;

import com.reader.data.TeamData;
import com.reader.service.CsvReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvProcessorTest {
    CsvReader csvReader = new CsvReader("/unit-test-data.csv");
    CsvProcessor csvProcessor = new CsvProcessor(csvReader);

    @Test
    void shouldSuccessfullyRead(){
        //WHEN
        csvProcessor.read();
    }
}