package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;

public class PersonRepeatedTest implements ModelRepeatedTests{
	
	@RepeatedTest(value = 10, name = "{displayName}:{currentRepetition} - {totalRepetitions}")
	@DisplayName("My Repeated Test")	
	void repeatedTest(){
		
	}
	
	@RepeatedTest(value = 5, name = "{displayName}:{currentRepetition} - {totalRepetitions}")
	@DisplayName("My Repeated Test WDI")	
	void repeatedTestWithoutDI(TestInfo testInfo, RepetitionInfo repetitionInfo){
		System.out.println(testInfo.getDisplayName() + " " + repetitionInfo.getTotalRepetitions());
	}
	
	@RepeatedTest(value = 5, name = "{displayName}:{currentRepetition} - {totalRepetitions}")
	@DisplayName("My Assigment Repeated Test")	
	void myAssigmentRepeated() {
		//TODO impl
	}
}
