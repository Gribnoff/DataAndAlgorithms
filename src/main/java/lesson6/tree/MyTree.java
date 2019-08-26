package lesson6.tree;

import general.MyCollection;

@SuppressWarnings("UnusedReturnValue")
public interface MyTree<T> extends MyCollection {

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    boolean find(T value);

    boolean add(T value);

    boolean remove(T value);

    void display();

    boolean isBalanced();

    void traverse(TraverseMode mode);

}
