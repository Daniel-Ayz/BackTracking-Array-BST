package Tests;


import Assignment2.BacktrackingBST;
import Assignment2.BacktrackingBST.Node;
import Assignment2.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingBSTTest {

    BacktrackingBST bst;
    Node n12, n6, n29, n11, n13, n_9;

    @BeforeEach
    void setUp() {
        bst = new BacktrackingBST(new Stack(), new Stack());
        n12 = new BacktrackingBST.Node(12, 12);
        n6 = new BacktrackingBST.Node(6, 6);
        n29 = new BacktrackingBST.Node(29, 29);
        n11 = new BacktrackingBST.Node(11, 11);
        n13 = new BacktrackingBST.Node(13, 13);
        n_9 = new BacktrackingBST.Node(-9, -9);

        bst.insert(n12);
        bst.insert(n6);
        bst.insert(n29);
    }

    @Test
    void search() {
    }

    @Test
    void insert() {
        Assertions.assertEquals("12 6 29", bst.getRoot().preOrder());
        bst.insert(n11);
        Assertions.assertEquals("12 6 11 29", bst.getRoot().preOrder());
    }

    @Test
    void deleteLeft() {
        bst.insert(n11);
        bst.insert(n13);
        bst.insert(n_9);
        Assertions.assertEquals("12 6 -9 11 29 13", bst.getRoot().preOrder());
        bst.delete(n29);
        Assertions.assertEquals("12 6 -9 11 13", bst.getRoot().preOrder());
    }

    @Test
    void deleteLeaf() {
        bst.insert(n11);
        bst.insert(n13);
        bst.insert(n_9);
        Assertions.assertEquals("12 6 -9 11 29 13", bst.getRoot().preOrder());
        bst.delete(n13);
        Assertions.assertEquals("12 6 -9 11 29", bst.getRoot().preOrder());
    }

    @Test
    void deleteRight() {
        bst.insert(n11);
        bst.insert(n13);
        Assertions.assertEquals("12 6 11 29 13", bst.getRoot().preOrder());
        bst.delete(n6);
        Assertions.assertEquals("12 11 29 13", bst.getRoot().preOrder());
    }

    @Test
    void deleteDouble() {
        bst.insert(n11);
        bst.insert(n13);
        bst.insert(n_9);
        Assertions.assertEquals("12 6 -9 11 29 13", bst.getRoot().preOrder());
        bst.delete(n6);
        Assertions.assertEquals("12 11 -9 29 13", bst.getRoot().preOrder());
    }

    @Test
    void deleteRoot() {
        Assertions.assertEquals("12 6 29", bst.getRoot().preOrder());
        bst.delete(n12);
        Assertions.assertEquals("29 6", bst.getRoot().preOrder());
        bst.delete(n29);
        Assertions.assertEquals("6", bst.getRoot().preOrder());
        bst.delete(n6);
        Assertions.assertThrows(NoSuchElementException.class, () -> bst.getRoot());
    }

    @Test
    void minimum() {
    }

    @Test
    void maximum() {
    }

    @Test
    void successor() {
    }

    @Test
    void predecessor() {
    }

    @Test
    void backtrack() {
    }

    @Test
    void retrack() {
    }

    @Test
    void print() {

    }
}