package com.company.bst;

public class BinarySearchTree {
    private Node root;
    private int level;
    private int size;


    public boolean add(int value) {
        Node newNode = new Node(value);
        boolean result;
        if (root == null) {
            root = newNode;
            this.size++;
            result = true;
        } else {
            result = add(root, newNode);
            if (result) {
                this.size++;
            }
        }
        return result;
    }

    private boolean add(Node cursor, Node newNode) {
        boolean result = false;
        if (newNode.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                cursor.setRight(newNode);
                result = true;
            } else {
                return add(cursor.getRight(), newNode);
            }
        } else if (newNode.getValue() < cursor.getValue()) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                result = true;
            } else {
                return add(cursor.getLeft(), newNode);
            }
        }
        return result;
    }

    public int getLevel() {
        return level;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        visit(root, builder);

        builder.append("]");
        return builder.toString();
    }

    private void visit(Node cursor, StringBuilder builder) {
        if (cursor == null) return;

        visit(cursor.getLeft(), builder);
        builder.append(cursor.getValue());
        visit(cursor.getRight(), builder);
    }

    public boolean remove(int value) {
        return remove(root, null, value);
    }

    private boolean remove(Node cursor, Node parent, int value) {
        if (cursor == null) {
            return false;
        }

        if (cursor.getValue() == value) {
            if (cursor.getRight() != null && cursor.getLeft() != null) {
                int minRight = getMinRight(cursor.getRight());
                cursor.setValue(minRight);
                return remove(cursor.getRight(), cursor, minRight);
            } else if (parent.getRight() == cursor) {
                parent.setRight(cursor.getRight() != null ? cursor.getRight() : cursor.getLeft());
            } else {
                parent.setLeft(cursor.getRight() != null ? cursor.getRight() : cursor.getLeft());
            }
            return true;
        } else if (value > cursor.getValue()) {
            return remove(cursor.getRight(), cursor, value);
        } else {
            return remove(cursor.getLeft(), cursor, value);
        }
    }

    private int getMinRight(Node cursor) {
        int minor = cursor.getValue();
        while(cursor != null) {
            minor = cursor.getValue();
            cursor = cursor.getLeft();
        }
        return minor;
    }
}
