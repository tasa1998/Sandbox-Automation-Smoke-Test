package excel_core;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetExcelData {

    public Map<String, String> getRowData(String fileName, String sheetName , int rowNum) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet1 = workbook.getSheet(sheetName);

        int lastColumn = sheet1.getRow(1).getLastCellNum();

        Map<String,String> mapa = new HashMap<>();

        for(int i = 0;i<lastColumn; i++) {
            String key, value;

            try{
                key = sheet1.getRow(0).getCell(i).getStringCellValue().trim();
            }catch (Exception e){
                key = String.valueOf(sheet1.getRow(0).getCell(i).getNumericCellValue());
            }

            try{
                value = sheet1.getRow(rowNum+1).getCell(i).getStringCellValue().trim();
            }catch (Exception e){
                value = String.valueOf(sheet1.getRow(rowNum+1).getCell(i).getNumericCellValue());
            }

            mapa.put(key,value);
        }

        return mapa;
    }
}
