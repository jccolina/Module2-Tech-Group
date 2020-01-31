package com.company;

public class BinarySearchTree {
    private Node root;
    private int level;
    private int size;
    private static final int INITIAL_LEVEL = 0;


    public boolean add(int value) {
        Node newNode = new Node(value);
        boolean result;
        if (root == null) {
            root = newNode;
            this.size++;
            result = true;
        } else {
            result = add(root, newNode, INITIAL_LEVEL);
            if (result) {
                this.size++;
            }
        }
        return result;
    }

    private boolean add(Node cursor, Node newNode, int currentLevel) {
        currentLevel++;
        boolean result = false;
        if (newNode.getValue() > cursor.getValue()) {
            if (cursor.getRight() == null) {
                cursor.setRight(newNode);
                result = true;
                if (currentLevel > this.level) {
                    this.level = currentLevel;
                }
            } else {
                return add(cursor.getRight(), newNode, currentLevel);
            }
        } else if (newNode.getValue() < cursor.getValue()) {
            if (cursor.getLeft() == null) {
                cursor.setLeft(newNode);
                result = true;
                if (currentLevel > this.level) {
                    this.level = currentLevel;
                }
            } else {
                return add(cursor.getLeft(), newNode, currentLevel);
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

    public boolean contains(int value) {
        if (this.root == null) {
            return false;
        }
        return contains(this.root, value);
    }

    private boolean contains(Node current, int value) {
        boolean result = false;
        if (current != null) {
            if (current.getValue() == value) {
                result = true;
            } else if (current.getValue() > value) {
                result = contains(current.getLeft(), value);
            } else {
                result = contains(current.getRight(), value);
            }
        }
        return result;
    }
}
