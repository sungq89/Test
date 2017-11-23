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

	// ����һ����ť
	private JButton b;
	// ������
	private JTextField text;
	
	private java.awt.Label label;

	//
	// private Workbook wb = null;
	//
	// private WritableWorkbook book = null;

	// ���췽��
	public ExcelForSignInTest() {
		// ��������
		JFrame frame = new JFrame("ǩ��");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new java.awt.FlowLayout());
		// ʵ������ť
		b = new JButton("ǩ��");
		b.setLocation(100, 100);
		//ʵ���������
		text = new JTextField("������ǩ��ʱ��");
		//ʵ������ʾ��
		label = new java.awt.Label("ǩ��ʱ��");
		label.setLocation(70, 70);
		
		// ������ť����
		ActionListener buttonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String day = text.getText();
				// ǩ���߼�
				signInForExcel(day);
			}
		};

		KeyAdapter textListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// int code =e.getKeyCode(); //��ȡ������������
				// //�ı�����ֻ����������(���μ�)
				// // if(!(code>=KeyEvent.VK_0 &&code<=KeyEvent.VK_9))
				// // {
				// // System.out.println(e.getKeyText(code)+code+"�����Ƿ�");
				// //ʹ�ô��¼����Ա㲻�ᰴ��Ĭ�ϵķ�ʽ�ɲ������¼���Դ������������¼���
				// e.consume(); //Ĭ���ǽ����µļ���ӵ��ı����С�ע�����ﲻ�ǽ�������ɾ��
				// // }
			}
		};

		frame.setSize(300, 200);
		// ����ť���Ӽ���
		b.addActionListener(buttonAction);
		// text.addKeyListener(textListener);

		// ����ť���ӵ�������
		frame.getContentPane().add(b);
		frame.getContentPane().add(text);
		frame.getContentPane().add(label);
		// frame.pack();
		frame.setVisible(true);

	}

	/**
	 * ��excel ����ǩ��ʱ��
	 * 
	 * @param args
	 */
	public void signInForExcel(String SignDate) {

		Workbook wb = null;
		WritableWorkbook book = null;

		try {
			// Excel����ļ�
			wb = Workbook.getWorkbook(new File("����.xls"));
			// ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
			book = Workbook.createWorkbook(new File("����.xls"), wb);

			WritableCell cell = null;
			WritableCellFormat wcf = null;
			Label label = null;
			WritableCellFeatures wcfeatures = null;
			
			Date now = new Date(System.currentTimeMillis());
			SimpleDateFormat dfFor8 = new SimpleDateFormat("yyyy-MM-dd");

			if(now.getDay() == 0){
				WritableSheet sheet = book.createSheet(dfFor8.format(now).toString(), book.getNumberOfSheets()+1);
				sheet.addCell(new Label(0, 0, "����"));
				sheet.addCell(new Label(1, 0, "�ϰ��ʱ��"));
				sheet.addCell(new Label(2, 0, "�°��ʱ��"));
				sheet.addCell(new Label(3, 0, "ȱ��ʱ��"));
				sheet.addCell(new Label(4, 0, "�Ӱ�ʱ��"));
				sheet.addCell(new Label(5, 0, "�����ܼ�"));
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
			// label.setString("�����ܼ�");
			// }
			// Ϊ��Ԫ������ʱ��+ʱ���ʽ
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
