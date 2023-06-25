package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelTests;

class PersonTest implements ModelTests{

	@Test
	void groupedAssertions() {
		//given
		Person person = new Person(1l, "Joe", "Buck");
		//then
		assertAll("Test Props Set",
				() -> assertEquals("Joe", person.getFirstName()),
				() -> assertEquals("Buck", person.getLastName())
				);
	}
	
	@Test
	void groupedAssertionsMsgs() {
		//given
		Person person = new Person(1l, "Joe", "Buck");
		//then
		assertAll("Test Props Set",
				() -> assertEquals("Joe", person.getFirstName(), "First Name Failed"),
				() -> assertEquals("Buck", person.getLastName(), "Last Name Failed")
				);
	}


}
