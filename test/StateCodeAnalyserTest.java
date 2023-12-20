import com.bridgelabz.censusanalyser.CSVStateCode;
import com.bridgelabz.censusanalyser.StateCodeAnalyser;
import com.opencsv.exceptions.CsvException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
            List<CSVStateCode> codeDataList = analyser.loadCodeData(filePath, CSVStateCode.class);

            // Verify the number of records matches the expected count
            analyser.verifyRecordCount(expectedCount);

            assertEquals("Number of records does not match expected count.", expectedCount, codeDataList.size());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}