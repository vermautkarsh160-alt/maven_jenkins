package testNG;

import org.testng.annotations.Test;

public class HelperAttributePriorityTest {
    //why do we go for priority?
	/* To change the order of execution
	 * sense-less /logic-less flow
	 */
	@Test(priority = -1)
	public void createCity() {
		System.out.println("Create Okla");
	}
	@Test(priority = 0)
	public void modifyCity() {
		System.out.println("modify to noida");
	}
	@Test(priority = 1)
	public void deleteCity() {
		System.out.println("Noida delete");
	}
}
