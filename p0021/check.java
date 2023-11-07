/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p0021;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class check {

    //Check user
    //If same ID but differ Name is wrong
    public static boolean checkExistUser(String name) {
        for (var i = 0; i < P0021.studentList.size(); i++) {
            if (P0021.studentList.get(i).getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    //Check ID
    //Check ID are already exists
    public static boolean checkExistID(String id) {
        for (int i = 0; i < P0021.studentList.size(); i++) {
            if (P0021.studentList.get(i).getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    //Check positive Integer
    public static int inputInteger(String message) {
        int num;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                num = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid number ! Try agiain");
            }
        }
        return num;
    }

    //Check name
    public static String inputName(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String name;
        boolean checkID;
        do {
            checkID = true;
            name = scanner.nextLine();
            name = name.trim(); //xóa khoảng trống dư 
            name = name.replaceAll("\\s+", " ");//thay tất cả các khoảng trống bằng một khoảng trống " "
            if (!name.matches("[a-zA-Z\\s]+")) { //kí tự tên chỉ gồm các chữ thường và chữ hoa
                checkID = false;
                System.out.println("You must enter character without special symbols or digit");
            }
        } while (!checkID);
        return name;
    }

    //Check CourseName
    public static String inputCourseName(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String course;
        boolean checkID;
        do {
            checkID = true;
            course = scanner.nextLine();
            course = course.trim(); //xóa khoảng trống dư 
            course = course.replaceAll("\\s+", " ");//thay tất cả các khoảng trống bằng một khoảng trống " "
            if (!(course.matches("Java")
                    || course.matches(".Net")
                    || course.matches("C/C\\++?"))) {
                checkID = false;
                System.out.println("Just have 3 courses are : Java | .Net | C/C++");
                System.out.println("Try again ! ");
            }
        } while (!checkID);
        return course;
    }

    //Check ID
    public static String inputID(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String code;
        boolean checkID;
        do {
            checkID = true;
            code = scanner.nextLine();
            code = code.trim();
            code = code.replaceAll("\\s+", " ");
            if (!code.matches("\\d+")) {
                checkID = false;
                System.out.println("Try again, invalid ID ! ");
            }
        } while (!checkID);
        return code;
    }
    
    
    //Check String
    public static String inputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String string;
        boolean checkID;
        do {
            checkID = true;
            string = scanner.nextLine();
            string = string.trim(); //xóa khoảng trống dư 
            string = string.replaceAll("\\s+", " ");//thay tất cả các khoảng trống bằng một khoảng trống " "
            if (!string.matches("[a-zA-Z\\s]+")) { //kí tự tên chỉ gồm các chữ thường và chữ hoa
                checkID = false;
                System.out.println("You must enter character without special symbols or digit");
            }
        } while (!checkID);
        return string;
    }
}
