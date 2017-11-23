package test;

public class SetStudent implements Runnable {
	
	private Student s;
	
	StringBuffer sb = new StringBuffer();

	@Override
	public void run() {
		Student st = new Student();
		st.setAge(10);
		st.setName("tttt");
	}
	
	public synchronized void setInfo(){
		s.setAge(10);
		s.setName("tttt");
	}

}
