package ExcelForSignin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import jxl.CellType;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelForSignInTest {

	// 创建一个按钮
	private JButton b;
	// 输入栏
	private JTextField text;
	
	private java.awt.Label label;

	//
	// private Workbook wb = null;
	//
	// private WritableWorkbook book = null;

	// 构造方法
	public ExcelForSignInTest() {
		// 创建窗口
		JFrame frame = new JFrame("签到");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new java.awt.FlowLayout());
		// 实例化按钮
		b = new JButton("签到");
		b.setLocation(100, 100);
		//实例化输入框
		text = new JTextField("请输入签到时间");
		//实例化显示框
		label = new java.awt.Label("签到时间");
		label.setLocation(70, 70);
		
		// 创建按钮监听
		ActionListener buttonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String day = text.getText();
				// 签到逻辑
				signInForExcel(day);
			}
		};

		KeyAdapter textListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// int code =e.getKeyCode(); //获取键关联的整数
				// //文本框中只能输入数字(屏蔽键)
				// // if(!(code>=KeyEvent.VK_0 &&code<=KeyEvent.VK_9))
				// // {
				// // System.out.println(e.getKeyText(code)+code+"……非法");
				// //使用此事件，以便不会按照默认的方式由产生此事件的源代码来处理此事件。
				// e.consume(); //默认是将按下的键添加到文本框中。注意这里不是将监听器删掉
				// // }
			}
		};

		frame.setSize(300, 200);
		// 给按钮增加监听
		b.addActionListener(buttonAction);
		// text.addKeyListener(textListener);

		// 将按钮增加到窗体内
		frame.getContentPane().add(b);
		frame.getContentPane().add(text);
		frame.getContentPane().add(label);
		// frame.pack();
		frame.setVisible(true);

	}

	/**
	 * 打开excel 增加签到时间
	 * 
	 * @param args
	 */
	public void signInForExcel(String SignDate) {

		Workbook wb = null;
		WritableWorkbook book = null;

		try {
			// Excel获得文件
			wb = Workbook.getWorkbook(new File("测试.xls"));
			// 打开一个文件的副本，并且指定数据写回到原文件
			book = Workbook.createWorkbook(new File("测试.xls"), wb);

			WritableCell cell = null;
			WritableCellFormat wcf = null;
			Label label = null;
			WritableCellFeatures wcfeatures = null;
			
			Date now = new Date(System.currentTimeMillis());
			SimpleDateFormat dfFor8 = new SimpleDateFormat("yyyy-MM-dd");

			if(now.getDay() == 0){
				WritableSheet sheet = book.createSheet(dfFor8.format(now).toString(), book.getNumberOfSheets()+1);
				sheet.addCell(new Label(0, 0, "日期"));
				sheet.addCell(new Label(1, 0, "上班打卡时间"));
				sheet.addCell(new Label(2, 0, "下班打卡时间"));
				sheet.addCell(new Label(3, 0, "缺勤时长"));
				sheet.addCell(new Label(4, 0, "加班时长"));
				sheet.addCell(new Label(5, 0, "单日总计"));
			}
			
			WritableSheet sheet = book.getSheet(0);
			int sheetColum = sheet.getColumns();
			int sheetRow = sheet.getRows();
			if (sheetColum == 0) {
				
			}
			
			Date today = null;
			System.out.println(SignDate);
			if(SignDate==null||"".equals(SignDate))
				today = new Date();
			else
				today = new Date(SignDate);
			// today.setTime(time);
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String day = df.format(today).toString();
			int i = 0;
			for (i = 0; i <= sheetRow; i++) {
				if (!CellType.EMPTY.equals(sheet.getWritableCell(0, i).getType())) {
					if (day.equals(df.format(
							((DateTime) sheet.getWritableCell(0, i)).getDate()).toString())) {
						sheet.addCell(new Label(i, 1, "test"));
						break;
					}
				}
				;
			}

			// cell = sheet.getWritableCell(0,5);
			// if(cell.getType() == CellType.LABEL){
			// label = (Label) cell;
			// label.setString("单日总计");
			// }
			// 为单元格设置时间+时间格式
			// cell = sheet.getWritableCell(0,1);
			// Date date = new Date();
			// DateFormat df = new DateFormat("yyyy-MM-dd");
			// WritableCellFormat wcfDF = new WritableCellFormat(df);
			// if(cell.getType() == CellType.DATE){
			// DateTime datecell = (DateTime) cell;
			// datecell.setDate(date);
			// datecell.setCellFormat(wcfDF);
			// }

			book.write();
			book.close();

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(book!= null){
					book.write();
					book.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExcelForSignInTest excle = new ExcelForSignInTest();
	}

}
