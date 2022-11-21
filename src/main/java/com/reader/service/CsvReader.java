package com.reader.service;

import com.opencsv.CSVReader;
import com.reader.data.Priority;
import com.reader.data.Status;
import com.reader.data.TeamData;
import com.reader.exception.NoValidValueException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements Reader {
    public String path;

    public CsvReader(String path) {
        this.path = path;
    }

    @Override
    public List<TeamData> read() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(path);
        CSVReader csvReader = null;
        if (inputStream != null) {
            csvReader = new CSVReader(new InputStreamReader(inputStream), ',', '/', 1);
        } else {
            throw new NoValidValueException("Failed to create this type of reader");
        }
        List<TeamData> teamData = new ArrayList<>();
        String[] record = null;

        while ((record = csvReader.readNext()) != null) {
            TeamData emp = new TeamData();
            emp.setIssue_key(record[0]);
            emp.setIssueId(Integer.parseInt(record[1]));
            emp.setParentId(record[2]);
            emp.setStatus(record[4]);
            emp.setIssueType(record[5]);
            emp.setPriority(record[7]);
            emp.setTeam(record[8]);
            teamData.add(emp);
        }
        csvReader.close();
        return teamData;

    }
}
