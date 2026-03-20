package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
 * Why do we go for dependsOnMethods
 * Whenever we want to create dependency between 2 test cases
 * -> We should never ever create dependency between test cases
 */

 class HelperAttributeDependsOnMethodTest {
    	    @Test
    		public void createCity() {
    			System.out.println("Create Okla");
    			Assert.assertTrue(false);
    		}
    		@Test(dependsOnMethods = "createCity")
    		public void modifyCity() {
    			System.out.println("modify to noida");
    		}
    		@Test(dependsOnMethods = "modifyCity")
    		public void deleteCity() {
    			System.out.println("Noida delete");
    		}
     }

