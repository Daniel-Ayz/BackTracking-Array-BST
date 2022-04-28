package Tests;
import Assignment2.BacktrackingArray;
import Assignment2.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BacktrackingArrayTest {
    BacktrackingArray arr;

    @BeforeEach
    void setUp() {
        arr=new BacktrackingArray(new Stack(),10);
        arr.insert(4); //0
        arr.insert(7); //1
        arr.insert(8); //2
        arr.insert(3); //3
        arr.insert(2); //4
        arr.insert(0); //5
        arr.insert(6); //6
        arr.insert(9); //7

    }

    @org.junit.jupiter.api.Test
    void get() {
        Assertions.assertEquals(0,arr.get(5));

    }

    @org.junit.jupiter.api.Test
    void search() {
        Assertions.assertEquals(-1,arr.search(5));
        Assertions.assertEquals(6,arr.search(6));
        Assertions.assertEquals(7,arr.search(9));
    }

    @org.junit.jupiter.api.Test
    void insert() {
        arr.insert(2); //8
        arr.insert(0); //9
        Assertions.assertEquals(2,arr.get(8));
        Assertions.assertEquals(0,arr.get(9));
        Assertions.assertThrows(RuntimeException.class, () -> arr.insert(6)); //10
    }

    @org.junit.jupiter.api.Test
    void delete() {
        arr.delete(2);
        Assertions.assertEquals(9,arr.get(2));
        Assertions.assertEquals(3,arr.get(3));
        Assertions.assertEquals(2,arr.get(4));
        Assertions.assertEquals(0,arr.get(5));
        Assertions.assertEquals(6,arr.get(6));
        Assertions.assertThrows(RuntimeException.class, () -> arr.get(7));
    }

    @org.junit.jupiter.api.Test
    void minimum() {
        Assertions.assertEquals(5,arr.minimum());
    }

    @org.junit.jupiter.api.Test
    void maximum() {
        Assertions.assertEquals(7,arr.maximum());
    }

    @org.junit.jupiter.api.Test
    void successor() {
        Assertions.assertEquals(6,arr.successor(0));
        Assertions.assertEquals(2,arr.successor(1));
        Assertions.assertEquals(7,arr.successor(2));

        Assertions.assertThrows(RuntimeException.class, () -> arr.successor(7));
        Assertions.assertThrows(RuntimeException.class, () -> arr.successor(8));
        Assertions.assertThrows(RuntimeException.class, () -> arr.successor(-1));
    }

    @org.junit.jupiter.api.Test
    void predecessor() {
        Assertions.assertEquals(3,arr.predecessor(0));
        Assertions.assertEquals(6,arr.predecessor(1));
        Assertions.assertEquals(1,arr.predecessor(2));

        Assertions.assertThrows(RuntimeException.class, () -> arr.predecessor(5));
        Assertions.assertThrows(RuntimeException.class, () -> arr.predecessor(8));
        Assertions.assertThrows(RuntimeException.class, () -> arr.predecessor(-1));
    }

    @org.junit.jupiter.api.Test
    void backtrack() {
        Assertions.assertEquals("4 7 8 3 2 0 6 9", arr.toString());
        arr.insert(10);
        arr.insert(5);
        Assertions.assertEquals("4 7 8 3 2 0 6 9 10 5", arr.toString());
        arr.delete(3);
        Assertions.assertEquals("4 7 8 5 2 0 6 9 10", arr.toString());
        arr.backtrack();
        Assertions.assertEquals("4 7 8 3 2 0 6 9 10 5", arr.toString());
        arr.backtrack();
        arr.backtrack();
        Assertions.assertEquals("4 7 8 3 2 0 6 9", arr.toString());
    }

    @org.junit.jupiter.api.Test
    void print() {
        Assertions.assertEquals("4 7 8 3 2 0 6 9", arr.toString());
    }
}