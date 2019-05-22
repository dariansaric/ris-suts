package service;

public interface Service<O, E> {
    O convertToObject(E e);
}
