package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelUtils {

    public static void writeHomeLoanData(String filePath, List<List<String>> tableData) {

        try {
            Workbook workbook;
            Sheet sheet;

            FileInputStream fis = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fis);
            if (workbook.getSheet("Yearly_Breakup") != null) {
                int index = workbook.getSheetIndex("Yearly_Breakup");
                workbook.removeSheetAt(index);
            }
            sheet = workbook.createSheet("Yearly_Breakup");
            int rowNum = 1;
            for (List<String> rowData : tableData) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (String cellData : rowData) {
                    row.createCell(colNum++).setCellValue(cellData);
                }
            }
            fis.close();
            FileOutputStream fos = new FileOutputStream(filePath);
            workbook.write(fos);
            fos.close();
            workbook.close();
            System.out.println("Data written to Excel successfully.");

        } catch (Exception e) {
            throw new RuntimeException("Failed to write Excel Data", e);
        }
    }
}
