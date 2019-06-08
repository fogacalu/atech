package atechpckg;

public class StartTest {
	 public static void main(String[] args){
		FunctionalTest.setUp();
		ValidCitiesTest VIT = new ValidCitiesTest();
		VIT.validCitiesTest();
//		FunctionalTest.cleanUp();
		FunctionalTest.tearDown();
	}
}
