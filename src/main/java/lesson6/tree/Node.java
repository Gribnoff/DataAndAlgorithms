package lesson6.tree;

class Node<T extends Comparable<? super T>> {

    private final T elem;

    private Node<T> left;
    private Node<T> right;

    Node(T elem) {
        this.elem = elem;
    }

    T getValue() {
        return elem;
    }

    Node<T> getLeft() {
        return left;
    }

    void setLeft(Node<T> leftChild) {
        this.left = leftChild;
    }

    Node<T> getRight() {
        return right;
    }

    void setRight(Node<T> rightChild) {
        this.right = rightChild;
    }

    boolean shouldBeLeft(T elem) {
        return this.elem.compareTo(elem) > 0;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }

    boolean hasSingleChild() {
        return left != null ^ right != null;
    }
}
