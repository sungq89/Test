package test;

public class GetStudent implements Runnable {

	@Override
	public void run() {

		Student st = new Student();
		System.out.println(st.getAge()+"-------"+st.getName());
	}

}
