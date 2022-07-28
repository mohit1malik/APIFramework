package ExcelUtils;

public class ExcelUtilityTest {
    public static void main(String[] args) {
        ExcelUtils eu = new ExcelUtils("./data/testData.xlsx", "Sheet1");

        eu.getRowCount();
        eu.getCellData(1,0);
        eu.getCellData(1,1);
        eu.getCellData(2,0);
        eu.getCellData(2,1);


    }
}
