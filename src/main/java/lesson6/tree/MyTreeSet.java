package lesson6.tree;

import java.util.Stack;

public class MyTreeSet<T extends Comparable<? super T>> implements MyTree<T> {
    private Node<T> root;
    private int size;

    @Override
    public boolean find(T elem) {
        return doFind(elem).node != null;
    }

    private NodeAndParent doFind(T elem) {
        Node<T> parent = null;
        Node<T> current = root;

        while (current != null) {
            if (current.getValue().equals(elem))
                return new NodeAndParent(current, parent);

            parent = current;

            if (current.shouldBeLeft(elem))
                current = current.getLeft();
            else
                current = current.getRight();
        }

        return new NodeAndParent(null, parent);
    }

    @Override
    public boolean add(T elem) {
        Node<T> node = new Node<>(elem);

        if (root == null) {
            root = node;
            return true;
        }

        NodeAndParent nodeAndParent = doFind(elem);
        if (nodeAndParent.node != null)
            return false;

        Node<T> previous = nodeAndParent.parent;
        if (previous.shouldBeLeft(elem))
            previous.setLeft(node);
        else
            previous.setRight(node);

        size++;
        return true;
    }

    @Override
    public boolean remove(T elem) {
        NodeAndParent nodeAndParent = doFind(elem);
        Node<T> removed = nodeAndParent.node;
        Node<T> parent = nodeAndParent.parent;

        if (removed == null)
            return false;

        if (removed.isLeaf())
            removeLeafNode(removed, parent);
        else if (removed.hasSingleChild())
            removeNodeWithSingleChild(removed, parent);
        else
            removeCommonNode(removed, parent);

        size--;
        return true;
    }

    private void removeLeafNode(Node<T> removed, Node<T> parent) {
        if (removed == root)
            root = null;
        else if (removed == parent.getLeft())
            parent.setLeft(null);
        else
            parent.setRight(null);
    }

    private void removeNodeWithSingleChild(Node<T> removed, Node<T> parent) {
        Node<T> child = removed.getLeft() != null
                ? removed.getLeft()
                : removed.getRight();

        if (removed == root)
            root = child;
        else if (removed == parent.getLeft())
            parent.setLeft(child);
        else
            parent.setRight(child);
    }

    private void removeCommonNode(Node<T> removed, Node<T> parent) {
        Node<T> successor = getSuccessor(removed);

        if (removed == root)
            root = successor;
        else if (removed == parent.getLeft())
            parent.setLeft(successor);
        else
            parent.setRight(successor);

        successor.setLeft(removed.getLeft());
    }

    private Node<T> getSuccessor(Node<T> removed) {
        Node<T> successor = removed;
        Node<T> successorParent = null;
        Node<T> current = removed.getRight();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != removed.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(removed.getRight());
        }

        return successor;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeft());
                    localStack.push(tempNode.getRight());
                    if (tempNode.getLeft() != null || tempNode.getRight() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return false;
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
        }
    }

    private void inOrder(Node<T> node) {
        if (node == null)
            return;

        inOrder(node.getLeft());
        System.out.println(node.getValue());
        inOrder(node.getRight());
    }

    private void preOrder(Node<T> node) {
        if (node == null)
            return;

        System.out.println(node.getValue());
        inOrder(node.getLeft());
        inOrder(node.getRight());
    }

    private void postOrder(Node<T> node) {
        if (node == null)
            return;

        inOrder(node.getLeft());
        inOrder(node.getRight());
        System.out.println(node.getValue());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private class NodeAndParent {
        Node<T> node;
        Node<T> parent;

        NodeAndParent(Node<T> node, Node<T> parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
