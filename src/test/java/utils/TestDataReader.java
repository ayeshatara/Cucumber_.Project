package utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestDataReader {
    //src/test/resources/Test scenario-Ayesha Tarannum.xlsx
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/Test scenario-Ayesha Tarannum.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
    }
}
