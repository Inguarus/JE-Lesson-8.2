package com.inguarus;

public class TreeTest {

    public static void main(String[] args) {

        MyTreeSet<Integer> treeSet = new MyTreeSet<>();
        treeSet.add(12);
        treeSet.add(45);
        treeSet.add(23);
        treeSet.add(78);
        treeSet.add(10);
        treeSet.add(89);
        treeSet.add(30);
        treeSet.add(5);
        treeSet.add(125);
        treeSet.add(99);
        System.out.println("Contents of MyTreeSet collection: " + treeSet);
        System.out.println("Size of MyTreeSet collection: " + treeSet.size() + " elements");
        System.out.println(treeSet.contains(5));
        System.out.println(treeSet.contains(100));
        System.out.println("Contents of MyTreeSet collection before remove the element: " + treeSet);
        treeSet.remove(12);
        System.out.println("Contents of MyTreeSet collection after remove the element: " + treeSet);
        treeSet.clear();
        System.out.println("MyTreeSet is cleared: " + treeSet);

    }
}
