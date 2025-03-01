package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class ImportParserMappings {
    private final ArrayList<String> path;
    private final Boolean hasHeadline;
    private final String lineStarter;
    private final String delimiter;
    private final String terminator;
    private final String assignments;
    private final Pattern pattern;


    public ImportParserMappings(@JsonProperty("path") ArrayList<String> path,
                                @JsonProperty("hasHeadline") Boolean hasHeadline,
                                @JsonProperty("lineStarter") String lineStarter,
                                @JsonProperty("delimiter") String delimiter,
                                @JsonProperty("terminator") String terminator,
                                @JsonProperty("assignments") String assignments) {
        this.path = path;
        this.hasHeadline = hasHeadline;
        this.lineStarter = lineStarter;
        this.delimiter = delimiter;
        this.terminator = terminator;
        this.assignments = assignments;
        this.pattern = Pattern.compile(assignments);
    }


    public ArrayList<String> getPath() {
        return path;
    }

    public Boolean getHasHeadline() {
        return hasHeadline;
    }

    public String getLineStarter() {
        return lineStarter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getTerminator() {
        return terminator;
    }

    public String getAssignments() {
        return assignments;
    }

    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportParserMappings that)) return false;
        return Objects.equals(getPath(), that.getPath()) && Objects.equals(getHasHeadline(), that.getHasHeadline()) && Objects.equals(getLineStarter(), that.getLineStarter()) && Objects.equals(getDelimiter(), that.getDelimiter()) && Objects.equals(getTerminator(), that.getTerminator()) && Objects.equals(getAssignments(), that.getAssignments()) && Objects.equals(getPattern(), that.getPattern());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath(), getHasHeadline(), getLineStarter(), getDelimiter(), getTerminator(), getAssignments(), getPattern());
    }
}
