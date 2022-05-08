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
    Node n12, n6, n29, n11, n13, n_9,n2,n9,n8,n10,n7;

    @BeforeEach
    void setUp() {
        bst = new BacktrackingBST(new Stack(), new Stack());
        n12 = new BacktrackingBST.Node(12, 12);
        n6 = new BacktrackingBST.Node(6, 6);
        n29 = new BacktrackingBST.Node(29, 29);
        n11 = new BacktrackingBST.Node(11, 11);
        n13 = new BacktrackingBST.Node(13, 13);
        n_9 = new BacktrackingBST.Node(-9, -9);
        n2 = new BacktrackingBST.Node(2, 2);
        n9 = new BacktrackingBST.Node(9, 9);
        n7 = new BacktrackingBST.Node(7, 7);
        n8 = new BacktrackingBST.Node(8, 8);
        n10 = new BacktrackingBST.Node(10, 10);

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
    void danielDeleteTest(){
        bst.insert(n2);
        bst.insert(n9);
        bst.insert(n7);
        bst.insert(n8);
        bst.insert(n10);
        Assertions.assertEquals("12 6 2 9 7 8 10 29", bst.getRoot().preOrder());
        bst.delete(n6);
        Assertions.assertEquals("12 7 2 9 8 10 29", bst.getRoot().preOrder());

        Assertions.assertEquals(n7,n12.left);
        Assertions.assertEquals(n29,n12.right);
        Assertions.assertEquals(null,n12.parent);

        Assertions.assertEquals(n2,n7.left);
        Assertions.assertEquals(n9,n7.right);
        Assertions.assertEquals(n12,n7.parent);

        Assertions.assertEquals(null,n2.left);
        Assertions.assertEquals(null,n2.right);
        Assertions.assertEquals(n7,n2.parent);

        Assertions.assertEquals(n8,n9.left);
        Assertions.assertEquals(n10,n9.right);
        Assertions.assertEquals(n7,n9.parent);

        Assertions.assertEquals(null,n8.left);
        Assertions.assertEquals(null,n8.right);
        Assertions.assertEquals(n9,n8.parent);

        Assertions.assertEquals(null,n10.left);
        Assertions.assertEquals(null,n10.right);
        Assertions.assertEquals(n9,n10.parent);

        Assertions.assertEquals(null,n29.left);
        Assertions.assertEquals(null,n29.right);
        Assertions.assertEquals(n12,n29.parent);

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
    void danielBacktrackAndRetrack() {
        bst.insert(n2);
        bst.insert(n9);
        bst.insert(n7);
        bst.insert(n8);
        bst.insert(n10);

        Assertions.assertEquals("12 6 2 9 7 8 10 29", bst.getRoot().preOrder());
        bst.delete(n6);
        Assertions.assertEquals("12 7 2 9 8 10 29", bst.getRoot().preOrder());
        bst.backtrack();
        Assertions.assertEquals("12 6 2 9 7 8 10 29", bst.getRoot().preOrder());
        bst.retrack();
        Assertions.assertEquals("12 7 2 9 8 10 29", bst.getRoot().preOrder());
        bst.backtrack();
        Assertions.assertEquals("12 6 2 9 7 8 10 29", bst.getRoot().preOrder());
        bst.delete(n9);
        Assertions.assertEquals("12 6 2 10 7 8 29", bst.getRoot().preOrder());
        bst.backtrack();
        Assertions.assertEquals("12 6 2 9 7 8 10 29", bst.getRoot().preOrder());
        bst.delete(n12);
        Assertions.assertEquals("29 6 2 9 7 8 10", bst.getRoot().preOrder());
        bst.delete(n29);
        Assertions.assertEquals("6 2 9 7 8 10", bst.getRoot().preOrder());
        bst.delete(n6);
        Assertions.assertEquals("7 2 9 8 10", bst.getRoot().preOrder());
        bst.backtrack();
        bst.backtrack();
        bst.backtrack();
        Assertions.assertEquals("12 6 2 9 7 8 10 29", bst.getRoot().preOrder());
        bst.delete(n6);
        bst.retrack();
        Assertions.assertEquals("12 7 2 9 8 10 29", bst.getRoot().preOrder());


        Assertions.assertEquals(n7,n12.left);
        Assertions.assertEquals(n29,n12.right);
        Assertions.assertEquals(null,n12.parent);

        Assertions.assertEquals(n2,n7.left);
        Assertions.assertEquals(n9,n7.right);
        Assertions.assertEquals(n12,n7.parent);

        Assertions.assertEquals(null,n2.left);
        Assertions.assertEquals(null,n2.right);
        Assertions.assertEquals(n7,n2.parent);

        Assertions.assertEquals(n8,n9.left);
        Assertions.assertEquals(n10,n9.right);
        Assertions.assertEquals(n7,n9.parent);

        Assertions.assertEquals(null,n8.left);
        Assertions.assertEquals(null,n8.right);
        Assertions.assertEquals(n9,n8.parent);

        Assertions.assertEquals(null,n10.left);
        Assertions.assertEquals(null,n10.right);
        Assertions.assertEquals(n9,n10.parent);

        Assertions.assertEquals(null,n29.left);
        Assertions.assertEquals(null,n29.right);
        Assertions.assertEquals(n12,n29.parent);
    }

    @Test
    void retrack() {
    }

    @Test
    void print() {

    }
}