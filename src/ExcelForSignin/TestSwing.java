package ExcelForSignin;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TestSwing extends JFrame {
	
	private int counter = 0;
	
	public TestSwing(){
		 /* ʹ�����������һ�����ڼ����� */
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println(
                    "Exit when Closed event");
                //�˳�Ӧ�ó���
                System.exit(0);
            }

            public void windowActivated(WindowEvent e) {
                // �ı䴰�ڱ���
                setTitle("Test Frame " + counter++);
            }
        });
        

        // ���ô���Ϊ�̶���С
        setResizable(false);
        setSize(200, 150);
	}

	public static void main(String[] args) {
		TestSwing ts = new TestSwing();
		ts.show();
//		ts.show(true);
		
	}
	
	
	
	JFrame frame = new JFrame("test");
	
}
