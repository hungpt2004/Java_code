/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p0021;

/**
 *
 * @author Acer
 */
public class student {
    private String id;
    private String name;
    private int semester;
    private String nameCourse;

    public student() {
    }

    public student(String id, String name, int semester, String nameCourse) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.nameCourse = nameCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse =  nameCourse;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + ", semester=" + semester + ", courseName=" + nameCourse + '}';
    }
    
}
