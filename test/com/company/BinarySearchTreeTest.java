package com.company;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.company.selfbalancedbst.ColorNode;
import com.company.selfbalancedbst.RedBlackBST;
import org.junit.Ignore;
import org.junit.Test;

public class BinarySearchTreeTest {
    @Test
    public void testAdd() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);


        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

//        assertEquals(3, myTree.getLevel());
        assertEquals(8, myTree.size());
    }

    @Test
    public void testToString() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(6);
        myTree.add(10);
        myTree.add(9);
        myTree.add(3);
        myTree.add(7);
        myTree.add(2);
        myTree.add(4);

        assertEquals("[234678910]", myTree.toString());
    }

    @Test
    @Ignore
    public void testLevel() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

        assertEquals(3, myTree.getLevel());
    }
    @Test
    public void testLeftRotate() {
        RedBlackBST myTree = new RedBlackBST();

        myTree.add(5);
        myTree.add(4);
        myTree.add(7);
        myTree.add(6);
        myTree.add(8);
        ColorNode root = myTree.getRoot();
        ColorNode newRoot = myTree.leftRotate(root);
        root = myTree.getRoot();
        ColorNode leftRoot = root.getLeft();
        ColorNode rightRoot = root.getRight();

        assertEquals(root, newRoot);
        assertEquals(7, root.getValue());
        assertEquals(8, rightRoot.getValue());
        assertEquals(-1, rightRoot.getRight().getValue());
        assertEquals(-1, rightRoot.getLeft().getValue());
        assertEquals(5, leftRoot.getValue());
        assertEquals(4, leftRoot.getLeft().getValue());
        assertEquals(6, leftRoot.getRight().getValue());
    }
    @Test
    public void testLeftRotateInRightLeaf() {
        RedBlackBST myTree = new RedBlackBST();

        myTree.add(2);
        myTree.add(1);
        myTree.add(5); //leaf to rotate
        myTree.add(4);
        myTree.add(7);
        myTree.add(6);
        myTree.add(8);
        ColorNode nodeToRotate = myTree.getRoot().getRight();
        ColorNode newRoot = myTree.leftRotate(nodeToRotate);
        ColorNode nodeRotated = myTree.getRoot().getRight();
        ColorNode leftRoot = nodeRotated.getLeft();
        ColorNode rightRoot = nodeRotated.getRight();

        assertEquals(nodeRotated, newRoot);
        assertEquals(7, nodeRotated.getValue());
        assertEquals(8, rightRoot.getValue());
        assertEquals(-1, rightRoot.getRight().getValue());
        assertEquals(-1, rightRoot.getLeft().getValue());
        assertEquals(5, leftRoot.getValue());
        assertEquals(4, leftRoot.getLeft().getValue());
        assertEquals(6, leftRoot.getRight().getValue());
    }
    @Test
    public void testLeftRotateInLeftLeaf() {
        RedBlackBST myTree = new RedBlackBST();

        myTree.add(10);
        myTree.add(12);
        myTree.add(5);
        myTree.add(4);
        myTree.add(7);
        myTree.add(6);
        myTree.add(8);
        ColorNode nodeToRotate = myTree.getRoot().getLeft();
        ColorNode newRoot = myTree.leftRotate(nodeToRotate);
        ColorNode nodeRotated = myTree.getRoot().getLeft();
        ColorNode leftRoot = nodeRotated.getLeft();
        ColorNode rightRoot = nodeRotated.getRight();

        assertEquals(nodeRotated, newRoot);
        assertEquals(7, nodeRotated.getValue());
        assertEquals(8, rightRoot.getValue());
        assertEquals(-1, rightRoot.getRight().getValue());
        assertEquals(-1, rightRoot.getLeft().getValue());
        assertEquals(5, leftRoot.getValue());
        assertEquals(4, leftRoot.getLeft().getValue());
        assertEquals(6, leftRoot.getRight().getValue());
    }
    @Test
    public void testRightRotate() {
        RedBlackBST myTree = new RedBlackBST();

        myTree.add(7);
        myTree.add(5);
        myTree.add(8);
        myTree.add(4);
        myTree.add(6);
        ColorNode root = myTree.getRoot();
        ColorNode newRoot = myTree.rightRotate(root);
        root = myTree.getRoot();
        ColorNode leftRoot = root.getLeft();
        ColorNode rightRoot = root.getRight();

        assertEquals(root, newRoot);
        assertEquals(5, root.getValue());
        assertEquals(7, rightRoot.getValue());
        assertEquals(8, rightRoot.getRight().getValue());
        assertEquals(6, rightRoot.getLeft().getValue());
        assertEquals(4, leftRoot.getValue());
        assertEquals(-1, leftRoot.getLeft().getValue());
        assertEquals(-1, leftRoot.getRight().getValue());
    }
    @Test
    public void testRightRotateInRightLeaf() {
        RedBlackBST myTree = new RedBlackBST();

        myTree.add(2);
        myTree.add(1);
        myTree.add(7);
        myTree.add(5);
        myTree.add(8);
        myTree.add(4);
        myTree.add(6);
        ColorNode root = myTree.getRoot().getRight();
        ColorNode newRoot = myTree.rightRotate(root);
        root = myTree.getRoot().getRight();
        ColorNode leftRoot = root.getLeft();
        ColorNode rightRoot = root.getRight();

        assertEquals(root, newRoot);
        assertEquals(5, root.getValue());
        assertEquals(7, rightRoot.getValue());
        assertEquals(8, rightRoot.getRight().getValue());
        assertEquals(6, rightRoot.getLeft().getValue());
        assertEquals(4, leftRoot.getValue());
        assertEquals(-1, leftRoot.getLeft().getValue());
        assertEquals(-1, leftRoot.getRight().getValue());
    }
    @Test
    public void testRightRotateInLeftLeaf() {
        RedBlackBST myTree = new RedBlackBST();

        myTree.add(10);
        myTree.add(12);
        myTree.add(7);
        myTree.add(5);
        myTree.add(8);
        myTree.add(4);
        myTree.add(6);
        ColorNode root = myTree.getRoot().getLeft();
        ColorNode newRoot = myTree.rightRotate(root);
        root = myTree.getRoot().getLeft();
        ColorNode leftRoot = root.getLeft();
        ColorNode rightRoot = root.getRight();

        assertEquals(root, newRoot);
        assertEquals(5, root.getValue());
        assertEquals(7, rightRoot.getValue());
        assertEquals(8, rightRoot.getRight().getValue());
        assertEquals(6, rightRoot.getLeft().getValue());
        assertEquals(4, leftRoot.getValue());
        assertEquals(-1, leftRoot.getLeft().getValue());
        assertEquals(-1, leftRoot.getRight().getValue());
    }

    @Test
    public void testAddRedBlackBST() {
        RedBlackBST myTree = new RedBlackBST();

        assertTrue(myTree.add(8));
        assertTrue(myTree.add(10));
        assertTrue(myTree.add(6));
        assertTrue(myTree.add(2));
        assertTrue(myTree.add(5));
        assertTrue(myTree.add(7));
        assertTrue(myTree.add(9));
        assertTrue(myTree.add(3));

//        assertEquals(3, myTree.getLevel());
        assertEquals(8, myTree.size());
    }

}
