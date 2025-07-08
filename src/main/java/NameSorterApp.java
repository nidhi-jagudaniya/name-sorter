import static constants.NameSortConstants.FILE_WRITE_SUCCESS_MSG;
import static constants.NameSortConstants.OUTPUT_FILE_PATH;

import java.io.IOException;
import java.util.List;
import service.impl.ConsoleWriter;
import service.impl.PersonNameSorter;
import service.impl.TextFileReader;
import service.impl.TextFileWriter;

/**
 * Main class that executes all logic to process file of unsorted name.
 */
public class NameSorterApp {

    private final TextFileReader reader;
    private final PersonNameSorter sorter;
    private final TextFileWriter fileWriter;
    private final ConsoleWriter consoleWriter;

    public NameSorterApp(TextFileReader reader, PersonNameSorter sorter, TextFileWriter fileWriter, ConsoleWriter consoleWriter) {
        this.reader = reader;
        this.sorter = sorter;
        this.fileWriter = fileWriter;
        this.consoleWriter = consoleWriter;
    }

    /**
     * Main method to sort names, print and write it into file.
     *
     * @throws IOException
     */
    public void run() throws IOException {
        List<String> names = reader.read();
        List<String> sortedNames = sorter.sort(names);
        consoleWriter.write(sortedNames);
        fileWriter.write(sortedNames);
        System.out.println("\n" + FILE_WRITE_SUCCESS_MSG + OUTPUT_FILE_PATH);
    }
}