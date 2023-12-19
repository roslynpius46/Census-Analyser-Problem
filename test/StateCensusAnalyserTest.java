import com.bridgelabz.censusanalyser.CSVStateCensus;
import com.bridgelabz.censusanalyser.StateCensusAnalyser;
import com.opencsv.exceptions.CsvException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @desc Test cases for StateCensusAnalyser
 */
public class StateCensusAnalyserTest {

    /**
     * @desc Verifying record count
     */
    @Test
    public void testVerifyRecordCount() {

        String filePath = "D:\\GE_BridgeLabz\\Census_Analyser_Problem\\src\\com\\bridgelabz\\censusanalyser\\sample-census-data.csv";
        int expectedCount = 37;

        try {
            StateCensusAnalyser<CSVStateCensus> analyser = new StateCensusAnalyser<>();
            List<CSVStateCensus> censusDataList = analyser.loadCensusData(filePath, CSVStateCensus.class);

            // Verify the number of records matches the expected count
            analyser.verifyRecordCount(expectedCount);

            assertEquals("Number of records does not match expected count.", expectedCount, censusDataList.size());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}