package service;

import java.io.IOException;

/**
 * Interface to implement read.
 * @param <T> Type of output required.
 */
public interface IReader<T> {
    T read() throws IOException;
}
