package utils.reader;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    static XSSFWorkbook wb;
    static XSSFSheet sheet;

    public ExcelReader(String excelPAth, String sheetName) {
        try {
            wb = new XSSFWorkbook(excelPAth);
            sheet = wb.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }

    public void getCellDataNumber(int rowsNum, int colNum) {
        try {
            double cellData = sheet.getRow(rowsNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellData);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public String getCellDataString(int rowNum, int colNum) {
        String cellData = null;
        try {
//            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            DataFormatter formatter = new DataFormatter();
            cellData = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }

    public int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;
    }
}