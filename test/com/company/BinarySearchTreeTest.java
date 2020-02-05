package com.company;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        assertEquals(4, myTree.getLevel());
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

        assertEquals("[2,3,4,6,7,8,9,10]", myTree.toString());
    }

    @Test
    public void testLevel() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        assertEquals(0, myTree.getLevel());
        myTree.add(10);
        assertEquals(1, myTree.getLevel());
        myTree.add(6);
        assertEquals(1, myTree.getLevel());
        myTree.add(2);
        assertEquals(2, myTree.getLevel());
        myTree.add(5);
        assertEquals(3, myTree.getLevel());
        myTree.add(7);
        assertEquals(3, myTree.getLevel());
        myTree.add(9);
        assertEquals(3, myTree.getLevel());
        myTree.add(3);

        assertEquals(4, myTree.getLevel());
    }
    @Test
    public void testContains() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(6);
        myTree.add(2);
        myTree.add(5);
        myTree.add(7);
        myTree.add(9);
        myTree.add(3);

        assertTrue(myTree.contains(8));
        assertTrue(myTree.contains(10));
        assertTrue(myTree.contains(6));
        assertTrue(myTree.contains(2));
        assertTrue(myTree.contains(5));
        assertTrue(myTree.contains(7));
        assertTrue(myTree.contains(9));
        assertTrue(myTree.contains(3));
        assertFalse(myTree.contains(0));
        assertFalse(myTree.contains(100));
    }
    @Test
    public void testRemove() {
        BinarySearchTree myTree = new BinarySearchTree();

        myTree.add(8);
        myTree.add(10);
        myTree.add(4);
        myTree.add(9);
        myTree.add(12);
        myTree.add(2);
        myTree.add(6);
        myTree.add(5);
        myTree.add(7);

        assertEquals("[2,4,5,6,7,8,9,10,12]", myTree.toString());

        assertTrue(myTree.remove(4));

        assertEquals("[2,5,6,7,8,9,10,12]", myTree.toString());



    }
}
