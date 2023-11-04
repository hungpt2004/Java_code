/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecturer;

/**
 *
 * @author Acer
 */
public class node {
    private lecturer data;
    node left, right;

    node(lecturer data) {
        this.data = data;
        this.left = this.right = null;
    }

    public lecturer getData() {
        return data;
    }

    public void setData(lecturer data) {
        this.data = data;
    }
    
}
