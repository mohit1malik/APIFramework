package ExcelUtils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelUtils {
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    public ExcelUtils(String excelPath, String sheetName){

        try {
            InputStream file = new FileInputStream(excelPath);
            wb= new XSSFWorkbook(file);
            sheet = wb.getSheet(sheetName);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }



    public static void getRowCount(){
            int rowcount  = sheet.getPhysicalNumberOfRows();
            System.out.println("Active row count is "+ rowcount);
    }

    public static void getCellData(int rowNumber, int colNumber){
            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(rowNumber).getCell(colNumber));
            System.out.println(value);
//            String firstname = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
//            System.out.println(firstname);
    }

    public static void main(String[] args) {
        getRowCount();
        getCellData(1,1);
    }
}
