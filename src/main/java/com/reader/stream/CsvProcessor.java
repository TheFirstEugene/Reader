package com.reader.stream;

import com.reader.data.Status;
import com.reader.data.TeamData;
import com.reader.service.CsvReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvProcessor {
    public CsvReader reader;

    public CsvProcessor(CsvReader reader) {
        this.reader = reader;
    }

    public void read() {
        List<TeamData> read = null;
        try {
            read = reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printResult(read);
    }

    private List<String> getAllTeams(List<TeamData> teamData) {
        return teamData.stream()
                .map(TeamData::getTeam)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Long> getTotalEffort(List<TeamData> teamData) {
        List<Long> integerList = new ArrayList<>();
        for (int i = 0; i < getAllTeams(teamData).size(); i++) {
            int finalI = i;
            long count = teamData.stream()
                    .filter(teamData1 -> teamData1.getTeam().equals(getAllTeams(teamData).get(finalI)))
                    .map(TeamData::getStatus)
                    .filter(s -> s.equals(Status.OPEN.toString()) || s.equals(Status.IN_PROGRESS.toString()))
                    .count();
            integerList.add(count);
        }
        return integerList;
    }

    private List<Long> getRemainingEffort(List<TeamData> teamData) {
        List<Long> integerList = new ArrayList<>();
        for (int i = 0; i < getAllTeams(teamData).size(); i++) {
            int finalI = i;
            long count = teamData.stream()
                    .filter(teamData1 -> teamData1.getTeam().equals(getAllTeams(teamData).get(finalI)))
                    .map(TeamData::getStatus)
                    .filter(s -> s.equals(Status.CLOSED_COMPLETE.toString()) || s.equals(Status.CLOSED_REJECTED.toString()))
                    .count();
            integerList.add(count);
        }
        return integerList;
    }

    private void printResult(List<TeamData> read) {
        System.out.println("Team, Total Effort, Remaining Effort");
        List<String> allTeams = getAllTeams(read);
        List<Long> totalEffort = getTotalEffort(read);
        List<Long> remainingEffort = getRemainingEffort(read);

        for (int i = 0; i < getAllTeams(read).size(); i++) {
            System.out.print(allTeams.get(i) + " ");
            System.out.print(totalEffort.get(i) + " ");
            System.out.print(totalEffort.get(i) - remainingEffort.get(i) + " ");
            System.out.println();
        }
    }

}
