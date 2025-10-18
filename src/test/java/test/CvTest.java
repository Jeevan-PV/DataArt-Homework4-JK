package test;

import model.CurriculumVitae;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CvTest {

	private CurriculumVitae myCv;
	private SoftAssertions softly;
	
	/**
     * TestNG @BeforeMethod: Build the CV model.
     */
	
	@BeforeMethod
	public void buildCv() {
		System.out.println("---@BeforeMethod : Building the CV Model");
		
		myCv = CurriculumVitae.builder()
				.name("Jeevan Kumar P V")
				.age(25)
				.address("Bengaluru - India")
				.email("jeevankpv2000@gmail.com")
				.build();
		
		softly = new SoftAssertions();
		System.out.println("CV Model Built Successfully");								
	}
	
	/**
     * TestNG @Test: Print the CV content in Beautified content
     */
	
	@Test
	public void printMyCv() {
		System.out.println("\n\n*********************************************");
		System.out.println("## Printing my Beautified CV ##");
		System.out.println("\n\n*********************************************");
		
		System.out.println(">> Console Outcome: " + myCv + "\n");
		
		System.out.println("-------------------------------------------------");
		System.out.println(">> NAME: \t\t" + myCv.getName());
		System.out.println(">> AGE: \t\t" + myCv.getAge());
		System.out.println(">> ADDRESS: \t\t" + myCv.getAddress());
		System.out.println(">> Email: \t\t" + myCv.getEmail());
		System.out.println("----------------------------------------------------\n");
	}
	
	/**
     * TestNG @AfterMethod: Assert that all required fields are present using AssertJ.
     */
	
     @AfterMethod
     public void validateCvFields() {
    	 System.out.println("\n---Validating all required fields with AssertJ ---");
    	 softly.assertThat(myCv.getName())
    	 .as("Name Field validation")
    	 .isNotNull()
    	 .isNotEmpty();
   
    	 
    	 softly.assertThat(myCv.getAddress())
    	 .as("address field validation")
    	 .isNotNull()
    	 .isNotEmpty();
    	 
    	 softly.assertThat(myCv.getEmail())
         .as("Email field validation")
         .isNotNull()
         .isNotEmpty()
         .contains("@");
    	 
    	 softly.assertThat(myCv.getAge())
         .as("Age field validation")
         .isPositive()	
         .isGreaterThan(18);
    	 
    	 assertThat(myCv)
         .as("CV Object validation")
         .isNotNull();
    	 
    	 System.out.println("All required fields validated successfully using AssertJ.");
    	 softly.assertAll();
     }

}
