package com.example.primenumbers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ExcelDataProcessor {

    private final NumbersIdentifier numbersIdentifier;

    public ExcelDataProcessor() {
        this.numbersIdentifier = new NumbersIdentifier();
    }

    public void processExcelFile(File file) {
        try (Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(1);
                String cellValue = cell.getStringCellValue();
                if (numbersIdentifier.isPositiveInteger(cellValue)) {
                    if (numbersIdentifier.isPrimeNumber(Long.parseLong(cellValue))) {
                        System.out.println(cellValue);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
