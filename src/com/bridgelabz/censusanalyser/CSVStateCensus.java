package com.bridgelabz.censusanalyser;

/**
 * Represents a data model for state census information from a CSV file.
 */
public class CSVStateCensus {

    private int srNo;
    private String stateName;
    private String tin;
    private String stateCode;

    /**
     * Default constructor.
     */
    public CSVStateCensus() {

    }

    /**
     * Parameterized constructor to initialize CSVStateCensus with data.
     *
     * @param srNo      The serial number.
     * @param stateName The state name.
     * @param tin       The TIN (Taxpayer Identification Number).
     * @param stateCode The state code.
     */
    public CSVStateCensus(int srNo, String stateName, String tin, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }

    /**
     * Get the serial number.
     *
     * @return The serial number.
     */
    public int getSrNo() {
        return srNo;
    }

    /**
     * Set the serial number.
     *
     * @param srNo The serial number.
     */
    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    /**
     * Get the state name.
     *
     * @return The state name.
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * Set the state name.
     *
     * @param stateName The state name.
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * Get the TIN (Taxpayer Identification Number).
     *
     * @return The TIN.
     */
    public String getTin() {
        return tin;
    }

    /**
     * Set the TIN (Taxpayer Identification Number).
     *
     * @param tin The TIN.
     */
    public void setTin(String tin) {
        this.tin = tin;
    }

    /**
     * Get the state code.
     *
     * @return The state code.
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Set the state code.
     *
     * @param stateCode The state code.
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
