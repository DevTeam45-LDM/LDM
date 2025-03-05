package com.devteam45ldm.ldm.parser.templates.importDataStructures;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents the parser mappings for import data.
 */
public class ImportParserMappings {

    /**
     * Path to specific parts within the file.
     */
    @JsonProperty("paths")
    private ArrayList<String> paths = null;

    /**
     * Is there a line to be treated as a headline?
     * Lines with only spaces and \n are ignored.
     */
    @JsonProperty("has_headline")
    private Boolean hasHeadline = null;

    /**
     * String which every line starts with.
     */
    @JsonProperty("line_start")
    private String lineStarter = null;

    /**
     * Delimiter for data e.g. a csv delimiter.
     */
    @JsonProperty("delimiter")
    private String delimiter = null;

    /**
     * Terminator for data e.g. a csv terminator like a newline.
     */
    @JsonProperty("terminator")
    private String terminator = null;

    /**
     * Total amount of columns in the data.
     */
    @JsonProperty("total_columns")
    private Integer totalColumns = null;

    /**
     * Assignment operators e.g. in txt files.
     * Example: "key: value" -> ":" is the assignment operator.
     * If set, the data will be treated as key-value pairs, optionally with a delimiter for multiple values within a line.
     */
    @JsonProperty("assignments")
    private String assignments = null;

    /**
     * Regex pattern to determine metadata and data sections.
     */
    @JsonProperty("section_pattern")
    private Pattern sectionPattern = null;

    /**
     * String which introduces a new section.
     */
    @JsonProperty("section_string")
    private String sectionString = null;

    /**
     * Amount of lines to skip after the headline (pattern).
     */
    @JsonProperty("skip_lines")
    private Integer skipLines = null;

    /**
     * Gets the path.
     *
     * @return the path
     */
    public ArrayList<String> getPaths() {
        return paths;
    }

    /**
     * Sets the path.
     *
     * @param paths the path to set
     */
    public void setPaths(ArrayList<String> paths) {
        this.paths = paths;
    }

    /**
     * Sets the path and returns the current ImportParserMappings object.
     *
     * @param path the path to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings path(ArrayList<String> path) {
        this.paths = path;
        return this;
    }

    /**
     * Gets the has headline.
     *
     * @return the has headline
     */
    public Boolean getHasHeadline() {
        return hasHeadline;
    }

    /**
     * Sets the has headline.
     *
     * @param hasHeadline the has headline to set
     */
    public void setHasHeadline(Boolean hasHeadline) {
        this.hasHeadline = hasHeadline;
    }

    /**
     * Sets the has headline and returns the current ImportParserMappings object.
     *
     * @param hasHeadline the has headline to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings hasHeadline(Boolean hasHeadline) {
        this.hasHeadline = hasHeadline;
        return this;
    }

    /**
     * Gets the line starter.
     *
     * @return the line starter
     */
    public String getLineStarter() {
        return lineStarter;
    }

    /**
     * Sets the line starter.
     *
     * @param lineStarter the line starter to set
     */
    public void setLineStarter(String lineStarter) {
        this.lineStarter = lineStarter;
    }

    /**
     * Sets the line starter and returns the current ImportParserMappings object.
     *
     * @param lineStarter the line starter to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings lineStarter(String lineStarter) {
        this.lineStarter = lineStarter;
        return this;
    }

    /**
     * Gets the delimiter.
     *
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets the delimiter.
     *
     * @param delimiter the delimiter to set
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Sets the delimiter and returns the current ImportParserMappings object.
     *
     * @param delimiter the delimiter to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings delimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    /**
     * Gets the terminator.
     *
     * @return the terminator
     */
    public String getTerminator() {
        return terminator;
    }

    /**
     * Sets the terminator.
     *
     * @param terminator the terminator to set
     */
    public void setTerminator(String terminator) {
        this.terminator = terminator;
    }

    /**
     * Sets the terminator and returns the current ImportParserMappings object.
     *
     * @param terminator the terminator to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings terminator(String terminator) {
        this.terminator = terminator;
        return this;
    }

    /**
     * Gets the total columns.
     *
     * @return the total columns
     */
    public Integer getTotalColumns() {
        return totalColumns;
    }

    /**
     * Sets the total columns.
     *
     * @param totalColumns the total columns to set
     */
    public void setTotalColumns(Integer totalColumns) {
        this.totalColumns = totalColumns;
    }

    /**
     * Sets the total columns and returns the current ImportParserMappings object.
     *
     * @param totalColumns the total columns to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings totalColumns(Integer totalColumns) {
        this.totalColumns = totalColumns;
        return this;
    }

    /**
     * Gets the assignments.
     *
     * @return the assignments
     */
    public String getAssignments() {
        return assignments;
    }

    /**
     * Sets the assignments.
     *
     * @param assignments the assignments to set
     */
    public void setAssignments(String assignments) {
        this.assignments = assignments;
    }

    /**
     * Sets the assignments and returns the current ImportParserMappings object.
     *
     * @param assignments the assignments to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings assignments(String assignments) {
        this.assignments = assignments;
        return this;
    }

    /**
     * Gets the pattern.
     *
     * @return the pattern
     */
    public Pattern getSectionPattern() {
        return sectionPattern;
    }

    /**
     * Checks if the pattern is empty.
     *
     * @return boolean
     */
    public Boolean isSectionPatternEmpty() {
        return sectionPattern == null || sectionPattern.toString().isEmpty();
    }

    /**
     * Sets the pattern.
     *
     * @param sectionPattern the pattern to set
     */
    public void setSectionPattern(Pattern sectionPattern) {
        this.sectionPattern = sectionPattern;
    }

    /**
     * Sets the section Pattern and returns the current ImportParserMappings object.
     *
     * @param sectionPattern the pattern to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings sectionPattern(Pattern sectionPattern) {
        this.sectionPattern = sectionPattern;
        return this;
    }

    /**
     * Gets the section string.
     *
     * @return the section string
     */
    public String getSectionString() {
        return sectionString;
    }

    /**
     * Checks if the pattern is empty.
     *
     * @return boolean
     */
    public Boolean isSectionStringEmpty() {
        return sectionString == null || sectionString.isEmpty();
    }

    /**
     * Sets the section string.
     *
     * @param sectionString the pattern to set
     */
    public void setSectionString(String sectionString) {
        this.sectionString = sectionString;
    }

    /**
     * Sets the pattern and returns the current ImportParserMappings object.
     *
     * @param sectionString the pattern to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings sectionString(String sectionString) {
        this.sectionString = sectionString;
        return this;
    }

    /**
     * Gets the skip lines after header.
     *
     * @return the skip lines after header
     */
    public Integer getSkipLines() {
        return skipLines;
    }

    /**
     * Sets the skip lines after header.
     *
     * @param skipLines the skip lines after header to set
     */
    public void setSkipLines(Integer skipLines) {
        this.skipLines = skipLines;
    }

    /**
     * Sets the skip lines after header and returns the current ImportParserMappings object.
     *
     * @param skipLines the skip lines after header to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings skipLines(Integer skipLines) {
        this.skipLines = skipLines;
        return this;
    }

    /**
     * Checks if this ImportParserMappings object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportParserMappings that)) return false;
        return Objects.equals(paths, that.paths) &&
                Objects.equals(hasHeadline, that.hasHeadline) &&
                Objects.equals(lineStarter, that.lineStarter) &&
                Objects.equals(delimiter, that.delimiter) &&
                Objects.equals(terminator, that.terminator) &&
                Objects.equals(assignments, that.assignments) &&
                Objects.equals(sectionPattern, that.sectionPattern) &&
                Objects.equals(sectionString, that.sectionString) &&
                Objects.equals(skipLines, that.skipLines) &&
                Objects.equals(totalColumns, that.totalColumns);
    }

    /**
     * Returns the hash code of this ImportParserMappings object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(paths, hasHeadline, lineStarter, delimiter, terminator, totalColumns, assignments, sectionPattern, sectionString, skipLines);
    }

    /**
     * Returns the string representation of this ImportParserMappings object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "{\n" +
                "    paths: " + toIndentedString(paths) + ",\n" +
                "    has_headline: " + toIndentedString(hasHeadline) + ",\n" +
                "    line_starter: " + toIndentedString(lineStarter) + ",\n" +
                "    delimiter: " + toIndentedString(delimiter) + ",\n" +
                "    total_columns: " + toIndentedString(totalColumns) + "\n" +
                "    terminator: " + toIndentedString(terminator) + ",\n" +
                "    assignments: " + toIndentedString(assignments) + ",\n" +
                "    section_pattern: " + toIndentedString(sectionPattern) + ",\n" +
                "    section_string: " + toIndentedString(sectionString) + ",\n" +
                "    skip_lines: " + toIndentedString(skipLines) + ",\n" +
                "}";
    }

    /**
     * Converts the given object to a string with each line indented by 4 spaces (except the first line).
     *
     * @param o the object to convert
     * @return the string representation of the object
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}