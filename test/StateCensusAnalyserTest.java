import com.bridgelabz.censusanalyser.CSVStateCensus;
import com.bridgelabz.censusanalyser.StateCensusAnalyser;
import com.bridgelabz.censusanalyser.CensusAnalyserException;
import com.opencsv.exceptions.CsvException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @desc Test cases for StateCensusAnalyser
 */
public class StateCensusAnalyserTest {

    /**
     * @desc Verfiying record count
     */
    @Test
    public void testVerifyRecordCount() {

        String filePath = "D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\StateCensus.csv";
        int expectedCount = 37;

        try {
            StateCensusAnalyser<CSVStateCensus> analyser = new StateCensusAnalyser<>();
            List<CSVStateCensus> censusDataList = analyser.loadCensusData(filePath, CSVStateCensus.class);

            // Verify the number of records matches the expected count
            analyser.verifyRecordCount(expectedCount);

            assertEquals("Number of records does not match expected count.", expectedCount, censusDataList.size());
        } catch (IOException | CsvException | CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc To verify if the exception is raised when incorrect csv file is given
     */
    @Test
    public void testLoadCensusDataWithIncorrectFile() {

        String incorrectFilePath = "incorrect_file.csv";

        try {
            StateCensusAnalyser<CSVStateCensus> analyser = new StateCensusAnalyser<>();

            List<CSVStateCensus> censusDataList = analyser.loadCensusData(incorrectFilePath, CSVStateCensus.class);

            fail("Expected CensusAnalyserException was not thrown.");
        } catch (IOException | CsvException | CensusAnalyserException e) {

        }
    }

    /**
     * @desc Test case to verify if the type is incorrect then exception is raised
     */
    @Test
    public void testLoadCensusDataWithIncorrectFileType() {

        String filePath = "D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\StateCensus.txt";

        try {
            StateCensusAnalyser<CSVStateCensus> analyser = new StateCensusAnalyser<>();


            List<CSVStateCensus> censusDataList = analyser.loadCensusData(filePath, CSVStateCensus.class);

            fail("Expected CensusAnalyserException was not thrown.");
        } catch (IOException | CensusAnalyserException | CsvException e) {

            assertEquals("Error loading census data: Invalid file type.", e.getMessage());
        }
    }
}