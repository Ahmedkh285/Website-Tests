package utils.provider;

import org.testng.annotations.DataProvider;
import utils.reader.ExcelReader;

public class ExcelDataProvider {

    @DataProvider(name = "logintest")
    public Object[][] validLoginData(){
        return testData("src/test/java/utils/data/data.xlsx", "Sheet2");
    }
    @DataProvider(name = "registerWithExistingEmail")
    public Object[][] existingData(){
        return testData("src/test/java/utils/data/data.xlsx", "Sheet3");
    }

    public Object[][] testData(String excelPath, String sheetName) {
        ExcelReader excel;
        excel = new ExcelReader(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object[][] data = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellDataString(i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }
}