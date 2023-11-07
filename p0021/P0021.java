/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p0021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author Acer
 */
public class P0021 {

    static ArrayList<student> studentList = new ArrayList<>();
    static ArrayList<report> reports = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {
        int choice;
        student st1 = new student("1", "hung", 2 , "Java");
        student st2 = new student("2", "nguyen", 5 , "C/C++");
        student st3 = new student("3", "minh", 3 , ".Net");
        student st4 = new student("1", "hung", 8 , ".Net");
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        
        do {
            System.out.println("1.Create new student");
            System.out.println("2.Find and Sort");
            System.out.println("3.Update/Delete");
            System.out.println("4.Report");
            System.out.println("5.Exit");
            choice = check.inputInteger("Enter your selection: ");
            switch (choice) {
                case 1:
                    Create();
                    break;
                case 2:
                    FindAndSort();
                    break;
                case 3:
                    UpdateAndDelete();
                    break;
                case 4:
                    Report();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (choice != 5);
    }

    //====================================================
    //CREATE
    public static ArrayList<student> CreateStudent(String ID) {
        boolean found = false;

        for (student std : studentList) {
            if (std.getId().equalsIgnoreCase(ID)) {
                String id = ID;
                String name = std.getName();
                int semester = check.inputInteger("Enter semester: ");
                String nameCourse = check.inputCourseName("Enter courseName: ");

                student newStd = new student(id, name, semester, nameCourse);
                studentList.add(newStd);
                found = true;
                break;
            }
        }

        if (!found) {
            // Nếu tìm thấy ID trong danh sách sinh viên, thêm sinh viên mới với cùng ID
            String name = check.inputName("Enter name: ");
            int semester = check.inputInteger("Enter semester: ");
            String nameCourse = check.inputCourseName("Enter courseName: ");
            count++;
            student newStd = new student(ID, name, semester, nameCourse);
            studentList.add(newStd);
        }
        return studentList;
    }

    //====================================================
    //SORT
    public static void sortName(ArrayList<student> studentList) {
        studentList.sort(new Comparator<student>() {
            @Override
            public int compare(student o1, student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        display(studentList);
    }

    //====================================================
    //FIND
    public static void search(ArrayList<student> studentList) {
        String findName = check.inputName("Enter name want to find: ");
        System.out.println("-----------------------Search Result----------------------");
        if (check.checkExistUser(findName) == false) {
            System.out.println("ID | Name | Course | Semester");
            for (student std : studentList) {
                if (std.getName().contains(findName)) {
                    System.out.println("" + std.getId() + " | " + std.getName() + " | " + std.getNameCourse() + " | " + std.getSemester());
                }
            }
            System.out.println("-----------------------------------------------------------");
        } else {
            System.out.println("Not found !");
        }
    }

    //=========================================================================
    //DELETE
    public static void Delete(ArrayList<student> studentList) {
        String deleteID = check.inputID("Enter the ID you want to delete: ");
        boolean checkRemove = false;
        ArrayList<student> deleteCandidates = new ArrayList<>();

        for (student student : studentList) {
            if (student.getId().contains(deleteID)) {
                deleteCandidates.add(student);
            }
        }
        if (deleteCandidates.isEmpty()) {
            System.out.println("Can't found to delete");    
        } else if(deleteCandidates.size() == 1){
            student removeOnly = deleteCandidates.get(0);
            System.out.println("" + removeOnly.getId() + " | " + removeOnly.getName() + " | " + removeOnly.getNameCourse() + " | " + removeOnly.getSemester());
            studentList.remove(studentList.indexOf(removeOnly));
            checkRemove = true;
        } else {
            for (int i = 0; i < deleteCandidates.size(); i++) {
                student student = deleteCandidates.get(i);
                System.out.println("("+(i + 1) + ") | " + student.getId() + " | " + student.getName() + " | " + student.getNameCourse() + " | " + student.getSemester());
            }
            int choiceDelete = check.inputInteger("Enter the number of student you want to delete: ");
            if (choiceDelete <= deleteCandidates.size()) {
                student removeMore = deleteCandidates.get(choiceDelete - 1);
                System.out.println("" + removeMore.getId() + " | " + removeMore.getName() + " | " + removeMore.getNameCourse() + " | " + removeMore.getSemester());
                studentList.remove(studentList.indexOf(removeMore));
                checkRemove = true;
            }
        }
        if(checkRemove == true){
            System.out.println("Sucessful !");
        }
    }

    //=========================================================================
    //UPDATE
    public static void Update(ArrayList<student> studentList) {
        String updateID = check.inputID("Enter your ID want to update: ");
        boolean checkUpdate = false;
        if(studentList.isEmpty()){
            System.out.println("Can't found to update");
        } else if (studentList.size() == 1){
            student updateOnly = studentList.get(0);
            System.out.println("" + updateOnly.getId() + " | " + updateOnly.getName() + " | " +  updateOnly.getNameCourse() + " | " +  updateOnly.getSemester());
            String newCourse = check.inputCourseName("Enter new course: ");
            updateOnly.setNameCourse(newCourse);
            checkUpdate = true;
        } else {
            for(int i = 0 ; i < studentList.size(); i++){
                student student = studentList.get(i);
                System.out.println("("+(i + 1) + ") | " + student.getId() + " | " + student.getName() + " | " + student.getNameCourse() + " | " + student.getSemester());
            }
            int choice = check.inputInteger("Enter the number of student you want to update course: ");
            if(choice <= studentList.size()){
                student updateMore = studentList.get(choice -1);
                System.out.println("" + updateMore.getId() + " | " + updateMore.getName() + " | " +  updateMore.getNameCourse() + " | " +  updateMore.getSemester());
                String newCourse = check.inputCourseName("Enter new course: ");
                updateMore.setNameCourse(newCourse);
                checkUpdate = true;
            }
        }
        if(checkUpdate == true){
            System.out.println("Sucessful !");
        }
    }
    
    //=========================================================================
    //DISPLAY
    public static void display(ArrayList<student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("student list is empty !");
        } else {
            System.out.println("=================================================");
            for (student std : studentList) {
                System.out.println("" + std.getId() + " | " + std.getName() + " | " + std.getNameCourse() + " | " + std.getSemester());
            }
        }
        System.out.println("=================================================");
    }

    //=========================================================================
    //CREATE REPORT
    public static void report() {
        boolean check = false;
        reports.clear();
        for (int i = 0; i < studentList.size(); i++) {
            for (int j = 0; j < reports.size(); j++) {
                if (studentList.get(i).getName().equalsIgnoreCase(reports.get(j).getStudentName()) && studentList.get(i).getNameCourse().equalsIgnoreCase(reports.get(j).getCourseName())) {
                    reports.get(j).setTotalCourse(reports.get(j).getTotalCourse() + 1);
                    check = true;
                }
            }
            if (!check) {
                reports.add(new report(studentList.get(i).getName(), studentList.get(i).getNameCourse(), 1));
            }
            check = false;
        }
        System.out.println(reports.size());
        for (int i = 0; i < reports.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", reports.get(i).getStudentName(), reports.get(i).getCourseName(), reports.get(i).getTotalCourse());
        }
    }

    //--------------------------------------------------------
    //Menu search and sort
    public static void FindAndSort() {
        int subChoice;
        do {
            System.out.println("1.Find");
            System.out.println("2.Sort");
            System.out.println("3.Back to menu");
            subChoice = check.inputInteger("Enter your selection: ");
            switch (subChoice) {
                case 1:
                    search(studentList);
                    break;
                case 2:
                    sortName(studentList);
                    break;
                case 3:
                    return;
            }
        } while (subChoice != 3);
    }

    //-----------------------------------------------------
    //MENU REPORT
    public static void Report() {
        display(studentList);
        String strChoice;
        do {
            System.out.print("You want to generate report for student ? (Y/N): ");
            strChoice = sc.nextLine();
            switch (strChoice) {
                case "Y":
                    report();
                    break;
                case "N":
                    return;
            }
        } while (strChoice.equalsIgnoreCase("N"));
    }

    //-----------------------------------------------------
    public static void UpdateAndDelete() {
        String subChoice;
        do {
            System.out.println("(E) for Back to menu");
            System.out.print("You want to Update(U) or Delete(D) ? (U/D): ");
            subChoice = sc.nextLine();
            switch (subChoice) {
                case "U":
                    Update(studentList);
                    break;
                case "D":
                    Delete(studentList);
                    break;
                case "E":
                    return;
            }
        } while (subChoice.equalsIgnoreCase("E"));
    }

    //-----------------------------------------------------
    public static void Create() {
        String strChoice;
        System.out.println("---Enter 3 first students---");
        while(studentList.size() < 3){
            String code = check.inputID("Enter code : ");
            CreateStudent(code);
        }
        do {
            System.out.print("You want to create new student ? (Y/N): ");
            strChoice = sc.nextLine();
            switch (strChoice) {
                case "Y":
                    String code = check.inputID("Enter code : ");
                    CreateStudent(code);
                    break;
                case "N":
                    return;
            }
        } while (strChoice.equalsIgnoreCase("N") || strChoice.equalsIgnoreCase("n"));
    }
}
