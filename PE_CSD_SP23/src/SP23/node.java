/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SP23;

/**
 *
 * @author Acer
 */
public class node {
    worker data;

    public worker getData() {
        return data;
    }

    public void setData(worker data) {
        this.data = data;
    }
    node left, right;
    node(worker data){
        this.data = data;
        this.left = this.right = null;
    }
    
}
