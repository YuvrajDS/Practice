package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Excel {
    public File src;

    public Excel(String path) {
        String projectpath = System.getProperty("user.dir");
        src = new File(projectpath + path);
    }

    public String readtext(String sheetname,int rownumber,int column ) throws Exception {

        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheet(sheetname);
        String str=sheet.getRow(rownumber).getCell(column).getStringCellValue();
        return str;
    }

    public int readnumber(String sheetname,int rownumber,int column ) throws Exception {

        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheet(sheetname);
        int num=(int) sheet.getRow(rownumber).getCell(column).getNumericCellValue();
        return num;
    }

    public void writeexcel(String value,String sheetname,int row,int col) throws Exception {

        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook xsf=new XSSFWorkbook(fis);
        XSSFSheet sheet=xsf.getSheet(sheetname);
        sheet.getRow(row).getCell(col).setCellValue(value);
        FileOutputStream fos=new FileOutputStream(src);
        xsf.write(fos);
        xsf.close();
    }

    public void writeexcel(int value,String sheetname,int row,int col) throws Exception {

        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook xsf=new XSSFWorkbook(fis);
        XSSFSheet sheet=xsf.getSheet(sheetname);
        sheet.getRow(row).getCell(col).setCellValue(value);
        FileOutputStream fos=new FileOutputStream(src);
        xsf.write(fos);
        xsf.close();

    }
}
