/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PE_Student;

import java.util.LinkedList;

/**
 *
 * @author Acer
 */
public class myqueue {
    LinkedList a;

    myqueue() {
        a = new LinkedList();
    }

    boolean isEmpty() {
        return (a.isEmpty());
    }

    void enqueue(Object x) {
        a.add(x);
    }

    Object dequeue() {
        return (a.removeFirst());
    }
}
