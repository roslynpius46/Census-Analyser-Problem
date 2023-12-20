package com.bridgelabz.censusanalyser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @desc StateCodeAnalyser class for loading and analyzing state code data from a CSV file.
 * @param <T> Type parameter
 */
public class StateCodeAnalyser<T> {

    private List<T> codeDataList;

    /**
     * @desc Constructor to initialize the StateCodeAnalyser.
     */
    public StateCodeAnalyser() {
        this.codeDataList = new ArrayList<>();
    }

    /**
     * @desc Load state code data from a CSV file.
     * @param filePath The path to the CSV file.
     * @param type     The class type representing the data model.
     * @return A list containing the loaded census data.
     * @throws IOException   If an I/O error occurs.
     * @throws CsvException  If an error occurs while parsing the CSV file.
     * @throws CensusAnalyserException If an error occurs during the census analysis.
     */
    public List<T> loadCodeData(String filePath, Class<T> type,char expectedDelimiter) throws IOException, CsvException, CensusAnalyserException {

        String[] expectedHeader = {"SrNo", "StateName", "StateCode"};

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).build()) {

            if (!filePath.endsWith(".csv")) {
                throw new CensusAnalyserException("Error loading census data: Invalid file type.");
            }
            // Check if the CSVReader's delimiter matches the expected delimiter
            if (csvReader.getParser().getSeparator() != expectedDelimiter) {
                throw new CensusAnalyserException("Error loading census data: Incorrect file delimiter.");
            }

            List<String[]> records = csvReader.readAll();
            Iterator<String[]> iterator = records.iterator();


            if (!iterator.hasNext()) {
                throw new CensusAnalyserException("CSV file is empty.");
            }
            // Check if the header matches the expected format
            String[] actualHeader = iterator.next();
            if (!Arrays.equals(actualHeader, expectedHeader)) {
                throw new CensusAnalyserException("Error loading census data: Incorrect header format.");
            }

            while (iterator.hasNext()) {
                String[] record = iterator.next();
                T codeData = createCodeData(record, type);
                codeDataList.add(codeData);
            }
        }
        return codeDataList;
    }

    /**
     * @desc Creates an instance of the data model class.
     * @param record The CSV record containing data for a single entry.
     * @param type   The class type representing the data model.
     * @return An instance of the data model class having data from the CSV record.
     * @throws RuntimeException If an error occurs during the instantiation or data conversion process.
     */
    private T createCodeData(String[] record, Class<T> type) {
        try {

            return type.getConstructor(int.class, String.class,String.class)
                    .newInstance(Integer.parseInt(record[0]), record[1], record[2]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating code data");
        }
    }

    /**
     * @desc Verify the number of records matches the expected count.
     * @param expectedCount The expected count of records.
     */
    public void verifyRecordCount(int expectedCount) {
        if (codeDataList.size() != expectedCount) {
            throw new RuntimeException("Number of records do not match the expected count.");
        } else {
            System.out.println("Number of records match the expected count.");
        }
    }
}