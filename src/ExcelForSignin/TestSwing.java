package ExcelForSignin;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TestSwing extends JFrame {
	
	private int counter = 0;
	
	public TestSwing(){
		 /* 使用匿名类添加一个窗口监听器 */
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println(
                    "Exit when Closed event");
                //退出应用程序
                System.exit(0);
            }

            public void windowActivated(WindowEvent e) {
                // 改变窗口标题
                setTitle("Test Frame " + counter++);
            }
        });
        

        // 设置窗口为固定大小
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
