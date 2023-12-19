package com.bridgelabz.censusanalyser;

/**
 * @desc Custom exception class for CensusAnalyser.
 */
public class CensusAnalyserException extends Exception {


    /**
     * @desc Constructs a new CensusAnalyserException with the specified detail message.
     * @param message the detail message.
     */
    public CensusAnalyserException(String message) {
        super(message);
    }

    /**
     * @desc Constructs a new CensusAnalyserException with the specified detail message and cause.
     * @param message the detail message.
     * @param cause   the cause (which is saved for later retrieval by the getCause() method).
     */
    public CensusAnalyserException(String message, Throwable cause) {
        super(message, cause);
    }
}
