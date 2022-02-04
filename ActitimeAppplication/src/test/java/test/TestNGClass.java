package test;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite TestNGClass");
	}
	

    @BeforeTest
    public void beforeTest() {
	  System.out.println("BeforeTest TestNGClass");
    }

	@BeforeClass
	public void beofreClass() {
		System.out.println("beforeClass TestNGClass");
    }
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod TestNGClass");
	}
	
	@Test
    public void testA() {
		System.out.println("test A TestNGClass");
	}
	
	@Test
	public void testB() {
		System.out.println("test B TestNGClass");
		
	}
	

	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod TestNGClass");
	}
	
	@AfterClass
	public void agterclass() {
		System.out.println("afterclass TestNGClass");
	}
	
	 @AfterTest
	    public void afterTest() {
		  System.out.println("AfterTest TestNGClass");
	    }
	 @AfterSuite
	 public void afterSuite() {
		 System.out.println("AfterSuite TestNGClass");
	 }


}
