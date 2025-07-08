import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.impl.ConsoleWriter;
import service.impl.PersonNameSorter;
import service.impl.TextFileReader;
import service.impl.TextFileWriter;


/**
 * Test class for NameSorterApp.
 */
public class NameSorterAppTest {

    private TextFileReader mockReader;
    private PersonNameSorter mockSorter;
    private TextFileWriter mockFileWriter;
    private ConsoleWriter mockConsoleWriter;
    private NameSorterApp app;

    @BeforeEach
    void setUp() {
        mockReader = mock(TextFileReader.class);
        mockSorter = mock(PersonNameSorter.class);
        mockFileWriter = mock(TextFileWriter.class);
        mockConsoleWriter = mock(ConsoleWriter.class);
        app = new NameSorterApp(mockReader, mockSorter, mockFileWriter, mockConsoleWriter);
    }

    @Test
    void testRun_ExecutesSuccessfully() throws IOException {
        List<String> unsorted = Arrays.asList("John Smith", "Anna Bell");
        List<String> sorted = Arrays.asList("Anna Bell", "John Smith");

        when(mockReader.read()).thenReturn(unsorted);
        when(mockSorter.sort(unsorted)).thenReturn(sorted);

        app.run();

        verify(mockReader).read();
        verify(mockSorter).sort(unsorted);
        verify(mockConsoleWriter).write(sorted);
        verify(mockFileWriter).write(sorted);
    }

    @Test
    void testRun_ThrowsIOExceptionFromReader() throws IOException {
        when(mockReader.read()).thenThrow(new IOException("File not found"));

        IOException thrown = assertThrows(IOException.class, () -> app.run());
        assertEquals("File not found", thrown.getMessage());
    }
}