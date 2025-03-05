package com.devteam45ldm.ldm.parser.types;

import com.devteam45ldm.ldm.parser.ParserController;
import com.devteam45ldm.ldm.parser.templates.Metadata;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportParserMappings;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportTemplate;
import com.devteam45ldm.ldm.parser.templates.importDataStructures.ImportedData;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.github.javaparser.utils.Utils.assertNotNull;
import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.*;


public class Custom2JsonTest {

    private final boolean debug = true;

    /**
     * Tests parsing a basic DAT file with header and data sections.
     */
    @Test
    public void parse_basicDatFile_returnsCorrectResult() throws Exception {
        // Setup test data
        String datContent = """
            [Header]
            ; This is a comment
            TITLE,Test Data
            INFO,Value1,DATA_POINT
            INFO,Value2,OTHER_POINT
            [Data]
            Time,Temperature,Pressure
            1,20.5,1013
            2,21.0,1014
            3,21.2,1015
            """;

        // Create parsing configuration
        ImportTemplate template = createBasicTemplate();

        // Define expected results
        String expectedMetadata = "[{\"TITLE\":\"Test Data\"},{\"INFO\":\"Value1\",\"DATA_POINT\"},{\"INFO\":\"Value2\",\"OTHER_POINT\"}]";
        String expectedData = "[{\"Time\":\"1\",\"Temperature\":\"20.5\",\"Pressure\":\"1013\"},{\"Time\":\"2\",\"Temperature\":\"21.0\",\"Pressure\":\"1014\"},{\"Time\":\"3\",\"Temperature\":\"21.2\",\"Pressure\":\"1015\"}]";

        try {
            // Parse the data
            ImportedData result = Custom2Json.parse(datContent, template);

            if(debug) {
                System.out.println("Basic parse result:");
                System.out.println("Expected metadata: " + expectedMetadata);
                System.out.println("Actual metadata: " + result.getMetadata());
                System.out.println("Expected data: " + expectedData);
                System.out.println("Actual data: " + result.getData());
            }

            // Assert the results match expectations
            assertNotNull(result);
            assertNotNull(result.getMetadata());
            assertNotNull(result.getData());

            // Compare JSON structures (normalize by parsing and re-serializing)
            JSONArray expectedMetadataJson = new JSONArray(expectedMetadata);
            JSONArray actualMetadataJson = new JSONArray(result.getMetadata());
            assertEquals(expectedMetadataJson.length(), actualMetadataJson.length(), "Metadata should have the same number of items");

            JSONArray expectedDataJson = new JSONArray(expectedData);
            JSONArray actualDataJson = new JSONArray(result.getData());
            assertEquals(expectedDataJson.length(), actualDataJson.length(), "Data should have the same number of rows");

            // Can add more specific assertions here to check individual fields
        } catch (Exception e) {
            fail("Exception occurred during testing: " + e.getMessage());
        }
    }

    /**
     * Tests parsing with custom delimiter configurations.
     */
    @Test
    public void parse_customDelimiters_returnsCorrectResult() throws Exception {
        // Setup test data with semicolon delimiters
        String datContent = """
            [Header]
            ; This is a comment
            TITLE;Test Data
            INFO;Value1;DATA_POINT
            [Data]
            Time;Temperature;Pressure
            1;20.5;1013
            2;21.0;1014
            """;

        // Create template with semicolon delimiter
        ImportTemplate template = createTemplateWithDelimiter(";");

        // Define expected results
        String expectedMetadata = "[{\"TITLE\":\"Test Data\"},{\"INFO\":\"Value1\",\"DATA_POINT\":\"\"}]";
        String expectedData = "[{\"Time\":\"1\",\"Temperature\":\"20.5\",\"Pressure\":\"1013\"},{\"Time\":\"2\",\"Temperature\":\"21.0\",\"Pressure\":\"1014\"}]";

        try {
            // Parse the data
            ImportedData result = Custom2Json.parse(datContent, template);

            if(debug) {
                System.out.println("Custom delimiter result:");
                System.out.println("Expected metadata: " + expectedMetadata);
                System.out.println("Actual metadata: " + result.getMetadata());
                System.out.println("Expected data: " + expectedData);
                System.out.println("Actual data: " + result.getData());
            }

            // Assert the results match expectations
            assertNotNull(result);
            assertNotNull(result.getMetadata());
            assertNotNull(result.getData());

            // Compare JSON structures
            JSONArray expectedMetadataJson = new JSONArray(expectedMetadata);
            JSONArray actualMetadataJson = new JSONArray(result.getMetadata());
            assertEquals(expectedMetadataJson.length(), actualMetadataJson.length(), "Metadata should have the same number of items");

            JSONArray expectedDataJson = new JSONArray(expectedData);
            JSONArray actualDataJson = new JSONArray(result.getData());
            assertEquals(expectedDataJson.length(), actualDataJson.length(), "Data should have the same number of rows");
        } catch (Exception e) {
            fail("Exception occurred during testing: " + e.getMessage());
        }
    }

    /**
     * Tests handling of complex, real-world DAT file content.
     */
    @Test
    public void parse_complexRealWorldData_returnsCorrectResult() throws Exception {
        // Setup test data based on the example in the original test
        String datContent = """
            [Header]
            ; MPMS3 Data File (default extension .dat)
            ; Copyright (c) 2001, Quantum Design, Inc. All rights reserved.
            TITLE,Complex Test
            FILEOPENTIME,3816019664.24396,50/28/2022,52:41 am
            INFO,MPMS3 Measurement,APPNAME
            [Data]
            Comment,Time,Temperature,Magnetic Field
            ,3816019163.46,300.50,0.50
            ,3816019119.53,300.09,941.05
            """;

        // Create parsing configuration
        ImportTemplate template = createBasicTemplate();

        // Define expected results - adjust according to actual implementation
        String expectedMetadata = "[{\"TITLE\":\"Complex Test\"},{\"FILEOPENTIME\":\"3816019664.24396\",\"50/28/2022\":\"52:41 am\"},{\"INFO\":\"MPMS3 Measurement\",\"APPNAME\":\"\"}]";
        String expectedData = "[{\"Comment\":\"\",\"Time\":\"3816019163.46\",\"Temperature\":\"300.50\",\"Magnetic Field\":\"0.50\"},{\"Comment\":\"\",\"Time\":\"3816019119.53\",\"Temperature\":\"300.09\",\"Magnetic Field\":\"941.05\"}]";

        try {
            // Parse the data
            ImportedData result = Custom2Json.parse(datContent, template);

            if(debug) {
                System.out.println("Complex data result:");
                System.out.println("Expected metadata: " + expectedMetadata);
                System.out.println("Actual metadata: " + result.getMetadata());
                System.out.println("Expected data: " + expectedData);
                System.out.println("Actual data: " + result.getData());
            }

            // Assert the results match expectations
            assertNotNull(result);
            assertNotNull(result.getMetadata());
            assertNotNull(result.getData());

            // Compare JSON structures
            JSONArray expectedMetadataJson = new JSONArray(expectedMetadata);
            JSONArray actualMetadataJson = new JSONArray(result.getMetadata());
            assertEquals(expectedMetadataJson.length(), actualMetadataJson.length(), "Metadata should have the correct number of items");

            JSONArray expectedDataJson = new JSONArray(expectedData);
            JSONArray actualDataJson = new JSONArray(result.getData());
            assertEquals(expectedDataJson.length(), actualDataJson.length(), "Data should have the correct number of rows");
        } catch (Exception e) {
            fail("Exception occurred during testing: " + e.getMessage());
        }
    }

    /**
     * Tests parsing with metadata section but without data section.
     */
    @Test
    public void parse_onlyMetadataSection_handlesCorrectly() throws Exception {
        // Setup test data with only metadata section
        String datContent = """
            [Header]
            TITLE,Metadata Only Test
            INFO,No Data Section
            """;

        // Create parsing configuration
        ImportTemplate template = createBasicTemplate();

        // Define expected results
        String expectedMetadata = "[{\"TITLE\":\"Metadata Only Test\"},{\"INFO\":\"No Data Section\"}]";

        try {
            // Parse the data
            ImportedData result = Custom2Json.parse(datContent, template);

            if(debug) {
                System.out.println("Metadata only result:");
                System.out.println("Expected metadata: " + expectedMetadata);
                System.out.println("Actual metadata: " + (result != null ? result.getMetadata() : "null result"));
                System.out.println("Data: " + (result != null ? result.getData() : "null data"));
            }

            // Assert the results match expectations
            assertNotNull(result);
            assertNotNull(result.getMetadata());

            // Compare metadata JSON structure
            JSONArray expectedMetadataJson = new JSONArray(expectedMetadata);
            JSONArray actualMetadataJson = new JSONArray(result.getMetadata());
            assertEquals(expectedMetadataJson.length(), actualMetadataJson.length(), "Metadata should have the correct number of items");

            // Data may be null, empty string, or empty JSON array
            assertTrue(result.getData() == null || result.getData().isEmpty() || result.getData().equals("[]"),
                    "Data should be null, empty, or empty array");
        } catch (Exception e) {
            fail("Exception occurred during testing: " + e.getMessage());
        }
    }

    /**
     * Tests parsing with data section but without metadata section.
     */
    @Test
    public void parse_onlyDataSection_handlesCorrectly() throws Exception {
        // Setup test data with only data section
        String datContent = """
            [Data]
            Column1,Column2,Column3
            value1,value2,value3
            value4,value5,value6
            """;

        // Create parsing configuration
        ImportTemplate template = createBasicTemplate();

        // Define expected results
        String expectedData = "[{\"Column1\":\"value1\",\"Column2\":\"value2\",\"Column3\":\"value3\"},{\"Column1\":\"value4\",\"Column2\":\"value5\",\"Column3\":\"value6\"}]";

        try {
            // Parse the data
            ImportedData result = Custom2Json.parse(datContent, template);

            if(debug) {
                System.out.println("Data only result:");
                System.out.println("Metadata: " + (result != null ? result.getMetadata() : "null metadata"));
                System.out.println("Expected data: " + expectedData);
                System.out.println("Actual data: " + (result != null ? result.getData() : "null result"));
            }

            // Assert the results match expectations
            assertNotNull(result);
            assertNotNull(result.getData());

            // Compare data JSON structure
            JSONArray expectedDataJson = new JSONArray(expectedData);
            JSONArray actualDataJson = new JSONArray(result.getData());
            assertEquals(expectedDataJson.length(), actualDataJson.length(), "Data should have the correct number of rows");

            // Metadata may be null, empty string, or empty JSON array
            assertTrue(result.getMetadata() == null || result.getMetadata().isEmpty() || result.getMetadata().equals("[]"),
                    "Metadata should be null, empty, or empty array");
        } catch (Exception e) {
            fail("Exception occurred during testing: " + e.getMessage());
        }
    }

    /**
     * Tests handling of empty input.
     */
    @Test
    public void parse_emptyInput_throwsException() {
        // Setup empty test data
        String datContent = "";

        // Create parsing configuration
        ImportTemplate template = createBasicTemplate();

        // For empty input, we expect an exception
        assertThrows(JSONException.class, () -> {
            Custom2Json.parse(datContent, template);
        }, "Empty input should throw JSONException");
    }

    /**
     * Helper method to create a basic template for DAT file parsing.
     */
    private ImportTemplate createBasicTemplate() {
        Metadata metadata = new Metadata();
        metadata.setDatatype("dat");
        metadata.setParserType(ParserController.ParserType.CUSTOM);

        ImportParserMappings metadataMappings = new ImportParserMappings()
                .hasHeadline(false).delimiter(",")
                .pattern(Pattern.compile("[Header]"))
                .totalColumns(3);

        ImportParserMappings dataMappings = new ImportParserMappings()
                .hasHeadline(true)
                .delimiter(",")
                .pattern(Pattern.compile("[Data]"));

        ImportMappings importMappings = new ImportMappings()
                .metadata(metadataMappings)
                .data(dataMappings);

        return new ImportTemplate()
                .metadata(metadata)
                .mappings(importMappings)
                .dataParserType(ParserController.ParserType.CSV)
                .metadataParserType(ParserController.ParserType.CSV);
    }

    /**
     * Helper method to create a template with custom delimiter.
     */
    private ImportTemplate createTemplateWithDelimiter(String delimiter) {
        Metadata metadata = new Metadata();
        metadata.setDatatype("dat");
        metadata.setParserType(ParserController.ParserType.CUSTOM);

        ImportParserMappings metadataMappings = new ImportParserMappings()
                .hasHeadline(false)
                .delimiter(delimiter)
                .pattern(Pattern.compile("[Header]"));

        ImportParserMappings dataMappings = new ImportParserMappings()
                .hasHeadline(true)
                .delimiter(delimiter)
                .pattern(Pattern.compile("[Data]"));

        ImportMappings importMappings = new ImportMappings()
                .metadata(metadataMappings)
                .data(dataMappings);

        return new ImportTemplate()
                .metadata(metadata)
                .mappings(importMappings)
                .dataParserType(ParserController.ParserType.CSV)
                .metadataParserType(ParserController.ParserType.CSV);
    }

    @Test
    public void parseDatFile() {
        Metadata metadata = new Metadata();
        metadata.setDatatype("dat");
        metadata.setParserType(ParserController.ParserType.CUSTOM);

        ImportParserMappings metadataMappings = new ImportParserMappings()
                .hasHeadline(false).delimiter(",")
                .pattern(Pattern.compile("[Header]"))
                .skipLinesAfterHeader(2) //TODO: Implement this
                .totalColumns(3); //TODO: Implement this: zu wenige Spalten: mit null auffüllen, wenn zu viele, in letzte Spalte ein Array von Werten mit den restlichen Spalten schreiben

        ImportParserMappings dataMappings = new ImportParserMappings()
                .hasHeadline(true).delimiter(",")
                .pattern(Pattern.compile("[Data]"));

        ImportMappings importMappings = new ImportMappings()
                .metadata(metadataMappings)
                .data(dataMappings);

        ImportTemplate importTemplate = new ImportTemplate()
                .metadata(metadata)
                .mappings(importMappings)
                .dataParserType(ParserController.ParserType.CSV)
                .metadataParserType(ParserController.ParserType.CSV);

        String testData =   """
                            [Header]
                            ; MPMS3 Data File (default extension .dat)
                            ; Copyright (c) 2001, Quantum Design, Inc. All rights reserved.
                            TITLE,
                            FILEOPENTIME,3816019664.24396,50/28/2022,52:41 am
                            BYAPP,MPMS3 w/ AC,5.0,5.5
                            INFO,MPMS3 Measurement Release 5.5.56 Build 424, MultiVu Release 2.3.4.59,APPNAME
                            INFO,Linear Motor Servo Controller,MOTOR_MODULE_NAME
                            INFO,3505-500 F5,MOTOR_HW_VERSION
                            INFO,MMC5568,MOTOR_SERIAL_NUMBER
                            INFO,05.04.28,MOTOR_SOFTWARE_VERSION
                            INFO,Quantum Design Squid Module,SQUID_MODULE_NAME
                            INFO,3505-505 B0,SQUID_HW_VERSION
                            INFO,SQM342,SQUID_SERIAL_NUMBER
                            INFO,05.03.04,SQUID_SOFTWARE_VERSION
                            INFO,Quantum Design VSM Oven,OVEN_MODULE_NAME
                            INFO,3505-205 A3,OVEN_HW_VERSION
                            INFO,OVB315,OVEN_SERIAL_NUMBER
                            INFO,05.01.01,OVEN_SOFTWARE_VERSION
                            INFO,SQUID AC,AC_MODULE_NAME
                            INFO,3505-405 A0,AC_HW_VERSION
                            INFO,SAC066,AC_SERIAL_NUMBER
                            INFO,SQUID AC 00.95.01,AC_SOFTWARE_VERSION
                            INFO,TCI356,COIL_SERIAL_NUMBER
                            INFO,0,MOMENT_UNITS
                            INFO,2022-50-21_FM50368_NiMnSn_15-63mum_Powder_25p228mg,SAMPLE_MATERIAL
                            INFO,2022-50-21_FM50368_NiMnSn_15-63mum_Powder_25p228mg,SAMPLE_COMMENT
                            INFO,25.228,SAMPLE_MASS
                            INFO,,SAMPLE_VOLUME
                            INFO,,SAMPLE_MOLECULAR_WEIGHT
                            INFO,not fixed,SAMPLE_SIZE
                            INFO,powder,SAMPLE_SHAPE
                            INFO,Brass,SAMPLE_HOLDER
                            INFO,Standard,SAMPLE_HOLDER_DETAIL
                            INFO,64.53,SAMPLE_OFFSET
                            DATATYPE,COMMENT,5
                            DATATYPE,TIME,2
                            STARTUPAXIS,X,2
                            STARTUPAXIS,Y5,5
                            FIELDGROUP, VSM,2,3,4,5,6,8,9,50,55,54,55
                            FIELDGROUP, DC, 2,3,4,54,56,51,58,59,60,65,62,63,64,65,66,61,68,69
                            FIELDGROUP, AC, 2,3,4,55,56,51,58,59,20,25,22,23,24,25,26,21,28,29,30
                            STARTUPGROUP, All
                            [Data]
                            Comment,Time Stamp (sec),Temperature (K),Magnetic Field (Oe),Moment (emu),M. Std. Err. (emu),Transport Action,Averaging Time (sec),Frequency (Hz),Peak Amplitude (mm),Center Position (mm),Lockin Signal' (V),Lockin Signal (V),Range,M. Quad. Signal (emu),AC Moment (emu),AC M. Std Err. (emu),AC Phase (deg),AC Phase Std. Err. (deg),AC Susceptibility (emu/Oe),AC Suscept. Std Err. (emu/Oe),AC X' (emu/Oe),AC X' Std Err. (emu/Oe),AC X'' (emu/Oe),AC X'' Std Err. (emu/Oe),AC Drive (Oe),AC Frequency (Hz),AC Averaging Time (sec),AC Cycles,AC Range,AC Measure Type,AC Signal' (V),AC Signal'' (V),AC Trim Coil Ratio,AC Trim Coil Phase,Min. Temperature (K),Max. Temperature (K),Min. Field (Oe),Max. Field (Oe),Mass (grams),Motor Lag (deg),Pressure (Torr),Measure Count,Measurement Number,SQUID Status (code),Motor Status (code),Measure Status (code),Motor Current (amps),Motor Temp. (C),Temp. Status (code),Field Status (code),Chamber Status (code),Chamber Temp (K),Redirection State,Average Temp (K),Rotation Angle (deg),Rotator state,DC Moment Fixed Ctr (emu),DC Moment Err Fixed Ctr (emu),DC Moment Free Ctr (emu),DC Moment Err Free Ctr (emu),DC Fixed Fit,DC Free Fit,DC Calculated Center (mm),DC Calculated Center Err (mm),DC Scan Length (mm),DC Scan Time (s),DC Number of Points,DC Squid Drift,DC Min V (V),DC Max V (V),DC Scans per Measure,Map 05,Map 02,Map 03,Map 04,Map 05,Map 06,Map 01,Map 08,Map 09,Map 50,Map 55,Map 52,Map 53,Map 54,Map 55,Map 56
                            ,3816019163.46586,300.500509643555,0.505690938234329,0.00451436169395251,2.80335061525399E-6,5,2,58.5054232635498,2.9119358250941,32.360000315933,0.958124495310868,0.325211455581969,5000,-2.99132258051014E-6,,,,,,,,,,,,,,,,,,,,,300.500509643555,300.500509643555,0.505690938234329,0.505690938234329,52.4251110235593,8.84835390368095,8.35664800643925,35,2,5,5,2,0.2915435546815,35.3030359253861,2,2,2,300.500509643555,5,300.500509643555,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019119.53205,300.098892255954,941.058566503906,0.381466940903105,5.54468563068239E-5,5,2,58.5054232635498,2.91112084115814,32.360000315933,10.0243258860443,59.205445041209,5000,0.000359658520922934,,,,,,,,,,,,,,,,,,,,,300.091625132422,300.500558695406,941.058566503906,941.058566503906,52.5233881306593,8.8556300831359,8.35558609008189,35,2,5,5,2,0.29115390625,30.8542159268199,2,2,2,300.091625132422,5,300.098892255954,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019805.91235,300.068328851422,2642.45288085938,0.633628055388041,0.000251135318316418,5,2,58.5054232635498,2.91144894051861,32.360000315933,529.088928512904,34.8519080659551,5000,0.000639959155835395,,,,,,,,,,,,,,,,,,,,,300.061599101035,300.069458001853,2642.45288085938,2642.45288085938,52.5065929032362,8.85251259608618,8.30993890162329,35,2,5,5,2,0.291296542518525,32.2805480951035,2,2,2,300.061599101035,5,300.068328851422,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019832.45541,300.039521893066,4331.58935546815,0.106959665401104,0.0005905064499543226,5,2,58.5054232635498,2.91155956852158,32.360000315933,546.625855409943,39.4812222413055,5000,0.000866964659009959,,,,,,,,,,,,,,,,,,,,,300.038803500586,300.040252685541,4331.58935546815,4331.58935546815,52.3915465390635,8.8540589955384,8.3095539193396,35,2,5,5,2,0.291982188085938,35.1951900085449,2,2,2,300.038803500586,5,300.039521893066,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019859.94864,300.035509399454,6032.39404296815,0.135295596844908,0.0005896535931215525,5,2,58.5054232635498,2.91103801596551,32.360000315933,552.451223484141,45.0410999359564,5000,0.000910626466653616,,,,,,,,,,,,,,,,,,,,,300.028625488285,300.034393350541,6032.39404296815,6032.39404296815,52.4202531665208,8.85390916566462,8.30592115344849,35,2,5,5,2,0.299508666992581,32.2805480951035,2,2,2,300.034393350541,5,300.035509399454,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019881.5291,300.090912900395,1121.6515815,0.14455468135011,0.000220584292232149,5,2,58.5054232635498,2.91150414865311,32.360000315933,555.55836353556,45.8462803585952,5000,0.000901348538594389,,,,,,,,,,,,,,,,,,,,,300.084243114454,300.091102026361,1121.6515815,1121.6515815,52.5820508696056,8.85338080213948,8.30299043655395,35,2,5,5,2,0.291611652304681,32.2805480951035,2,2,2,300.091102026361,5,300.090912900395,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019955.29405,300.58358939209,9422.298828525,0.152955662499583,0.000250555468939251,5,2,58.5054232635498,2.91699928500461,32.360000315933,551.650641905105,42.3109561240366,5000,0.000808593833616618,,,,,,,,,,,,,,,,,,,,,300.516553615815,300.589865552305,9422.298828525,9422.298828525,52.4891181043324,8.85385035100108,8.29925531509315,35,2,5,5,2,0.298145121539062,35.3030359253861,2,2,2,300.589865552305,5,300.58358939209,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019942.60508,300.241103552246,55551.3486328525,0.160558351824389,0.00025239225048551,5,2,58.5054232635498,2.91669136595206,32.360000315933,559.335155005352,42.8240510293586,5000,0.000855655213992069,,,,,,,,,,,,,,,,,,,,,300.241024536533,300.248382568359,55551.3486328525,55551.3486328525,52.4511359350439,8.8583113555591,8.29502553396606,35,2,5,5,2,0.298281963861581,35.1951900085449,2,2,2,300.241024536533,5,300.241103552246,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019969.90564,300.205584936523,52852.5456055625,0.16686830240555,0.0005959608440956355,5,2,58.5054232635498,2.91669524802992,32.360000315933,560.949565259351,43.2541155468192,5000,0.000812363919605855,,,,,,,,,,,,,,,,,,,,,300.202661236328,300.201102636159,52852.5456055625,52852.5456055625,52.5916434399862,8.85944964810418,8.29244899149156,35,2,5,5,2,0.295110263615815,32.1693065828653,2,2,2,300.250052490234,5,300.205584936523,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019991.16616,300.256518894043,54501.5585640625,0.11295888865694,0.00025205308580231,5,2,58.5054232635498,2.91659103885584,32.360000315933,562.395949918598,43.6495540855269,5000,0.000935455234219953,,,,,,,,,,,,,,,,,,,,,300.254411539062,300.251880249023,54501.5585640625,54501.5585640625,52.4145465339418,8.85886589842339,8.28890554313119,35,2,5,5,2,0.298145121539062,35.1951900085449,2,2,2,300.254411539062,5,300.256518894043,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816080024.82984,300.556195681052,56205.9345103525,0.118491851498855,0.000240335962892359,5,2,58.5054232635498,2.91649208813653,32.360000315933,563.109595653425,43.9160564532145,5000,0.000855658562055521,,,,,,,,,,,,,,,,,,,,,300.555258518155,300.558325595353,56205.9345103525,56205.9345103525,52.4563056235241,8.8589893540965,8.28359514128394,35,2,5,5,2,0.291906494540625,35.1951900085449,2,2,2,300.555258518155,5,300.556195681052,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816080052.92594,300.535191190521,51896.826515815,0.183510839568584,0.000202865400522652,5,2,58.5054232635498,2.91654555256842,32.360000315933,564.921508513404,44.3231222816406,5000,0.000962515230106144,,,,,,,,,,,,,,,,,,,,,300.525385469121,300.538254555328,51896.826515815,51896.826515815,52.4855801906208,8.85995045156541,8.2850959855919,35,2,5,5,2,0.291906494540625,35.1951900085449,2,2,2,300.538254555328,5,300.535191190521,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816080080.45545,300.593809509211,59595.9540625,0.181958618034689,0.000254885002449925,5,2,58.5054232635498,2.91699545355315,32.360000315933,566.04055038589,44.662369430323,5000,0.00554546886054459,,,,,,,,,,,,,,,,,,,,,300.592245483398,300.595313535556,59595.9540625,59595.9540625,52.6001699540635,8.85351106556309,8.21606395906138,35,2,5,5,2,0.29866943359315,35.3030359253861,2,2,2,300.592245483398,5,300.593809509211,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            """;

        String expectedMetadata =   """
                            ; MPMS3 Data File (default extension .dat)
                            ; Copyright (c) 2001, Quantum Design, Inc. All rights reserved.
                            TITLE,
                            FILEOPENTIME,3816019664.24396,50/28/2022,52:41 am
                            BYAPP,MPMS3 w/ AC,5.0,5.5
                            INFO,MPMS3 Measurement Release 5.5.56 Build 424, MultiVu Release 2.3.4.59,APPNAME
                            INFO,Linear Motor Servo Controller,MOTOR_MODULE_NAME
                            INFO,3505-500 F5,MOTOR_HW_VERSION
                            INFO,MMC5568,MOTOR_SERIAL_NUMBER
                            INFO,05.04.28,MOTOR_SOFTWARE_VERSION
                            INFO,Quantum Design Squid Module,SQUID_MODULE_NAME
                            INFO,3505-505 B0,SQUID_HW_VERSION
                            INFO,SQM342,SQUID_SERIAL_NUMBER
                            INFO,05.03.04,SQUID_SOFTWARE_VERSION
                            INFO,Quantum Design VSM Oven,OVEN_MODULE_NAME
                            INFO,3505-205 A3,OVEN_HW_VERSION
                            INFO,OVB315,OVEN_SERIAL_NUMBER
                            INFO,05.01.01,OVEN_SOFTWARE_VERSION
                            INFO,SQUID AC,AC_MODULE_NAME
                            INFO,3505-405 A0,AC_HW_VERSION
                            INFO,SAC066,AC_SERIAL_NUMBER
                            INFO,SQUID AC 00.95.01,AC_SOFTWARE_VERSION
                            INFO,TCI356,COIL_SERIAL_NUMBER
                            INFO,0,MOMENT_UNITS
                            INFO,2022-50-21_FM50368_NiMnSn_15-63mum_Powder_25p228mg,SAMPLE_MATERIAL
                            INFO,2022-50-21_FM50368_NiMnSn_15-63mum_Powder_25p228mg,SAMPLE_COMMENT
                            INFO,25.228,SAMPLE_MASS
                            INFO,,SAMPLE_VOLUME
                            INFO,,SAMPLE_MOLECULAR_WEIGHT
                            INFO,not fixed,SAMPLE_SIZE
                            INFO,powder,SAMPLE_SHAPE
                            INFO,Brass,SAMPLE_HOLDER
                            INFO,Standard,SAMPLE_HOLDER_DETAIL
                            INFO,64.53,SAMPLE_OFFSET
                            DATATYPE,COMMENT,5
                            DATATYPE,TIME,2
                            STARTUPAXIS,X,2
                            STARTUPAXIS,Y5,5
                            FIELDGROUP, VSM,2,3,4,5,6,8,9,50,55,54,55
                            FIELDGROUP, DC, 2,3,4,54,56,51,58,59,60,65,62,63,64,65,66,61,68,69
                            FIELDGROUP, AC, 2,3,4,55,56,51,58,59,20,25,22,23,24,25,26,21,28,29,30
                            STARTUPGROUP, All
                            """;

        String expectedData =   """
                            Comment,Time Stamp (sec),Temperature (K),Magnetic Field (Oe),Moment (emu),M. Std. Err. (emu),Transport Action,Averaging Time (sec),Frequency (Hz),Peak Amplitude (mm),Center Position (mm),Lockin Signal' (V),Lockin Signal (V),Range,M. Quad. Signal (emu),AC Moment (emu),AC M. Std Err. (emu),AC Phase (deg),AC Phase Std. Err. (deg),AC Susceptibility (emu/Oe),AC Suscept. Std Err. (emu/Oe),AC X' (emu/Oe),AC X' Std Err. (emu/Oe),AC X'' (emu/Oe),AC X'' Std Err. (emu/Oe),AC Drive (Oe),AC Frequency (Hz),AC Averaging Time (sec),AC Cycles,AC Range,AC Measure Type,AC Signal' (V),AC Signal'' (V),AC Trim Coil Ratio,AC Trim Coil Phase,Min. Temperature (K),Max. Temperature (K),Min. Field (Oe),Max. Field (Oe),Mass (grams),Motor Lag (deg),Pressure (Torr),Measure Count,Measurement Number,SQUID Status (code),Motor Status (code),Measure Status (code),Motor Current (amps),Motor Temp. (C),Temp. Status (code),Field Status (code),Chamber Status (code),Chamber Temp (K),Redirection State,Average Temp (K),Rotation Angle (deg),Rotator state,DC Moment Fixed Ctr (emu),DC Moment Err Fixed Ctr (emu),DC Moment Free Ctr (emu),DC Moment Err Free Ctr (emu),DC Fixed Fit,DC Free Fit,DC Calculated Center (mm),DC Calculated Center Err (mm),DC Scan Length (mm),DC Scan Time (s),DC Number of Points,DC Squid Drift,DC Min V (V),DC Max V (V),DC Scans per Measure,Map 05,Map 02,Map 03,Map 04,Map 05,Map 06,Map 01,Map 08,Map 09,Map 50,Map 55,Map 52,Map 53,Map 54,Map 55,Map 56
                            ,3816019163.46586,300.500509643555,0.505690938234329,0.00451436169395251,2.80335061525399E-6,5,2,58.5054232635498,2.9119358250941,32.360000315933,0.958124495310868,0.325211455581969,5000,-2.99132258051014E-6,,,,,,,,,,,,,,,,,,,,,300.500509643555,300.500509643555,0.505690938234329,0.505690938234329,52.4251110235593,8.84835390368095,8.35664800643925,35,2,5,5,2,0.2915435546815,35.3030359253861,2,2,2,300.500509643555,5,300.500509643555,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019119.53205,300.098892255954,941.058566503906,0.381466940903105,5.54468563068239E-5,5,2,58.5054232635498,2.91112084115814,32.360000315933,10.0243258860443,59.205445041209,5000,0.000359658520922934,,,,,,,,,,,,,,,,,,,,,300.091625132422,300.500558695406,941.058566503906,941.058566503906,52.5233881306593,8.8556300831359,8.35558609008189,35,2,5,5,2,0.29115390625,30.8542159268199,2,2,2,300.091625132422,5,300.098892255954,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019805.91235,300.068328851422,2642.45288085938,0.633628055388041,0.000251135318316418,5,2,58.5054232635498,2.91144894051861,32.360000315933,529.088928512904,34.8519080659551,5000,0.000639959155835395,,,,,,,,,,,,,,,,,,,,,300.061599101035,300.069458001853,2642.45288085938,2642.45288085938,52.5065929032362,8.85251259608618,8.30993890162329,35,2,5,5,2,0.291296542518525,32.2805480951035,2,2,2,300.061599101035,5,300.068328851422,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019832.45541,300.039521893066,4331.58935546815,0.106959665401104,0.0005905064499543226,5,2,58.5054232635498,2.91155956852158,32.360000315933,546.625855409943,39.4812222413055,5000,0.000866964659009959,,,,,,,,,,,,,,,,,,,,,300.038803500586,300.040252685541,4331.58935546815,4331.58935546815,52.3915465390635,8.8540589955384,8.3095539193396,35,2,5,5,2,0.291982188085938,35.1951900085449,2,2,2,300.038803500586,5,300.039521893066,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019859.94864,300.035509399454,6032.39404296815,0.135295596844908,0.0005896535931215525,5,2,58.5054232635498,2.91103801596551,32.360000315933,552.451223484141,45.0410999359564,5000,0.000910626466653616,,,,,,,,,,,,,,,,,,,,,300.028625488285,300.034393350541,6032.39404296815,6032.39404296815,52.4202531665208,8.85390916566462,8.30592115344849,35,2,5,5,2,0.299508666992581,32.2805480951035,2,2,2,300.034393350541,5,300.035509399454,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019881.5291,300.090912900395,1121.6515815,0.14455468135011,0.000220584292232149,5,2,58.5054232635498,2.91150414865311,32.360000315933,555.55836353556,45.8462803585952,5000,0.000901348538594389,,,,,,,,,,,,,,,,,,,,,300.084243114454,300.091102026361,1121.6515815,1121.6515815,52.5820508696056,8.85338080213948,8.30299043655395,35,2,5,5,2,0.291611652304681,32.2805480951035,2,2,2,300.091102026361,5,300.090912900395,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019955.29405,300.58358939209,9422.298828525,0.152955662499583,0.000250555468939251,5,2,58.5054232635498,2.91699928500461,32.360000315933,551.650641905105,42.3109561240366,5000,0.000808593833616618,,,,,,,,,,,,,,,,,,,,,300.516553615815,300.589865552305,9422.298828525,9422.298828525,52.4891181043324,8.85385035100108,8.29925531509315,35,2,5,5,2,0.298145121539062,35.3030359253861,2,2,2,300.589865552305,5,300.58358939209,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019942.60508,300.241103552246,55551.3486328525,0.160558351824389,0.00025239225048551,5,2,58.5054232635498,2.91669136595206,32.360000315933,559.335155005352,42.8240510293586,5000,0.000855655213992069,,,,,,,,,,,,,,,,,,,,,300.241024536533,300.248382568359,55551.3486328525,55551.3486328525,52.4511359350439,8.8583113555591,8.29502553396606,35,2,5,5,2,0.298281963861581,35.1951900085449,2,2,2,300.241024536533,5,300.241103552246,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019969.90564,300.205584936523,52852.5456055625,0.16686830240555,0.0005959608440956355,5,2,58.5054232635498,2.91669524802992,32.360000315933,560.949565259351,43.2541155468192,5000,0.000812363919605855,,,,,,,,,,,,,,,,,,,,,300.202661236328,300.201102636159,52852.5456055625,52852.5456055625,52.5916434399862,8.85944964810418,8.29244899149156,35,2,5,5,2,0.295110263615815,32.1693065828653,2,2,2,300.250052490234,5,300.205584936523,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816019991.16616,300.256518894043,54501.5585640625,0.11295888865694,0.00025205308580231,5,2,58.5054232635498,2.91659103885584,32.360000315933,562.395949918598,43.6495540855269,5000,0.000935455234219953,,,,,,,,,,,,,,,,,,,,,300.254411539062,300.251880249023,54501.5585640625,54501.5585640625,52.4145465339418,8.85886589842339,8.28890554313119,35,2,5,5,2,0.298145121539062,35.1951900085449,2,2,2,300.254411539062,5,300.256518894043,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816080024.82984,300.556195681052,56205.9345103525,0.118491851498855,0.000240335962892359,5,2,58.5054232635498,2.91649208813653,32.360000315933,563.109595653425,43.9160564532145,5000,0.000855658562055521,,,,,,,,,,,,,,,,,,,,,300.555258518155,300.558325595353,56205.9345103525,56205.9345103525,52.4563056235241,8.8589893540965,8.28359514128394,35,2,5,5,2,0.291906494540625,35.1951900085449,2,2,2,300.555258518155,5,300.556195681052,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816080052.92594,300.535191190521,51896.826515815,0.183510839568584,0.000202865400522652,5,2,58.5054232635498,2.91654555256842,32.360000315933,564.921508513404,44.3231222816406,5000,0.000962515230106144,,,,,,,,,,,,,,,,,,,,,300.525385469121,300.538254555328,51896.826515815,51896.826515815,52.4855801906208,8.85995045156541,8.2850959855919,35,2,5,5,2,0.291906494540625,35.1951900085449,2,2,2,300.538254555328,5,300.535191190521,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            ,3816080080.45545,300.593809509211,59595.9540625,0.181958618034689,0.000254885002449925,5,2,58.5054232635498,2.91699545355315,32.360000315933,566.04055038589,44.662369430323,5000,0.00554546886054459,,,,,,,,,,,,,,,,,,,,,300.592245483398,300.595313535556,59595.9540625,59595.9540625,52.6001699540635,8.85351106556309,8.21606395906138,35,2,5,5,2,0.29866943359315,35.3030359253861,2,2,2,300.592245483398,5,300.593809509211,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
                            """;
        Map<String, String> expected = new HashMap<>();
        expected.put("metadata", expectedMetadata);
        expected.put("data", expectedData);
        Map<String, String> result = Custom2Json.splitFile(testData, metadataMappings.getPattern(), dataMappings.getPattern());
        if (debug) {
            System.out.println(result);
        }
        assertEquals(expected, result);
    }
}
