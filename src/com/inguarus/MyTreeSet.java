package com.inguarus;

public class MyTreeSet<T extends Comparable<T>> implements MySet<T> {

    private Node root;
    private int size;

    class Node<T> {
        private Node<T> left;
        private Node<T> right;
        private Node<T> parent;
        private T value;

        public Node(T value) {
            this.value = value;
        }
    }

    @Override
    public boolean add(T o) {
        if (root == null) {
            root = new Node(o);
        }
        Node<T> current = root;
        while (current != null) {
            int cmp = o.compareTo(current.value);
            if (cmp == 0) {
                return false;
            } else if (cmp < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new Node<>(o);
                    current.left.parent = current;
                    return true;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new Node<>(o);
                    current.right.parent = current;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public boolean contains(T o) {
        Node<T> current = root;
        while (current != null) {
            int cmp = o.compareTo(current.value);
            if (cmp == 0) {
                return true;
            }
            if (cmp < 0) {
                current = current.left;
            }
            if (cmp > 0) {
                current = current.right;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T o) {
        Node<T> current = root;
        while (current != null) {
            int cmp = current.value.compareTo(current.value);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                if (current.left == null && current.right == null) {
                    if (current.parent.left == current) {
                        current.parent.left = null;
                    } else {
                        current.parent.right = null;
                    }
                } else if (current.left != null) {
                    Node<T> maxLeft = current.left;
                    while (maxLeft.right != null) {
                        maxLeft = maxLeft.right;
                    }
                    current.value = maxLeft.value;
                    if (maxLeft.parent.right == maxLeft) {
                        if (maxLeft.left != null) {
                            maxLeft.parent.right = maxLeft.left;
                        } else {
                            maxLeft.parent.right = null;
                        }
                    } else {
                        Node<T> maxRight = current.right;
                        while (maxRight.left != null) {
                            maxRight = maxRight.left;
                        }
                        current.value = maxRight.value;
                        if (maxRight.parent.left == maxRight) {
                            if (maxRight.right != null) {
                                maxRight.parent.left = maxRight.right;
                            } else {
                                maxRight.parent.left = null;
                            }
                        } else {
                            maxRight.parent.right = maxRight.right;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        toString(root, result);
        result.append(" ]");

        return new String(result);
    }

    private void toString(Node<T> root, StringBuilder sb) {
        if (root != null) {
            toString(root.left, sb);
            sb.append(" ").append(root.value);
            toString(root.right, sb);
        }
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
}
