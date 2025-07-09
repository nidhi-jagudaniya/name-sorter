import static constants.NameSortConstants.FILE_WRITE_SUCCESS_MSG;
import static constants.NameSortConstants.OUTPUT_FILE_PATH;

import java.io.IOException;
import java.util.List;
import service.IReader;
import service.ISorter;
import service.IWriter;
import service.impl.ConsoleWriter;
import service.impl.PersonNameSorter;
import service.impl.TextFileReader;
import service.impl.TextFileWriter;

/**
 * Main class that executes all logic to process file of unsorted name.
 */
public class NameSorterApp {

    private final IReader<List<String>> reader;
    private final ISorter<List<String>> sorter;
    private final IWriter<List<String>> fileWriter;
    private final IWriter<List<String>> consoleWriter;

    public NameSorterApp(IReader<List<String>> reader, ISorter<List<String>> sorter, IWriter<List<String>> fileWriter,
        IWriter<List<String>> consoleWriter) {
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