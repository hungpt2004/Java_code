/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Teacher;

import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class bst {

    node root;

    public bst() {
        this.root = null;
    }

    //================================
    //1.Obtain the tree from A
    private void insert(teacher t) {
        if (root == null) {
            root = new node(t);
            return;
        }
        node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.getData().getCode() == t.getCode()) {
                System.out.println("The key " + t.getCode() + "is already exists");
                return;
            }
            f = p;
            if (t.getCode() < p.getData().getCode()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (t.getCode() < f.getData().getCode()) {
            f.left = new node(t);
        } else {
            f.right = new node(t);
        }
    }

    public void insertMany(teacher[] teacher) {
        Arrays.stream(teacher).forEach(t -> insert(t));
    }

    //============================
    //2.Maximum coeff
    double maximumCoeff() {
        if (root == null) {
            return 0;
        }
        while (root != null) {
            root = root.right;
        }
        return root.getData().getCoeff();
    }

    //2.2. UpdateTeacher
    public void updateTeacher(node node) {
        if (node == null) {
            return;
        }
        double maxCoeff = node.getData().getCoeff();
        myqueue m = new myqueue();
        m.enqueue(node);
        while (!m.isEmpty()) {
            node q = (node) m.dequeue();
            if (maxCoeff < q.getData().getCoeff()) {
                maxCoeff = q.getData().getCoeff();
            }
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
        m.enqueue(node);
        while (!m.isEmpty()) {
            node q = (node) m.dequeue();
            q.getData().setCoeff((double) q.getData().getCoeff() + maxCoeff / 2);
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
    }

    //======================================
    //3. Print all nodes in form of <data, level>
    private void printTreeNode(node node, int level) {
        if (node == null) {
            return;
        } else {
            System.out.println("Data: " + node.getData().getCode() + "---" + node.getData().getCoeff() + "---" + level);
            printTreeNode(node.left, level + 1);
            printTreeNode(node.right, level + 1);
        }
    }

    public void printTreeNode() {
        printTreeNode(root, 0);
    }

    //======================================
    //4.Determine the field bal for all node
    public void determineBalFactors() {
        System.out.println("" + determineBalFactors(root));
    }

    private int determineBalFactors(node node) {
        if (node == null) {
            return 0;
        }
        int left = determineBalFactors(node.left);
        int right = determineBalFactors(node.right);
        node.balancefactor = left - right;
        return Math.max(determineBalFactors(node.left), determineBalFactors(node.right)) + 1;
    }

    //======================================
    //5.Preorder traversal
    private void visit(node node) {
        if (node != null) {
            System.out.println(" " + node.getData());
        }
    }

    public void preorder(node node) {
        if (node != null) {
            visit(node);
            preorder(node.left);
            preorder(node.right);
        }
    }

    //======================================
    //II. Bubble sort follow Teacher
    public void tree_sort(teacher[] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length - i - 1; j++) {
                if (t[j].getCode() > t[j + 1].getCode()) {
                    teacher tmp = t[j];
                    t[j] = t[j + 1];
                    t[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("" + t[i].getCode() + ", " + t[i].getCoeff());
        }
    }

    //======================================
    //Print Nodes
    void printNodes(node node) {
    if (node != null) {
        System.out.println(node.getData() + " ");
        printNodes(node.left);
        printNodes(node.right);
    }
}
}
