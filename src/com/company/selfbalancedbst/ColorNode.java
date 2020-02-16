package com.company.selfbalancedbst;

public class ColorNode {
    enum Color{
        RED,
        BLACK
    }
    private int value;
    private Color color;
    private ColorNode left;
    private ColorNode right;
    private ColorNode parent;

    public ColorNode(int value) {
        this.value = value;
        this.color = Color.RED;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ColorNode getLeft() {
        return left;
    }

    public void setLeft(ColorNode left) {
        this.left = left;
    }

    public ColorNode getRight() {
        return right;
    }

    public void setRight(ColorNode right) {
        this.right = right;
    }

    public ColorNode getParent() {
        return parent;
    }

    public void setParent(ColorNode parent) {
        this.parent = parent;
    }
}
