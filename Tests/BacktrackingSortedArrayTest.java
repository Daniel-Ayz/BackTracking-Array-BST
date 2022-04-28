package Tests;

import Assignment2.BacktrackingArray;
import Assignment2.BacktrackingSortedArray;
import Assignment2.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingSortedArrayTest {
    BacktrackingSortedArray arr;

    @BeforeEach
    void setUp() {
        arr=new BacktrackingSortedArray(new Stack(),10);
        arr.arr[0]=-5;
        arr.arr[1]=0;
        arr.arr[2]=3;
        arr.arr[3]=4;
        arr.arr[4]=7;
        arr.arr[5]=8;
        arr.arr[6]=11;
        arr.arr[7]=18;
        arr.count=8;

    }

    @org.junit.jupiter.api.Test
    void get() {
        Assertions.assertEquals(8,arr.get(5));
        Assertions.assertEquals(11,arr.get(6));
        Assertions.assertEquals(18,arr.get(7));
        Assertions.assertThrows(RuntimeException.class, () -> arr.get(8));

    }

    @org.junit.jupiter.api.Test
    void search() {
        Assertions.assertEquals(0,arr.search(-5));
        Assertions.assertEquals(1,arr.search(0));
        Assertions.assertEquals(2,arr.search(3));
        Assertions.assertEquals(3,arr.search(4));
        Assertions.assertEquals(4,arr.search(7));
        Assertions.assertEquals(7,arr.search(18));
        Assertions.assertEquals(-1,arr.search(1));
        Assertions.assertEquals(-1,arr.search(20));
    }

    @org.junit.jupiter.api.Test
    void insert() {
        arr.insert(1); //2
        arr.insert(20); //9
        Assertions.assertEquals(1,arr.get(2));
        Assertions.assertEquals(20,arr.get(9));
        Assertions.assertThrows(RuntimeException.class, () -> arr.insert(6)); //10
    }

    @org.junit.jupiter.api.Test
    void insert2() {
        arr.insert(-10); //0
        arr.insert(15); //8
        Assertions.assertEquals(-10,arr.get(0));
        Assertions.assertEquals(15,arr.get(8));
    }


    @org.junit.jupiter.api.Test
    void delete() {
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
        arr.delete(2);
        Assertions.assertEquals("-5 0 4 7 8 11 18", arr.toString());
        Assertions.assertThrows(RuntimeException.class, () -> arr.delete(7));
        arr.delete(0);
        Assertions.assertEquals("0 4 7 8 11 18", arr.toString());
        arr.delete(0);
        arr.delete(0);
        arr.delete(0);
        Assertions.assertEquals("8 11 18", arr.toString());
        arr.delete(2);
        arr.delete(1);
        arr.delete(0);
        Assertions.assertEquals("", arr.toString());
        Assertions.assertEquals(0,arr.count);
    }

    @org.junit.jupiter.api.Test
    void minimum() {
        Assertions.assertEquals(0, arr.minimum());
    }

    @org.junit.jupiter.api.Test
    void maximum() {
        Assertions.assertEquals(7,arr.maximum());
    }

    @org.junit.jupiter.api.Test
    void successor() {
        Assertions.assertEquals(1,arr.successor(0));
        Assertions.assertEquals(2,arr.successor(1));
        Assertions.assertEquals(3,arr.successor(2));
        Assertions.assertEquals(4,arr.successor(3));
        Assertions.assertEquals(5,arr.successor(4));
        Assertions.assertEquals(6,arr.successor(5));
        Assertions.assertEquals(7,arr.successor(6));
        Assertions.assertThrows(RuntimeException.class, () -> arr.successor(7));
        Assertions.assertThrows(RuntimeException.class, () -> arr.successor(8));
        Assertions.assertThrows(RuntimeException.class, () -> arr.successor(-1));
    }

    @org.junit.jupiter.api.Test
    void predecessor() {
        Assertions.assertEquals(6,arr.predecessor(7));
        Assertions.assertEquals(5,arr.predecessor(6));
        Assertions.assertEquals(4,arr.predecessor(5));
        Assertions.assertEquals(3,arr.predecessor(4));
        Assertions.assertEquals(2,arr.predecessor(3));
        Assertions.assertEquals(1,arr.predecessor(2));
        Assertions.assertEquals(0,arr.predecessor(1));

        Assertions.assertThrows(RuntimeException.class, () -> arr.predecessor(8));
        Assertions.assertThrows(RuntimeException.class, () -> arr.predecessor(0));
        Assertions.assertThrows(RuntimeException.class, () -> arr.predecessor(-1));
    }

    @org.junit.jupiter.api.Test
    void backtrack() {
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
        arr.delete(2);
        Assertions.assertEquals("-5 0 4 7 8 11 18", arr.toString());
        arr.backtrack();
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
        arr.delete(0);
        arr.delete(0);
        arr.backtrack();
        arr.backtrack();
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
    }

    @Test
    void backtrack1(){
        arr.insert(-10); //0
        arr.insert(15); //8
        arr.backtrack();
        arr.backtrack();
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
    }

    @Test
    void backtrack2() {
        arr.insert(1); //2
        arr.insert(20); //9
        Assertions.assertEquals("-5 0 1 3 4 7 8 11 18 20", arr.toString());
        arr.backtrack();
        Assertions.assertEquals("-5 0 1 3 4 7 8 11 18", arr.toString());
        arr.backtrack();
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
    }

    @Test
    void backtrack3() {
        arr.delete(0);
        arr.insert(-7);
        arr.delete(6);
        arr.backtrack();
        arr.backtrack();
        arr.backtrack();
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
    }

    @Test
    void backtrack4() {
        arr.backtrack();
        arr.backtrack();
        arr.backtrack();
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
    }

    @org.junit.jupiter.api.Test
    void print() {
        Assertions.assertEquals("-5 0 3 4 7 8 11 18", arr.toString());
    }


}