package com.bridgelabz.censusanalyser;

/**
 * @desc Represents a data model for state census information from a CSV file.
 */
public class CSVStateCode {

    private int srNo;
    private String stateName;
    private String stateCode;

    /**
     * @desc Default constructor.
     */
    public CSVStateCode() {

    }

    /**
     * @desc Parameterized constructor to initialize CSVStateCensus with data.
     * @param srNo      The serial number.
     * @param stateName The state name.
     * @param stateCode The state code.
     */
    public CSVStateCode(int srNo, String stateName, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.stateCode = stateCode;
    }

    /**
     * @desc Get the serial number.
     * @return The serial number.
     */
    public int getSrNo() {
        return srNo;
    }

    /**
     * @desc Set the serial number.
     * @param srNo The serial number.
     */
    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    /**
     * @desc Get the state name.
     * @return The state name.
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @desc Set the state name.
     * @param stateName The state name.
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @desc Get the state code.
     * @return The state code.
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * @desc Set the state code.
     * @param stateCode The state code.
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
