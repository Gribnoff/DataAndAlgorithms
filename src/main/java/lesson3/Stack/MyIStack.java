package lesson3.Stack;

import general.MyCollection;

public interface MyIStack<T> extends MyCollection {
    boolean push(T elem);

    T pop();

    T peek();
}
