package carpark;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class InputParserTest {

	private InputParser inputParser = new InputParser();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test
	public void parseInvalidTextInput() throws Exception {
		inputParser.parseTextInput("someText");
		assertEquals("Invalid input", outContent.toString().trim());
	}

	@Test
	public void parseTextInputForStatus() throws Exception {
		inputParser.parseTextInput("status");
		assertEquals("Sorry, parking lot is not created", outContent.toString().trim());
	}

	@Test
	public void parseTextInputForCarSlot() throws Exception {
		inputParser.parseTextInput("leave 4");
		assertEquals("Sorry, parking lot is not created", outContent.toString().trim());
	}

	@Test
	public void parseTextInputForCarPark() throws Exception {
		inputParser.parseTextInput("park KA-01-P-333 White");
		assertEquals("Sorry, parking lot is not created", outContent.toString().trim());
	}

}