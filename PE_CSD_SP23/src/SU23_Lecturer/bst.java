/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecturer;

import SU23_Teacher.teacher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Acer
 */
public class bst {
    node root;

    public bst() {
        this.root = null;
    }
    
    //Question 1
    //=======================================
    //Insert lecturer ---  Obtain tree
    private void insert(lecturer lec) {
        if (root == null) {
            root = new node(lec);
            return;
        }
        node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.getData().getTeaching_code() == lec.getTeaching_code()) {
                System.out.println("The key " + lec.getTeaching_code() + "is already exists");
                return;
            }
            f = p;
            if (lec.getTeaching_code() < p.getData().getTeaching_code()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (lec.getTeaching_code() < f.getData().getTeaching_code()) {
            f.left = new node(lec);
        } else {
            f.right = new node(lec);
        }
    }

    public void insertMany(lecturer[] lecturer) {
        Arrays.stream(lecturer).forEach(lec -> insert(lec));
    }
    
    
    //=====================================
    //Question 3
    //Count the number of level using BFS
    public int numLevels(node root) {
        if (root == null) {
            return 0; // Trường hợp cây rỗng không có tầng nào
        }

        Queue<node> queue = new LinkedList<>();
        queue.add(root);
        int levels = 0;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();

            while (nodesAtCurrentLevel > 0) {
                node temp = queue.poll();

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

                nodesAtCurrentLevel--;
            }
            levels++; // Đã duyệt hết một tầng
        }
        return levels;
    }
    
    //Question 4
    //Get the information of the lecturer having the maximum teaching hours [peek_max_mark, 1.0]. 
    private lecturer findMaximumTeachingHours(node node){
        if(node == null){
            return null;
        }
        while(node.right != null){
            node = node.right;
        }
        return node.getData();
    }
    public lecturer peek_max_teaching_hours(){
        return findMaximumTeachingHours(root);
    }
    
    //Visit node
    private void visit(node node){
        if(node == null){
            return;
        } else {
            System.out.println(" "+node.getData());
        }
    }
    
    //Question 5
    //Using a recursion to traverse by in-order and store the result to array Ain [in_order_recur, 1.0].
    //Inorder
    private void inorder(node node, ArrayList<lecturer> Ain){
        if(node == null){
            return;
        } else {
            inorder(node.left, Ain);
            Ain.add(node.getData());
            inorder(node.right, Ain);
        }
    }
    public  ArrayList<lecturer> inorderTraversal(){
         ArrayList<lecturer> Ain = new ArrayList<>();
         inorder(root, Ain);
         return Ain;
    }
    
    //Question 5
    //Using an linked-list-based stack to traverse by pre-order and store the result to array Apre
    private void preOrder(node node, ArrayList<lecturer> Apre){
        if(node == null){
            return;
        }
        LinkedList<node> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            node top = stack.poll();
            if(top.left != null){
                stack.push(top.left);
            }
            if(top.right != null){
                stack.push(top.right);
            }
            Apre.add(top.getData());
        }
    }
    
    public ArrayList<lecturer> preOrderTraversal() {
        ArrayList<lecturer> Apre = new ArrayList<>();
        preOrder(root, Apre);
        return Apre;
    }
    
    //Question 6
    //Comprise BST T2 from 2 arrays of Ain and Apre with a recursion 
    public void buildTreeFrom(ArrayList<lecturer> Apre){
        for(lecturer lec : Apre){
            insert(lec);
        }
        for(lecturer lec : Apre){
            System.out.println(" "+lec.getTeaching_code()+"---"+lec.getTeaching_hours());
        }
    }
}
