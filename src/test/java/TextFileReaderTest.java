import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.TextFileReader;

/**
 * Test class for TextFileReader.
 */
public class TextFileReaderTest {

    private Path tempInputFilePath;
    private TextFileReader reader;

    @BeforeEach
    void setUp() throws IOException {
        tempInputFilePath = Files.createTempFile("test", ".txt");
        reader = new TextFileReader(tempInputFilePath.toString());
    }

    @Test
    void testReadValidFile_ReturnsNonEmptyList() throws IOException {
        List<String> sampleLines = List.of("Janet Parsons", "Adonis Julius Archer");
        Files.write(tempInputFilePath, sampleLines);

        List<String> result = reader.read();

        assertEquals(2, result.size());
    }

    @Test
    void testReadEmptyFile_ReturnsEmptyList() throws IOException {
        Files.write(tempInputFilePath, List.of());

        List<String> result = reader.read();

        assertTrue(result.isEmpty());
    }

    @Test
    void testReadFileNotFound_ThrowsIOException() {
        TextFileReader badReader = new TextFileReader("nonexistent_file.txt");

        assertThrows(IOException.class, badReader::read);
    }
}
