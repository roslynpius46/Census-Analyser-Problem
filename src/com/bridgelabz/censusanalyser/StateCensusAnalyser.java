package com.bridgelabz.censusanalyser;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @desc StateCensusAnalyser class for loading and analyzing state census data from a CSV file.
 * @param <T> Type parameter
 */
public class StateCensusAnalyser<T> {

    private List<T> censusDataList;

    /**
     * @desc Constructor to initialize the StateCensusAnalyser.
     */
    public StateCensusAnalyser() {
        this.censusDataList = new ArrayList<>();
    }

    /**
     * @desc Load state census data from a CSV file.
     * @param filePath The path to the CSV file.
     * @param type     The class type representing the data model.
     * @return A list containing the loaded census data.
     * @throws IOException        If an I/O error occurs.
     * @throws CsvException       If an error occurs while parsing the CSV file.
     * @throws CensusAnalyserException If an error occurs during the census analysis.
     */
    public List<T> loadCensusData(String filePath, Class<T> type) throws IOException, CsvException, CensusAnalyserException {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).build()) {
            List<String[]> records = csvReader.readAll();
            Iterator<String[]> iterator = records.iterator();

            if (!filePath.endsWith(".csv")) {
                throw new CensusAnalyserException("Error loading census data: Invalid file type.");
            }
            if (!iterator.hasNext()) {
                throw new CensusAnalyserException("CSV file is empty.");
            }
            iterator.next(); // Skipping header

            while (iterator.hasNext()) {
                String[] record = iterator.next();
                T censusData = createCensusData(record, type);
                censusDataList.add(censusData);
            }
        }
        return censusDataList;
    }


    /**
     * @desc Creates an instance of the data model class.
     * @param record The CSV record containing data for a single entry.
     * @param type   The class type representing the data model.
     * @return An instance of the data model class having data from the CSV record.
     * @throws CensusAnalyserException If an error occurs during the census analysis.
     */
    private T createCensusData(String[] record, Class<T> type) throws CensusAnalyserException {
        try {
            // Assuming state name is in record[1]
            return type.getConstructor(int.class, String.class, String.class, String.class)
                    .newInstance(Integer.parseInt(record[0]), record[1], record[2], record[3]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CensusAnalyserException("Error creating census data", e);
        }
    }

    /**
     * @desc Verify the number of records matches the expected count.
     * @param expectedCount The expected count of records.
     * @throws CensusAnalyserException If the number of records does not match the expected count.
     */
    public void verifyRecordCount(int expectedCount) throws CensusAnalyserException {
        if (censusDataList.size() != expectedCount) {
            throw new CensusAnalyserException("Number of records do not match the expected count.");
        } else {
            System.out.println("Number of records match the expected count.");
        }
    }
}
