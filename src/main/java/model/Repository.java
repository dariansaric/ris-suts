package model;

public interface Repository<T> {
    T convertToEntity();

    void convertToEntity(T o);
}
