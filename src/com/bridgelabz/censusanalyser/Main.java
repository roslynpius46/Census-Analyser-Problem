package com.bridgelabz.censusanalyser;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Census Analyser Implementation");

        try {
            //USE CASE 1
            StateCensusAnalyser<CSVStateCensus> analyser1 = new StateCensusAnalyser<>();
            List<CSVStateCensus> censusDataList = analyser1.loadCensusData("D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\StateCensus.csv", CSVStateCensus.class,',');
            analyser1.verifyRecordCount(37);

            //USE CASE 2
            StateCodeAnalyser<CSVStateCode> analyser2 = new StateCodeAnalyser<>();
            List<CSVStateCode> codeDataList = analyser2.loadCodeData("D:\\GE_BridgeLabz\\Census_Analyser\\src\\com\\bridgelabz\\censusanalyser\\StatesCode.csv", CSVStateCode.class,',');
            analyser2.verifyRecordCount(35);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}