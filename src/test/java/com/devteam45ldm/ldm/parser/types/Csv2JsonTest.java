package com.devteam45ldm.ldm.parser.types;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Csv2JsonTest {

    /**
     * Tests parsing a simple CSV with header and one data row
     */
    @Test
    void parse_simpleCSV_returnsCorrectJson() throws Exception {
        String csv = "name,age\nJohn,30";
        JSONObject result = Csv2Json.parse(csv);

        JSONObject firstRow = result.getJSONObject("0");
        assertEquals("John", firstRow.getString("name"));
        assertEquals("30", firstRow.getString("age"));
    }

    /**
     * Tests parsing CSV with multiple rows
     */
    @Test
    void parse_multipleRows_returnsCorrectJson() throws Exception {
        String csv = "name,age\nJohn,30\nJane,25";
        JSONObject result = Csv2Json.parse(csv);

        JSONObject firstRow = result.getJSONObject("0");
        JSONObject secondRow = result.getJSONObject("1");

        assertEquals("John", firstRow.getString("name"));
        assertEquals("30", firstRow.getString("age"));
        assertEquals("Jane", secondRow.getString("name"));
        assertEquals("25", secondRow.getString("age"));
    }

    /**
     * Tests parsing empty CSV
     */
    @Test
    void parse_emptyCSV_throwsException() {
        String csv = "";
        assertThrows(Exception.class, () -> Csv2Json.parse(csv));
    }

    /**
     * Tests parsing CSV with missing values
     */
    @Test
    void parse_missingValues_handlesGracefully() throws Exception {
        String csv = "name,age,city\nJohn,,New York";
        JSONObject result = Csv2Json.parse(csv);

        JSONObject row = result.getJSONObject("0");
        assertEquals("John", row.getString("name"));
        assertEquals("", row.getString("age"));
        assertEquals("New York", row.getString("city"));
    }

    /**
     * Tests parsing CSV with spaces in headers and values
     */
    @Test
    void parse_spacesInContent_trimsProperly() throws Exception {
        String csv = " name , age , city \n John , 30 , New York ";
        JSONObject result = Csv2Json.parse(csv);

        JSONObject row = result.getJSONObject("0");
        assertEquals("John", row.getString("name"));
        assertEquals("30", row.getString("age"));
        assertEquals("New York", row.getString("city"));
    }

    /**
     * Tests parsing the White Stripes albums CSV example
     */
    @Test
    void parse_whiteStripesAlbums_returnsCorrectJson() throws Exception {
        String csv = """
                album,year,US_peak_chart_post
                The White Stripes,1999,-
                De Stijl,2000,-
                White Blood Cells,2001,61""";

        JSONObject result = Csv2Json.parse(csv);

        JSONObject firstAlbum = result.getJSONObject("0");
        assertEquals("The White Stripes", firstAlbum.getString("album"));
        assertEquals("1999", firstAlbum.getString("year"));
        assertEquals("-", firstAlbum.getString("US_peak_chart_post"));

        JSONObject secondAlbum = result.getJSONObject("1");
        assertEquals("De Stijl", secondAlbum.getString("album"));
        assertEquals("2000", secondAlbum.getString("year"));
        assertEquals("-", secondAlbum.getString("US_peak_chart_post"));

        JSONObject thirdAlbum = result.getJSONObject("2");
        assertEquals("White Blood Cells", thirdAlbum.getString("album"));
        assertEquals("2001", thirdAlbum.getString("year"));
        assertEquals("61", thirdAlbum.getString("US_peak_chart_post"));
    }
}