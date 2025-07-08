import static constants.NameSortConstants.OUTPUT_FILE_PATH;

import constants.NameSortConstants;
import java.io.IOException;
import service.impl.ConsoleWriter;
import service.impl.TextFileReader;
import service.impl.PersonNameSorter;
import service.impl.TextFileWriter;


public class Main {

    /**
     * Starting point of Name Sort Application.
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(NameSortConstants.EMPTY_FILEPATH_ERROR_MSG);
            return;
        }
        String inputFilePath = args[0];
        NameSorterApp nameSorterApp = new NameSorterApp(new TextFileReader(inputFilePath), new PersonNameSorter(),
            new TextFileWriter(OUTPUT_FILE_PATH), new ConsoleWriter());
        try {
            nameSorterApp.run();
        } catch (IOException e) {
            System.err.println(NameSortConstants.IOEXCEPTION_PREFIX + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(NameSortConstants.ERROR_PREFIX + e.getMessage());
            e.printStackTrace();
        }
    }
}
