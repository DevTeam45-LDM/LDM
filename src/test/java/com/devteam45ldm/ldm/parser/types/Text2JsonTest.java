package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Text2JsonTest {



    @Test
    void parse_withValidText_returnsText() {
        String text =   """
                        #key1:value1,key2:value2,key3:value3
                        #key4:value2
                        #key5:value3
                        """;

        ImportParserMappings importParserMappings = new ImportParserMappings()
                .lineStarter("#")
                .delimiter(",")
                .terminator("\n")
                .assignments(":");

        String expected = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key5\":\"value3\",\"key3\":\"value3\",\"key4\":\"value2\"}";

        String result = Text2Json.parse(text, importParserMappings);
        assertEquals(expected, result);
    }
}
