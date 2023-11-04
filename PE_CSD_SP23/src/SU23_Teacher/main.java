/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Teacher;

/**
 *
 * @author Acer
 */
public class main {
    public static void main(String[] args) {
        bst b = new bst();
        teacher[] t = new teacher[5];
        t[0] = new teacher(1,5.6);
        t[1] = new teacher(6,7.6);
        t[2] = new teacher(4,3.2);
        t[3] = new teacher(34,56.3);
        t[4] = new teacher(87,34.5);
        
        
        
        //To obtain the tree from A
        System.out.println("Question 1 ---");
        b.insertMany(t);
        b.preorder(b.root);
        System.out.println();
        
        //Increase M/2.0 to the coeff of each teacher where M is the maximum coeff.
        System.out.println("Question 2 ---");
        b.updateTeacher(b.root);
        System.out.println();
        
        
        //Print all nodes in the form of <data,level>
        System.out.println("Question 3 ---");
        b.printTreeNode();
        System.out.println();
        
        
        //Determine fied bal
        System.out.println("Question 4 ---");
        b.determineBalFactors();
        System.out.println();
        
        
        //Output preorder
        System.out.println("Question 5 ---");
        b.preorder(b.root);
        System.out.println();
        
        //Bubble sort
        System.out.println("Question 6 ---");
        b.tree_sort(t);
        System.out.println();
    }
}
