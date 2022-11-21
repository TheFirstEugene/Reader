package com.reader.service;

import com.reader.data.TeamData;

import java.io.IOException;
import java.util.List;

public interface Reader {
    List<TeamData> read() throws IOException;
}
