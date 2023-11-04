/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecturer;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        bst b = new bst();
        lecturer[] lec = new lecturer[9];
        lecturer lec1 = new lecturer(5, 55);
        lecturer lec2 = new lecturer(3, 33);
        lecturer lec3 = new lecturer(2, 22);
        lecturer lec4 = new lecturer(4, 44);
        lecturer lec5 = new lecturer(7, 77);
        lecturer lec6 = new lecturer(6, 66);
        lecturer lec7 = new lecturer(8, 88);
        lecturer lec8 = new lecturer(1, 11);
        lecturer lec9 = new lecturer(9, 99);

        lec[0] = lec1;
        lec[1] = lec2;
        lec[2] = lec3;
        lec[3] = lec4;
        lec[4] = lec5;
        lec[5] = lec6;
        lec[6] = lec7;
        lec[7] = lec8;
        lec[8] = lec9;

        //1.To obtain the tree from A [constructor, (+lecturer) 2.5].
        System.out.println("Question 1 ---");
        b.insertMany(lec);
        System.out.println();

        //2.Count the number of levels using a breadth-first search [num_level, 1.0]. 
        System.out.println("Question 2 ---");
        System.out.println("Level: " + b.numLevels(b.root));
        System.out.println();

        //3.Get the information of the lecturer having the maximum teaching hours [peek_max_mark, 1.0]. 
        System.out.println("Question 3 ---");
        lecturer maxHoursLecturer = b.peek_max_teaching_hours();
        System.out.println("" + maxHoursLecturer.getTeaching_code() + "---" + maxHoursLecturer.getTeaching_hours());
        System.out.println();

        //4.Using a recursion to traverse by in-order and store the result to array Ain [in_order_recur, 1.0]. 
        System.out.println("Question 4 ---");
        ArrayList<lecturer> Ain = new ArrayList<>();
        Ain = b.inorderTraversal();
        for (lecturer l : Ain) {
            System.out.print("(" + l.getTeaching_code() + "," + l.getTeaching_hours() + ") ");
        }
        System.out.println();

        //5.Using an linked-list-based stack to traverse by pre-order and store the result to array Apre [pre_order_list_stack, 1.0].
        System.out.println("Question 5 ---");
        ArrayList<lecturer> Apre = new ArrayList<>();
        Apre = b.preOrderTraversal();
        for (lecturer l : Apre) {
            System.out.print("(" + l.getTeaching_code() + "," + l.getTeaching_hours() + ") ");
        }
        System.out.println();
        
        //

    }
}
