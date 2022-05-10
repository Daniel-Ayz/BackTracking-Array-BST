package Assignment2;

public class Main {

    //--------------

    public static void main(String[] args) {
//        check4l1();
//        check4l2();
//         check4l3();
        check4l32();

    }
    public static void check4l1() {
        System.out.println("check part 4 Q1:");
        Stack s1= new Stack();
        BacktrackingArray array=new BacktrackingArray(s1, 15);
        array.backtrack();
        array.insert(5);
        array.insert(16);
        array.insert(45);
        array.insert(147);
        array.insert(2);
        System.out.println("2|"+array.search(45));
        array.delete(2);
        System.out.println("-1|"+array.search(45));
        array.backtrack();
        System.out.println("2|"+array.search(45));
        array.backtrack();
        System.out.print("5 16 45 147|");
        array.print();
        array.insert(78);
        array.backtrack();
        System.out.println("-1|"+array.search(78));
        System.out.println("2|"+array.predecessor(3));
        array.insert(14);
        array.insert(9);
        System.out.println("5|"+array.predecessor(4));
        array.backtrack();
        System.out.println("0|"+array.predecessor(4));
        array.insert(1);
        System.out.println("5|"+array.minimum());
        System.out.println("3|"+array.maximum());
        System.out.println("1|"+array.successor(4));
        System.out.println("*************************************");

        //eroor checks:
        //System.out.println(array.predecessor(5));
        //System.out.println(array.successor(3));
        //array.delete(13);

        //for (int i=0; i<=15; i++)
        //	array.insert(i);


    }

    public static void check4l2() {
        System.out.println("check part 4 Q2:");
        Stack s1= new Stack();
        BacktrackingSortedArray array=new BacktrackingSortedArray(s1, 15);
        array.backtrack();
        array.insert(5);
        array.insert(16);
        array.insert(45);
        array.insert(147);
        array.insert(2);
        System.out.print("2 5 16 45 147|");
        array.print();

        System.out.println("3|"+array.search(45));
        array.delete(3);
        System.out.println("-1|"+array.search(45));
        array.backtrack();
        System.out.println("3|"+array.search(45));

        array.backtrack();
        System.out.print("5 16 45 147|");
        array.print();
        array.backtrack();
        System.out.print("5 16 45 |");
        array.print();

        array.insert(38);
        System.out.print("5 16 38 45|");
        array.print();

        array.backtrack();
        System.out.println("-1|"+array.search(38));

        System.out.println("1|"+array.predecessor(2));
        array.insert(14);
        array.insert(9);
        System.out.print("5 9 14 16 45|");
        array.print();

        System.out.println("3|"+array.successor(2));
        array.backtrack();
        System.out.println("0|"+array.predecessor(1));
        array.insert(1);
        System.out.println("0|"+array.minimum());
        System.out.println("4|"+array.maximum());
        array.backtrack();
        array.backtrack();
        array.backtrack();
        array.backtrack();
        System.out.print("5|");
        array.print();
        System.out.println("-1|"+array.search(45));
        System.out.println("*************************************");

        //eroor checks:
        //System.out.println(array.predecessor(0));
        //System.out.println(array.successor(4));
        //array.delete(13);

        //for (int i=0; i<=15; i++)
        //	array.insert(i);



    }
    public static void check4l3() {
        System.out.println("check part 4 Q3:");
        Stack s1= new Stack();
        Stack s2= new Stack();
        BacktrackingBST tree=new BacktrackingBST(s1,s2);
        tree.backtrack();
        BacktrackingBST.Node n120=new BacktrackingBST.Node(120,null);
        BacktrackingBST.Node n100=new BacktrackingBST.Node(100,null);
        BacktrackingBST.Node n13=new BacktrackingBST.Node(13,null);
        BacktrackingBST.Node n56=new BacktrackingBST.Node(56,null);
        BacktrackingBST.Node n87=new BacktrackingBST.Node(87,null);
        BacktrackingBST.Node n230=new BacktrackingBST.Node(230,null);
        BacktrackingBST.Node n40=new BacktrackingBST.Node(40,null);
        BacktrackingBST.Node n22=new BacktrackingBST.Node(22,null);
        BacktrackingBST.Node n80=new BacktrackingBST.Node(80,null);

        BacktrackingBST.Node n240=new BacktrackingBST.Node(240,null);

        tree.insert(n120);
        tree.insert(n100);
        tree.insert(n13);
        tree.insert(n56);
        tree.insert(n87);
        tree.insert(n230);
        tree.insert(n40);
        tree.insert(n22);
        tree.insert(n80);


        System.out.println("13|"+tree.minimum());
        System.out.println("230|"+tree.maximum());
        System.out.println("null|"+tree.search(47));
        System.out.println("87|"+tree.search(87));
        System.out.println("87|"+tree.successor(n80));
        System.out.println("230|"+tree.successor(n120));
        System.out.println("22|"+tree.successor(n13));
        System.out.println("13|"+tree.predecessor(n22));
        System.out.println("100|"+tree.predecessor(n120));

        //error check
        //tree.insert(null);
        //System.out.println("error|"+tree.successor(n230));
        //System.out.println("error|"+tree.predecessor(n13));


        System.out.println("the tree at beggining");
        System.out.println(tree.toString());
        System.out.println("***************************");
        tree.backtrack();
        System.out.println("the tree after the backtracking adding 80");
        System.out.println(tree.toString());
        tree.insert(n80);
        System.out.println("the tree after inserting 80 back");
        System.out.println(tree.toString());
        tree.delete(n13);
        tree.delete(n22);
        tree.delete(n56);
        System.out.println("the tree after deliting 13, 22, 56:");
        System.out.println(tree.toString());
        System.out.println("the tree after backtracking the delete of 56 (with 56):");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after after backtracking the delete of 22 (with 22):");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after after backtracking the delete of 13 (supposed to look like the original tree):");
        tree.backtrack();
        System.out.println(tree.toString());
        tree.delete(n120);
        System.out.println("the tree after deleting the root (120)");
        System.out.println(tree.toString());
        tree.delete(n230);
        System.out.println("the tree after deleting the root (230)");
        System.out.println(tree.toString());
        tree.backtrack();
        System.out.println("the tree after bringing back the root (230)");
        System.out.println(tree.toString());
        tree.backtrack();
        System.out.println("the tree after bringing back the root (120)");
        System.out.println(tree.toString());

        System.out.println("*************************************");
    }

    public static void check4l32() {
        System.out.println("check part 4 Q3:");
        Stack s1= new Stack();
        Stack s2= new Stack();
        BacktrackingBST tree=new BacktrackingBST(s1,s2);
        tree.backtrack();
        BacktrackingBST.Node n120=new BacktrackingBST.Node(120,null);
        BacktrackingBST.Node n100=new BacktrackingBST.Node(100,null);
        BacktrackingBST.Node n13=new BacktrackingBST.Node(13,null);
        BacktrackingBST.Node n56=new BacktrackingBST.Node(56,null);
        BacktrackingBST.Node n87=new BacktrackingBST.Node(87,null);
        BacktrackingBST.Node n230=new BacktrackingBST.Node(230,null);
        BacktrackingBST.Node n40=new BacktrackingBST.Node(40,null);
        BacktrackingBST.Node n22=new BacktrackingBST.Node(22,null);
        BacktrackingBST.Node n80=new BacktrackingBST.Node(80,null);
        BacktrackingBST.Node n250=new BacktrackingBST.Node(250,null);

        tree.insert(n40);
        tree.insert(n120);
        tree.insert(n56);
        tree.insert(n13);
        tree.insert(n22);
        tree.insert(n87);
        tree.insert(n250);
        tree.insert(n100);
        tree.insert(n230);

        tree.insert(n80);


        System.out.println("13|"+tree.minimum());
        System.out.println("230|"+tree.maximum());
        System.out.println("null|"+tree.search(47));
        System.out.println("87|"+tree.search(87));
        System.out.println("87|"+tree.successor(n80));
        System.out.println("230|"+tree.successor(n120));
        System.out.println("22|"+tree.successor(n13));
        System.out.println("13|"+tree.predecessor(n22));
        System.out.println("100|"+tree.predecessor(n120));

        //error check
        //tree.insert(null);
        //System.out.println("error|"+tree.successor(n230));
        //System.out.println("error|"+tree.predecessor(n13));


        System.out.println("the tree at beggining");
        System.out.println(tree.toString());
        System.out.println("***************************");
        System.out.println("the tree after the backtracking adding 80");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after inserting 80 back");
        tree.insert(n80);
        System.out.println(tree.toString());
        System.out.println("the tree after deletenig 80 back");
        tree.delete(n80);
        System.out.println(tree.toString());
        System.out.println("the tree after the backtracking deliting 80");
        tree.backtrack();
        System.out.println(tree.toString());



        tree.delete(n13);
        tree.delete(n22);
        tree.delete(n120);
        System.out.println("the tree after deliting 13, 22, 120:");
        System.out.println(tree.toString());
        System.out.println("the tree after backtracking the delete of 120 (with 120):");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after after backtracking the delete of 22 (with 22):");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after after backtracking the delete of 13 (supposed to look like the original tree):");
        tree.backtrack();
        System.out.println(tree.toString());

        tree.delete(n120);
        System.out.println("the tree after deliting 120:");
        System.out.println(tree.toString());
        System.out.println("the tree after backtracking the delete of 120 (with 120):");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after deleting the root (40)");
        tree.delete(n40);
        System.out.println(tree.toString());
        System.out.println("the tree after deleting the root (56)");
        tree.delete(n56);
        System.out.println(tree.toString());
        System.out.println("the tree after bringing back the root (56)");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("the tree after bringing back the root (40)");
        tree.backtrack();
        System.out.println(tree.toString());
        System.out.println("13|"+n13);
//        System.out.println("40|"+n13.parent);
        System.out.println("40|"+n40);
        System.out.println("56|"+n56);
        System.out.println("the tree after deliting 13");
        tree.delete(n13);
        System.out.println(tree.toString());
        System.out.println("*************************************");

    }
//----------------------------------------
}




