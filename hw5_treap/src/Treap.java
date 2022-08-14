import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {
    private static class Node<E> {
        //data fields
        public E data;
        public int priority;
        public Node<E> left;
        public Node<E> right;

        //constructors
        public Node(E data, int priority) {
            if (data == null) {
                throw new NullPointerException("data is null");
            } else {
                this.data = data;
                this.priority = priority;
                this.left = null;
                this.right = null;
            }
           
        }

        //methods 
        Node<E> rotateRight() {
            Node<E> temp = this.left;
            Node<E> temp2 = this.left.right;

            //rotate
            temp.right = this;
            this.left = temp2;

            // new root
            return temp;
        }

        //same thing but switched
        Node<E> rotateLeft() {
            Node<E> temp = this.right;
            Node<E> temp2 = this.right.left;
            temp.left = this;
            this.right = temp2;
            return temp;
        }
    }
    //data fields
    private Random priorityGenerator;
    private Node<E> root;

    //constructor non-parameterized
    public Treap() {
        this.priorityGenerator = new Random();
        this.root = null;
    }
    //constructor parameterized
    public Treap(long seed) {
        this.priorityGenerator = new Random(seed);
        this.root = null;
    }

    //helper method for add
    private void reheap (Node<E> curr, Stack<Node<E>> path) {
        while (!path.isEmpty()) {
            Node<E> parent = path.pop();
            if (parent.priority < curr.priority) {
                if (parent.data.compareTo(curr.data) > 0) {
                    curr = parent.rotateRight();
                } else {
                    curr = parent.rotateLeft();
                }
                if (!path.isEmpty()) {
                    if (path.peek().left == parent) {
                        path.peek().left = curr;
                    } else {
                        path.peek().right = curr;
                    }
                } else {
                    this.root = curr;
                }
            } else {
                break;
            }
        }
    }

    // add methods
    boolean add(E key) {
        return add(key, this.priorityGenerator.nextInt());
    }

    boolean add(E key, int priority) {
        if (this.root == null) {
            this.root = new Node<E>(key, priority);
            return true;
        } else {
            Node<E> temp = new Node<E>(key, priority);
            Stack<Node<E>> stack = new Stack<Node<E>>();
            Node<E> current = root;

            while (current != null) {
                int comp = current.data.compareTo(key);
                if (comp == 0) {
                    return false;
                } else {
                    if (comp < 0) {
                        stack.push(current);
                        if (current.right == null) {
                            current.right = temp;
                            reheap(temp, stack);
                            return true;
                        } else {
                            current = current.right;
                        }

                    } else {
                        stack.push(current);
                        if (current.left == null) {
                            current.left = temp;
                            reheap(temp, stack);
                            return true;
                        } else {
                            current = current.left;
                        }
                    }
                } 
            }
            return false;
        }
    }

    //delete methods
    private Node<E> delete(E key, Node<E> node) {
        if (node == null) {
            return node;
        } else {
            if (node.data.compareTo(key)< 0) {
                node.right = delete(key, node.right);
            } else {
                if (node.data.compareTo(key)>0) {
                    node.left = delete(key, node.left);
                } else {
                    if (node.right == null) {
                        node = node.left;
                    } else if (node.left == null) {
                        node = node.right;
                    } else {
                        if (node.right.priority < node.left.priority) {
                            node = node.rotateRight();
                            node.right = delete(key, node.right);
                        } else {
                            node = node.rotateLeft();
                            node.left = delete(key, node.left);
                        }
                    }
                }
            }
        }
        return node;
    }

    public boolean delete(E key) {
        if (root == null || find(key) == false) {
            return false;
        } else {
            root = delete(key, root);
            return true;
        }      
    }

    //find methods
    private boolean find(Node <E> root, E key) {
        if (root == null) {
            return false;
        } else {
            int comp = root.data.compareTo(key);
            if (comp == 0) {
                return true;
            } else {
                return find(root.right, key) || find(root.left, key);
            }
        }
    }
    
    public boolean find(E key) {
      return find(root, key);
    }

    
    //toString method for building the tree
    private String toString(Node<E> node, int depth) {
        StringBuilder string = new StringBuilder();
        for (int i= 0; i < depth; i++) {
            string.append("||");
        }
        if (node == null) {
            string.append("null");
        } else {
            string.append("(key = " + node.data + ", priority = " + node.priority + ")");
            string.append("\n");
            string.append(toString(node.left, depth + 1));
            string.append("\n");
            string.append(toString(node.right, depth+1));
        }
        return string.toString();
    }

    public String toString() {
        return toString(root, 0);
    }


    public static void main(String[] args) throws Exception {
        Treap<Integer> testTree = new Treap<Integer>();

        //insertion
        testTree.add(4,19);
        testTree.add(2,31);
        testTree.add(6,70);
        testTree.add(1,84);
        testTree.add(3,12);
        testTree.add(5,83);
        testTree.add(7,26);

        //delete
        System.out.println("deleted: " + testTree.delete(5));
        System.out.println(testTree.toString());

    }
}
