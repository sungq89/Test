package test;

import org.junit.Test;
import org.junit.experimental.theories.Theories;

public class TestStudent {
	
	public static void main(String[] args) {
		SetStudent st = new SetStudent();
		GetStudent get = new GetStudent();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(get);
		
		t1.start();
		t2.start();
		
	}
//	@Test
//	public void test(){
//		SetStudent st = new SetStudent();
//		GetStudent get = new GetStudent();
//		
//		Thread t1 = new Thread(st);
//		Thread t2 = new Thread(get);
//		
//		t1.start();
//		t2.start();
//	}

}
