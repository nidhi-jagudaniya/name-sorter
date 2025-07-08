package service.impl;

import java.io.IOException;
import java.util.List;
import service.IWriter;

public class ConsoleWriter implements IWriter<List<String>> {

    /**
     * @param input
     * @throws IOException
     */
    @Override
    public void write(List<String> input) {
        for (String line : input) {
            System.out.println(line);
        }
    }
}
