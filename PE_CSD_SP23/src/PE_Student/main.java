/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PE_Student;

/**
 *
 * @author Acer
 */
public class main {
    public static void main(String[] args) {
        bst b = new bst();
        student[] students = new student[10];

        // Khởi tạo từng đối tượng sinh viên và thêm vào mảng
        students[0] = new student(1, "John Doe", 1999, 4.5);
        students[1] = new student(2, "Jane Smith", 2000, 78.2);
        students[2] = new student(3, "Michael Johnson", 1998, 90.0);
        students[3] = new student(4, "Emily Davis", 2004, 2.8);
        students[4] = new student(5, "Chris Wilson", 2004, 88.6);
        students[5] = new student(6, "Amanda Brown",2002, 91.5);
        students[6] = new student(7, "Daniel Martinez", 1997, 75.2);
        students[7] = new student(8, "Olivia Garcia", 2003, 2.7);
        students[8] = new student(9, "Sophia Rodriguez", 1998, 87.1);
        students[9] = new student(10, "Matthew Hernandez", 2004, 82.4);
    
        //----------------------------------
        //Insert - Obtain Tree
        System.out.println("Question 1");
        b.insertMany(students);
        System.out.println();
        
        
        
        //----------------------------------
        //Traversal BFT
        System.out.println("Question 2");
        b.BFT(b.root);
        System.out.println();
        
        
        
        //----------------------------------
        //Traversal Descending Order
        System.out.println("Question 3");
        b.traverseDescendingOrder();
        System.out.println();
        
        
        
        //----------------------------------
        //Count average less than 5
        System.out.println("Question 4");
        System.out.println(""+b.countLessThanFive());
        System.out.println();
        
        
        //----------------------------------
        //Delete student whose age = 19
        System.out.println("Question 5");
        b.deleteWhoseIs19(b.root);
        System.out.println();
        
        //Test delete
        b.BFT(b.root);
    }
}
