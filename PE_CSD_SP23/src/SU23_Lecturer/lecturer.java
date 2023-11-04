/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SU23_Lecturer;

/**
 *
 * @author Acer
 */
public class lecturer {
    int teaching_code;
    int teaching_hours;

    public lecturer(int teaching_code, int teaching_hours) {
        this.teaching_code = teaching_code;
        this.teaching_hours = teaching_hours;
    }

    public int getTeaching_code() {
        return teaching_code;
    }

    public void setTeaching_code(int teaching_code) {
        this.teaching_code = teaching_code;
    }

    public int getTeaching_hours() {
        return teaching_hours;
    }

    public void setTeaching_hours(int teaching_hours) {
        this.teaching_hours = teaching_hours;
    }

    @Override
    public String toString() {
        return "lecturer{" + "teaching_code=" + teaching_code + ", teaching_hours=" + teaching_hours + '}';
    }
    
}
