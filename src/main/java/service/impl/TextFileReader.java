package service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import service.IReader;


/**
 * Class responsible for reading text file.
 */
public class TextFileReader implements IReader<List<String>> {

    private final String filePath;

    public TextFileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Read from file and return list.
     *
     * @return List of lines read from the file.
     * @throws IOException
     */
    @Override
    public List<String> read() throws IOException {
        List<String> lines = new ArrayList<>();
        // Using try-with-resource to auto-close resource after reading. No need to explicitly call bufferedReader.close()
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        }
        return lines;
    }
}
