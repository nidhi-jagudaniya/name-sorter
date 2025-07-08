package service.impl;

import constants.NameSortConstants;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.IWriter;

/**
 * Class responsible for writing to text file.
 */
public class TextFileWriter implements IWriter<List<String>> {

    private final String filePath;

    public TextFileWriter(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Write to file.
     *
     * @param input
     * @throws IOException
     */
    @Override
    public void write(List<String> input) throws IOException {
        // Using try-with-resource to auto-close resource after writing. No need to explicitly call writer.close()
        try (FileWriter writer = new FileWriter(this.filePath)) {
            for (String line : input) {
                writer.write(line + NameSortConstants.LINE_SEPARATOR);
            }
        }
    }
}
