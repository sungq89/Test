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
            //Excel获得文件 
            Workbook wb = Workbook.getWorkbook(new File("测试.xls"));
            //打开一个文件的副本，并且指定数据写回到原文件 
            WritableWorkbook book = Workbook.createWorkbook(new File("测试.xls"), wb);
            //添加一个工作表 
//            WritableSheet sheet = book.createSheet("第二页", 1);
//            sheet.addCell(new Label(0, 0, "第二页的测试数据"));
            WritableSheet sheet = book.getSheet(0);
//            Cell cell = sheet.getCell(0,1);
            WritableCell cell1 = sheet.getWritableCell(0,0);
            System.out.println(cell1.getType());
            
//            if(cell.getContents().equals("日期")){
//            	if(cell.getType() == CellType.LABEL){
//            		label = (Label) cell;
//            		label.setString(cell.getContents()+"---修改后");
            		
//            		label = (Label) cell1;
//            		label.setString(cell1.getContents().toString()+"---修改");
            		
            		
//            	}
            	
//            }
            
            
            book.write();
            book.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
