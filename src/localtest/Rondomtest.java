package localtest;

import java.util.Random;

import org.junit.Test;

public class Rondomtest {

//	@Test
	public static void main(String[] args) {
//	public void rodemTest(){	
		String firstType = "";
		int a = 0;
		Random career = new Random();
		a = career.nextInt(100);
		
		if(a < 33){
			firstType = "51";
		}if(a >= 33 && a < 66){
			firstType = "fs";
		}else{
			firstType = "dh";
		}
		System.out.print("-------------------"+"\n");
		System.out.println(firstType+"----"+a);
	}
	
	

}
