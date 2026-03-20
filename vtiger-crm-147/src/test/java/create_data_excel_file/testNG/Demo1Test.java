package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1Test {
   //public static void main(String[] args) {
  // }
   @Test
   public void case1() {
	   //System.out.println("This should be the start...");
	   Reporter.log("It will show in report...",true);
   }
   
}
