package service;

import java.io.IOException;

/**
 * Interface to implement write.
 * @param <T> Type of input to write.
 */
public interface IWriter<T> {
    void write(T input) throws IOException;
}
