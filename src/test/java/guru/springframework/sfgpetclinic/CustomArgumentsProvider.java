package guru.springframework.sfgpetclinic;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CustomArgumentsProvider implements ArgumentsProvider{

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
				Arguments.of("FL", 7, 77),
				Arguments.of("OH", 22, 81),
				Arguments.of("MI", 34, 55)
				);
	}

}
