package com.example.primenumbers;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("One argument expected, but " + args.length + " were provided.");
        }

        File excelFile = new File(args[0]);
        if (!excelFile.exists() || !excelFile.isFile() || !args[0].endsWith(".xlsx")) {
            throw new IllegalArgumentException("Provided argument is not a valid MS Excel file path.");
        }

        System.out.println("Opening the file on path: " + args[0]);

        if (!excelFile.canRead()) {
            throw new RuntimeException("No permission to read the file. Aborting.");
        }

        System.out.println("Printing prime numbers:");
        ExcelDataProcessor excelDataProcessor = new ExcelDataProcessor();
        excelDataProcessor.processExcelFile(excelFile);
    }
}
