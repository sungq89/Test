package ExcelForSignin;

import java.io.File;

import jxl.Cell;
import jxl.CellType;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class UpdateExcel {
	public static void main(String args[]) {
        try {
        	
        	Label label = null;
        	DateTime datetime = null;
            //Excel����ļ� 
            Workbook wb = Workbook.getWorkbook(new File("����.xls"));
            //��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ� 
            WritableWorkbook book = Workbook.createWorkbook(new File("����.xls"), wb);
            //���һ�������� 
//            WritableSheet sheet = book.createSheet("�ڶ�ҳ", 1);
//            sheet.addCell(new Label(0, 0, "�ڶ�ҳ�Ĳ�������"));
            WritableSheet sheet = book.getSheet(0);
//            Cell cell = sheet.getCell(0,1);
            WritableCell cell1 = sheet.getWritableCell(0,0);
            System.out.println(cell1.getType());
            
//            if(cell.getContents().equals("����")){
//            	if(cell.getType() == CellType.LABEL){
//            		label = (Label) cell;
//            		label.setString(cell.getContents()+"---�޸ĺ�");
            		
//            		label = (Label) cell1;
//            		label.setString(cell1.getContents().toString()+"---�޸�");
            		
            		
//            	}
            	
//            }
            
            
            book.write();
            book.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
