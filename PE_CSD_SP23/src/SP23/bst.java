/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Acer
 */
public class bst {

    node root;

    public bst() {
        root = null;
    }

    //==================================
    //Insert
    void insert(worker w) {
        if (root == null) {
            root = new node(w);
            return;
        }
        node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.data.getKey() == w.getKey()) {
                System.out.println("The key " + w.getKey() + "is already exists");
                return;
            }
            f = p;
            if (w.getKey() < p.data.getKey()) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (w.getKey() < f.data.getKey()) {
            f.left = new node(w);
        } else {
            f.right = new node(w);
        }
    }

    void insertMany(worker[] worker) {
        Arrays.stream(worker).forEach(w ->insert(w));
    }

    //==================================
    //Find/Search
    node search(node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.data.getKey() == key) {
            return p;
        }
        if (key < p.data.getKey()) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    public node find(int key) {
        return search(root, key);
    }

    //=================================
    //Print worker follow Descending Order 
    void DescendingOrder(node node) {
        if (node == null) {
            return;
        }
        DescendingOrder(node.right);
        System.out.println("" + node.data);
        DescendingOrder(node.left);
    }

    void PrintDescendingOrder() {
        DescendingOrder(root);
    }

    //=================================
    //Count worker have age < 25 in TREE
    int countYounger(node node) {
        if (node == null) {
            return 0;
        }
        int count = countYounger(node.left)
                + countYounger(node.right);
        if (node.data.getAge() < 25) {
            count++;
        }
        return count;
    }

    int countYounger25() {
        return countYounger(root);
    }

    //=================================
    //Delete Right-Most 
    void deleteRightMostNode(node root) {
        while (root.right.right != null) {
            root = root.right;
        }
        node nodeBefore = root;
        nodeBefore.right = null;
    }
    //node deleteRightMost

    //=================================
    //Determine the height of T using a level order traversal
    int determineHeightTree(node node) {
        Queue<node> queue = new LinkedList<>();
        if (node == null) {
            return 0;
        } else {
            queue.add(node);
            int height = 0;
            while (!queue.isEmpty()) {
                node currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                height++;
            }
            return height;
        }
    }

    int heightTree() {
        return determineHeightTree(root);
    }

    //=================================
    //Create a binary search tree of the largest height from a given 
    //non-empty sequence of workers.
    public void createTreeWithLargetHeight(worker[] w) {
        int n = w.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (w[j].getKey() < w[j + 1].getKey()) {
                    worker temp = w[j];
                    w[j] = w[j + 1];
                    w[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            root = insertNode(w[i], root);
        }
    }

    private node insertNode(worker w, node node) {
        if (node == null) {
            return new node(w);
        } else {
            node.right = insertNode(w, node.right);
        }
        return node;
    }
}
