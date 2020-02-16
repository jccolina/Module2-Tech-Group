package com.company.selfbalancedbst;

import com.company.selfbalancedbst.ColorNode.Color;

public class RedBlackBST {
    private ColorNode root;
    private int size;
    private static final ColorNode NULLT = new ColorNode(-1);

    public int getSize() {
        return size;
    }

    public boolean add(int value) {
        ColorNode newNode = new ColorNode(value);
        newNode.setLeft(NULLT);
        newNode.setRight(NULLT);
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
//        if (result) {
//            this.fixTree(newNode);
//        }
        return result;
    }

    public ColorNode leftRotate(ColorNode node) {
        ColorNode parent = node.getParent();
        ColorNode aux = node.getRight();
        aux.setParent(parent);
        node.setRight(aux.getLeft());
        aux.setLeft(node);
        node.setParent(aux);
        node.getRight().setParent(node);
        if (parent != null) {
            if (parent.getRight() == node)  {
                parent.setRight(aux);
            } else {
                parent.setLeft(aux);
            }
        } else {
            root = aux;
        }
        return aux;
    }

    public ColorNode rightRotate(ColorNode node) {
        return null;
    }

    private void fixTree(ColorNode node) {

        root.setColor(Color.BLACK);
    }

    private boolean add(ColorNode cursor, ColorNode newNode) {
        boolean result = false;
        if (newNode.getValue() > cursor.getValue()) {
            if (cursor.getRight() == NULLT) {
                newNode.setParent(cursor);
                cursor.setRight(newNode);
                result = true;
            } else {
                return add(cursor.getRight(), newNode);
            }
        } else if (newNode.getValue() < cursor.getValue()) {
            if (cursor.getLeft() == NULLT) {
                newNode.setParent(cursor);
                cursor.setLeft(newNode);
                result = true;
            } else {
                return add(cursor.getLeft(), newNode);
            }
        }
        return result;
    }

    public ColorNode getRoot(){
        return this.root;
    }
    public int size(){
        return this.size;
    }
}
