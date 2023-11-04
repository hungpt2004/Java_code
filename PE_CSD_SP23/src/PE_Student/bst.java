/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PE_Student;

import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class bst {
    node root;
    public bst(){
        this.root = null;
    }
    
    //----------------------------------------------------------------------------------------------
    //Insert a student to the BST
    private void insert(student stu) {
        if (root == null) {
            root = new node(stu);
            return;
        }
        node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.getData().getId() == stu.getId()) {
                System.out.println("The key " + stu.getId() + "is already exists");
                return;
            }
            f = p;
            if (stu.getId() < p.getData().getId()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (stu.getId() < f.getData().getId()) {
            f.left = new node(stu);
        } else {
            f.right = new node(stu);
        }
    }

    public void insertMany(student[] st) {
        Arrays.stream(st).forEach(stu -> insert(stu));
    }
    
    //-----------------------------------------------------------------------------------------------
    //Traversal tree by breath_traversal
    private void visit(node node){
        if(node != null){
            System.out.println(" "+node.getData());
        }
    }
    
    public void BFT(node p) {
        if (p == null)
            return;
        myqueue m = new myqueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            node q = (node) m.dequeue();
            visit(q);
            if (q.left != null)
                m.enqueue(q.left);
            if (q.right != null)
                m.enqueue(q.right);
        }
    }

    
    //-----------------------------------------------------------------------------------------------
    //Function traverse tree in decesding order
    private void traverseDescendingOrder(node node){
        if(node == null){
            return;
        }
            traverseDescendingOrder(node.right);
            System.out.println(node.getData()+"");
            traverseDescendingOrder(node.left);
    }
    public void traverseDescendingOrder(){
        traverseDescendingOrder(root);
    }        
    
    //-----------------------------------------------------------------------------------------------
    //Count students who average mark is less than 5
    private int countLessThanFive(node node){
        if(node == null){
            return 0;
        }
        int count = countLessThanFive(node.left) + countLessThanFive(node.right);
        if(node.getData().getAverage() < 5){
            count++;
        }
        return count;
    }
    
    public int countLessThanFive(){
        return countLessThanFive(root);
    }
    
    //-----------------------------------------------------------------------------------------------
    //Delete student whose age is 19
    private void copyDele(student x) {
        if (root == null) {
            System.out.println("The tree is empty, no deletion.");
            return;
        }
        //find f is father of p
        node f = null, p = root;
        while (p != null) {
            if (p.getData().getId() == x.getId()) {
                break;//found key x
            }
            if (x.getId() < p.getData().getId()) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {//not found key x
            System.out.println("The key " + x + " does not exist, no deletion.");
            return;
        }
        //1- p has no child (p is a leaf node)
        if (p.left == null && p.right == null) {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        //2- p has the left child only
        if (p.left != null && p.right == null) {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        //3- p has the right child only
        if (p.left == null && p.right != null) {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        //4- p has both left and right children
        if (p.left != null && p.right != null) {
            node rp; // p's key will be replaced by rp's one
            f = null;
            rp = p.left;
            // Find the right most node on the left sub-tree
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.data = rp.getData();
            if (f == null) // rp is just a left son of p 
            {
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }
    
    public void deleteWhoseIs19(node node){
        if(node == null){
            return;
        }
        int age = 2023 - node.getData().getYearOfBirth();
        if(age == 19){
            copyDele(node.getData());
            deleteWhoseIs19(root);
        }
        deleteWhoseIs19(node.left);
        deleteWhoseIs19(node.right);
    }

}
