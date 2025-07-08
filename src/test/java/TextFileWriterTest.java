import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.TextFileWriter;


/**
 * Test class for TextFileWriter.
 */
public class TextFileWriterTest {

    private Path tempFile;
    private TextFileWriter writer;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = Files.createTempFile("test-output", ".txt");
        writer = new TextFileWriter(tempFile.toString());
    }

    @Test
    void testWrite_WritesAllLines() throws IOException {
        List<String> input = List.of("Marin Alvarez", "London Lindsey", "Beau Tristan Bentley");

        writer.write(input);

        List<String> result = Files.readAllLines(tempFile);
        assertEquals(input.size(), result.size());
    }

    @Test
    void testWrite_EmptyInput() throws IOException {
        writer.write(List.of());

        List<String> result = Files.readAllLines(tempFile);
        assertTrue(result.isEmpty());
    }
}