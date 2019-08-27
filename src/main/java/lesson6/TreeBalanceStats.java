package lesson6;

import lesson6.tree.MyTree;
import lesson6.tree.MyTreeSet;

public class TreeBalanceStats {
    private static final int MAX_DEPTH = 4;
    private static final int MAX_NUMBER = 20;
    private static final int MIN_NUMBER = -MAX_NUMBER;
    private static final int NUMBER_OF_TREES = 1000;

    public static void main(String[] args) {
        MyTree[] trees = new MyTreeSet[NUMBER_OF_TREES];
        int counter = 0;

        for (int i = 0; i < trees.length; i++) {
            if (createTreeSet(MAX_DEPTH, MAX_NUMBER).isBalanced())
                counter++;
        }

        System.out.printf("Balanced trees: %s of %s(%s%%)", counter, NUMBER_OF_TREES, 100 * counter / NUMBER_OF_TREES);
    }

    private static MyTree<Integer> createTreeSet(int maxDepth, int maxNumber) {
        MyTree<Integer> tree = new MyTreeSet<>();

        int maxNodes = (int) Math.pow(2, maxDepth) - 1;

        for (int i = 0; i < maxNodes; i++) {
            int num = (int)(Math.random() * 2 * maxNumber) - maxNumber;
            tree.add(num);
            if (tree.depth() == maxDepth)
                tree.remove(num);
        }

        return tree;
    }
}
