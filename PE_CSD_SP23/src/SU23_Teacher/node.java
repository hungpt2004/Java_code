/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Teacher;

/**
 *
 * @author Acer
 */
public class node {
    private teacher data;
    node left, right;
    int balancefactor;
    node(teacher data){
        this.data = data;
        this.left = this.right = null;
        this.balancefactor = 0;
    }

    public teacher getData() {
        return data;
    }
    
    public void setData(teacher data) {
        this.data = data;
    }
    
}
