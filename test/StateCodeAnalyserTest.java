import com.bridgelabz.censusanalyser.CSVStateCode;
import com.bridgelabz.censusanalyser.StateCodeAnalyser;
import com.bridgelabz.censusanalyser.CensusAnalyserException;
import com.opencsv.exceptions.CsvException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @desc Test cases for StateCensusAnalyser
 */
public class StateCodeAnalyserTest {

    /**
     * @desc Verifying record count
     */
    @Test
    public void testVerifyRecordCount() {

        String filePath = "D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\StatesCode.csv";
        int expectedCount = 35;

        try {
            StateCodeAnalyser<CSVStateCode> analyser = new StateCodeAnalyser<>();
            List<CSVStateCode> codeDataList = analyser.loadCodeData(filePath, CSVStateCode.class,',');

            // Verify the number of records matches the expected count
            analyser.verifyRecordCount(expectedCount);

            assertEquals("Number of records does not match expected count.", expectedCount, codeDataList.size());
        } catch (IOException | CsvException | CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc To verify if the exception is raised when incorrect csv file is given
     */
    @Test
    public void testLoadCodeDataWithIncorrectFile() {

        String incorrectFilePath = "incorrect_file.csv";

        try {
            StateCodeAnalyser<CSVStateCode> analyser = new StateCodeAnalyser<>();

            List<CSVStateCode> censusDataList = analyser.loadCodeData(incorrectFilePath, CSVStateCode.class,',');

            fail("Expected CensusAnalyserException was not thrown.");
        } catch (IOException | CsvException | CensusAnalyserException e) {

        }
    }

    /**
     * @desc Test case to verify if the type is incorrect then exception is raised
     */
    @Test
    public void testLoadCodeDataWithIncorrectFileType() {

        String filePath = "D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\StateCensus.txt";

        try {
            StateCodeAnalyser<CSVStateCode> analyser = new StateCodeAnalyser<>();


            List<CSVStateCode> codeDataList = analyser.loadCodeData(filePath, CSVStateCode.class,',');

            fail("Expected CensusAnalyserException was not thrown.");
        } catch (IOException | CensusAnalyserException | CsvException e) {

            assertEquals("Error loading census data: Invalid file type.", e.getMessage());
        }
    }

    /**
     * Sad Test Case: Verify if a custom exception is thrown when the file delimiter is incorrect.
     */
    @Test
    public void testLoadCensusDataWithIncorrectDelimiter() {
        String filePath = "D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\census_incorrect_delimiter.csv";

        try {
            StateCodeAnalyser<CSVStateCode> analyser = new StateCodeAnalyser<>();
            List<CSVStateCode> censusDataList = analyser.loadCodeData(filePath, CSVStateCode.class,';');

            // If the above line does not throw an exception, fail the test
            fail("Expected CodeAnalyserException was not thrown.");
        } catch (IOException | CensusAnalyserException | CsvException e) {
            // Ensure that the exception message matches the expected message
            assertEquals("Error loading census data: Incorrect file delimiter.", e.getMessage());
        }
    }
}