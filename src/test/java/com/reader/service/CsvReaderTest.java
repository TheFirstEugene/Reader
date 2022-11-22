package com.reader.service;

import com.reader.data.TeamData;
import com.reader.exception.NoValidValueException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.List;

import static org.apache.commons.lang3.Validate.notEmpty;
import static org.junit.jupiter.api.Assertions.*;

class CsvReaderTest {

    @Test
    void shouldSuccessfullyReadFile() throws IOException {
        //GIVEN
        String path = "/unit-test-data.csv";
        CsvReader csvReader = new CsvReader(path);

        //WHEN
        List<TeamData> read = csvReader.read();

        //THEN
        notEmpty(read);
    }

    @Test
    void shouldThrowExceptionCauseFileNotExist(){
        //GIVEN
        String wrongPath = "/unic-test-data.csv";
        CsvReader csvReader = new CsvReader(wrongPath);

        //WHEN
        Executable executable = csvReader::read;

        //THEN
        assertThrows(NoValidValueException.class, executable);
    }
}