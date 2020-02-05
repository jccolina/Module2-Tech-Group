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
        String result = "[";
        result = this.toString(this.root, result);
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    private String toString(Node current, String previousResult) {
        String result;
        if (current == null) {
            return previousResult;
        }
        result = this.toString(current.getLeft(), previousResult);
        result = result.concat(current.getValue() + ",");
        result = this.toString(current.getRight(), result);
        return result;
    }
//    public String toString() {
//        StringBuilder builder = new StringBuilder("[");
//
//        visit(root, builder);
//
//        builder.append("]");
//        return builder.toString();
//    }
//
//    private void visit(Node cursor, StringBuilder builder) {
//        if (cursor == null) return;
//
//        visit(cursor.getLeft(), builder);
//        builder.append(cursor.getValue());
//        visit(cursor.getRight(), builder);
//    }

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

    public boolean remove(int value) {
        boolean result = false;
        result = remove(this.root, null, value);
        return result;
    }

    private boolean remove(Node cursor, Node parent, int value) {
        if (cursor == null) {
            return false;
        }
        boolean result = false;
        if (cursor.getValue() == value) {
            if (cursor.getRight() != null && cursor.getLeft() != null) {
                int minRight = this.minRight(cursor.getRight());
                cursor.setValue(minRight);
                remove(cursor.getRight(), cursor, minRight);

            } else if (cursor.getRight() != null) {
                if (cursor.getValue() < parent.getValue()) {
                    parent.setLeft(cursor.getRight());
                } else {
                    parent.setRight(cursor.getRight());
                }
            } else if (cursor.getLeft() != null) {
                if (cursor.getValue() < parent.getValue()) {
                    parent.setLeft(cursor.getLeft());
                } else {
                    parent.setRight(cursor.getLeft());
                }
            } else {
                if (cursor.getValue() < parent.getValue()) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }
            }
            result = true;
        } else if (value < cursor.getValue()) {
            result = remove(cursor.getLeft(), cursor, value);
        } else {
            result = remove(cursor.getRight(), cursor, value);
        }
        return result;
    }

    private int minRight(Node cursor) {
        int minValue =0;
        while(cursor != null){
            minValue = cursor.getValue();
            cursor = cursor.getLeft();
        }
        return minValue;
    }
}
