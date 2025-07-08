import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.ConsoleWriter;

/**
 * Test class for ConsoleWriter.
 */
public class ConsoleWriterTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutputstream = System.out;
    private ConsoleWriter consoleWriter;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        consoleWriter = new ConsoleWriter();
    }

    @Test
    void testWrite_PrintsEachLine() {
        List<String> input = List.of("Marin Alvarez", "London Lindsey", "Beau Tristan Bentley");

        consoleWriter.write(input);

        String expectedOutput = String.join(System.lineSeparator(), input) + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }
}
