package ExcelForSignin;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadXls {
	public static void main(String args[]) {
        try {
            Workbook book = Workbook.getWorkbook(new File("����.xls"));
            //��õ�һ����������� 
            Sheet sheet = book.getSheet(0);
            
            //�õ���һ�е�һ�еĵ�Ԫ�� 
            Cell cell1 = sheet.getCell(0, 1);
            String result = cell1.getContents();
            int result1 = cell1.getColumn();
            System.out.println(result);
            System.out.println(sheet.getColumns());
            book.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
