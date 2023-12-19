package com.bridgelabz.censusanalyser;

/**
 * Custom exception class for CensusAnalyser.
 */
public class CensusAnalyserException extends Exception {

    /**
     * Constructs a new CensusAnalyserException with the specified detail message.
     *
     * @param message the detail message.
     */
    public CensusAnalyserException(String message) {
        super(message);
    }

    /**
     * Constructs a new CensusAnalyserException with the specified detail message and cause.
     *
     * @param message the detail message.
     * @param cause   the cause (which is saved for later retrieval by the getCause() method).
     */
    public CensusAnalyserException(String message, Throwable cause) {
        super(message, cause);
    }
}
