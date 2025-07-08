package service;

/**
 * Interface to implement sort.
 * @param <T> Type of Collection to sort.
 */
public interface ISorter<T> {
    T sort(T input);
}
