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
    @JsonProperty("path")
    private ArrayList<String> path = null;

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
     * Assignment operators e.g. in txt files.
     * Example: "key: value" -> ":" is the assignment operator.
     * If set, the data will be treated as key-value pairs, optionally with a delimiter for multiple values within a line.
     */
    @JsonProperty("assignments")
    private String assignments = null;

    /**
     * Regex pattern to find headlines and define data parts.
     */
    @JsonProperty("pattern")
    private Pattern pattern = null;

    /**
     * Gets the path.
     *
     * @return the path
     */
    public ArrayList<String> getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param path the path to set
     */
    public void setPath(ArrayList<String> path) {
        this.path = path;
    }

    /**
     * Sets the path and returns the current ImportParserMappings object.
     *
     * @param path the path to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings path(ArrayList<String> path) {
        this.path = path;
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
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * Sets the pattern.
     *
     * @param pattern the pattern to set
     */
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * Sets the pattern and returns the current ImportParserMappings object.
     *
     * @param pattern the pattern to set
     * @return the current ImportParserMappings object
     */
    public ImportParserMappings pattern(Pattern pattern) {
        this.pattern = pattern;
        return this;
    }

    // Override equals, hashCode, and toString methods

    /**
     * Checks if this ImportParserMappings object is equal to another object.
     *
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportParserMappings that)) return false;
        return Objects.equals(path, that.path) &&
                Objects.equals(hasHeadline, that.hasHeadline) &&
                Objects.equals(lineStarter, that.lineStarter) &&
                Objects.equals(delimiter, that.delimiter) &&
                Objects.equals(terminator, that.terminator) &&
                Objects.equals(assignments, that.assignments) &&
                Objects.equals(pattern, that.pattern);
    }

    /**
     * Returns the hash code of this ImportParserMappings object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(path, hasHeadline, lineStarter, delimiter, terminator, assignments, pattern);
    }

    /**
     * Returns the string representation of this ImportParserMappings object.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "{\n" +
                "    path: " + toIndentedString(path) + ",\n" +
                "    has_headline: " + toIndentedString(hasHeadline) + ",\n" +
                "    line_starter: " + toIndentedString(lineStarter) + ",\n" +
                "    delimiter: " + toIndentedString(delimiter) + ",\n" +
                "    terminator: " + toIndentedString(terminator) + ",\n" +
                "    assignments: " + toIndentedString(assignments) + ",\n" +
                "    pattern: " + toIndentedString(pattern) + "\n" +
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