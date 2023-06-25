package guru.springframework.sfgpetclinic.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import guru.springframework.sfgpetclinic.ModelTests;

class OwnerTest implements ModelTests{

	@Test
	void dependentAssertions() {

		Owner owner = new Owner(1l, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("666666666");
		
		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("Joe", owner.getFirstName(), "First Name Did not Match"),
						() -> assertEquals("Buck", owner.getLastName(), "Last Name Did not Match")),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City Did not Match"),
						() -> assertEquals("666666666", owner.getTelephone(), "Telephone Did not Match"))				
		);
		
		assertThat(owner.getCity(), is("Key West"));
	}
	
	@DisplayName("Value Source Test")
	@ParameterizedTest(name = "{displayName} - {index} {arguments}")
	@ValueSource(strings = {"Spring", "Framework" ,"Guru"})
	void parameterizedTest(String val) {
		System.out.println(val);
	}
	
	@DisplayName("Enum Source Test")
	@ParameterizedTest(name = "{displayName} - {index} {arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}
	
	@DisplayName("CSV Input Test")
	@ParameterizedTest(name = "{displayName} - {index} {arguments}")
	@CsvSource({
		"FL, 1, 1",
		"OH, 2, 2",
		"MI, 3, 3"
	})
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + ":" + val2);
	}

}

