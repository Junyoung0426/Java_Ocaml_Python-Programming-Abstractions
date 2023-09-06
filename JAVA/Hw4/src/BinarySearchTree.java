
import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> extends Thread implements Iterable {
    class TreeNode<T> {
        T value;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private TreeNode<T> root;
    private String name;

    public void add(T value) {
        root = add_rec(root, value);
    }

    private TreeNode<T> add_rec(TreeNode<T> root, T value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        int compare = value.compareTo(root.value);
        if (compare < 0)
            root.left = add_rec(root.left, value);
        else if (compare > 0)
            root.right = add_rec(root.right, value);
        return root;
    }

    public void addAll(List<T> values) {
        for (T val : values)
            add(val);
    }

    public BinarySearchTree(String name) {
        this.name = name;

    }

    private String preorder_print(TreeNode root) {
        String nodes = "";
        if (root == null) {
            return "";
        }
        nodes += root.value.toString();
        if (root.left != null) {
            nodes += " L: (" + preorder_print(root.left) + ")";
        }
        if ((root.right != null)) {
            nodes += " R: (" + preorder_print(root.right) + ")";
        }
        return nodes;
    }

    @Override
    public String toString() {
        return "[" + this.name + "] " + preorder_print(root);
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<T>(root);
    }

    private class TreeIterator<T> implements Iterator<T> {
        private List<TreeNode<T>> nodes = new LinkedList();
        private int current;

        public TreeIterator(TreeNode<T> node) {
            inOrder(node, nodes);
            current = 0;
        }

        private void inOrder(TreeNode<T> node, List<TreeNode<T>> nodes) {
            if (node == null)
                return;
            inOrder(node.left, nodes);
            nodes.add(node);
            inOrder(node.right, nodes);
        }

        @Override
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        @Override
        public T next() {
            if (current >= nodes.size())
                throw new NoSuchElementException();
            TreeNode<T> tree = nodes.remove(current);
            return tree.value;
        }
    }

    public static class TreeThread<T extends Comparable<T>> extends Thread {
        private BinarySearchTree<T> tree;
        private BinarySearchTree<T> merge;

        public TreeThread(BinarySearchTree<T> tree, BinarySearchTree<T> merge) {
            this.tree = tree;
            this.merge = merge;
        }
        @Override
        public void run() {
            this.tree.forEach(node -> merge.add((T) node));
        }
    }

    public static <T extends Comparable<T>> List<T> merge(BinarySearchTree<T> t1, BinarySearchTree<T> t2) {
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<T> result = new ArrayList<>();
        BinarySearchTree<T> final_tree = new BinarySearchTree<>("Merged Tree");
        threads.add(new Thread(new TreeThread<>(t1, final_tree)));
        threads.add(new Thread(new TreeThread<>(t2, final_tree)));
        threads.forEach(thread -> thread.start());
        try {
            threads.get(threads.size() - 1).join();
        } catch (InterruptedException e) {
        }
        final_tree.forEach(value -> result.add((T) value));
        return result;
    }

    public static void main(String... args) {
        // each tree has a name, provided to its constructor
        BinarySearchTree<Integer> t1 = new BinarySearchTree<>("Oak");

        // adds the elements to t1 in the order 5, 3, 0, and then 9
        t1.addAll(Arrays.asList(5, 3, 0, 9));
        BinarySearchTree<Integer> t2 = new BinarySearchTree<>("Maple");

        // adds the elements to t2 in the order 9, 5, and then 10
        t2.addAll(Arrays.asList(9, 5, 10));

        System.out.println(t1); // see the expected output for exact format
        t1.forEach(System.out::println); // iteration in increasing order

        System.out.println(t2); // see the expected output for exact format
        t2.forEach(System.out::println); // iteration in increasing order

        BinarySearchTree<String> t3 = new BinarySearchTree<>("Cornucopia");
        t3.addAll(Arrays.asList("coconut", "apple", "banana", "plum", "durian", "no durians on this tree!", "tamarind"));

        System.out.println(t3); // see the expected output for exact format
        t3.forEach(System.out::println);
        // iteration in increasing order
        List<Integer> t4 = merge(t1, t2);
        System.out.println(t4);
    }

}